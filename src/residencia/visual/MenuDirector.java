package residencia.visual;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import residencia.clases.Estudiante;
import residencia.clases.Trabajador;
import residencia.logica.datos.CrearBD;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * Clase que muestra una ventana que sera el menu de las diversas acciones que podra realizar el director
 */
public class MenuDirector extends JFrame {

	private JPanel contentPane;
	private ArrayList<Trabajador> empleadoBD = new ArrayList<Trabajador>();
	private ArrayList<Estudiante> estudianteBD = new ArrayList<Estudiante>();
	private JLabel fondo;
	
	/**
	 * Launch the application.
	 */

	public MenuDirector(String usuario, String password, ArrayList<Trabajador> empleado, ArrayList<Estudiante> estudiantes) {
		this.empleadoBD = empleado;
		this.estudianteBD = estudiantes;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//poner fondo
		((JPanel) getContentPane()).setOpaque(false);
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("imagenes/Director.jpg"));
				
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(201, 13, -184, 215);
		contentPane.add(scrollPane);
		
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		int i=0;
		for(Trabajador a: empleadoBD){
			model.add(i, a.getNombre());
			i++;
		}
		
		DefaultListModel<String> model_1 = new DefaultListModel<String>();
		int x=0;
		for(Estudiante c: estudianteBD){
			model_1.add(x, c.getNombre());
			x++;
		}
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setBounds(15, 16, 203, 324);
		contentPane.add(list);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDirector.this.dispose();
			}
		});
		btnSalir.setBounds(343, 286, 190, 54);
		contentPane.add(btnSalir);
		
		fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.TOP);
		fondo.setHorizontalAlignment(SwingConstants.RIGHT);
		fondo.setIcon(imagen);
		getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
		fondo.setBounds(-24, -16, 600, 412);
		getContentPane().add(fondo, BorderLayout.CENTER);
		
		JButton btnVerEstudiantes = new JButton("Ver Estudiantes");
		btnVerEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setModel(model_1);

			}
		});
		btnVerEstudiantes.setBounds(243, 13, 170, 29);
		contentPane.add(btnVerEstudiantes);
		
		JButton btnVerEmpleados = new JButton("Ver Empleados");
		btnVerEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setModel(model);
			}
		});
		btnVerEmpleados.setBounds(243, 58, 170, 29);
		contentPane.add(btnVerEmpleados);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = (String)list.getSelectedValue();
				for(Trabajador a: empleadoBD){
					if(nombre.equals(a.getNombre())){
						CrearBD base = new CrearBD("ResidenciaEstudiantes.db");
						base.createLink();
						residencia.logica.datos.EmpleadoBD.borrarEmpleado(base.getConn(), a.getCodigoTrabajador());
						base.closeLink();
					}
				}
				for (Estudiante c: estudianteBD){
					if(nombre.equals(c.getNombre())){
						CrearBD base = new CrearBD("ResidenciaEstudiantes.db");
						base.createLink();
						residencia.logica.datos.EstudianteBD.borrarEstudiante(base.getConn(), c.codigoEstudiante);
						base.closeLink();
					}
				}
			}
		});
		btnEliminar.setBounds(243, 103, 170, 29);
		contentPane.add(btnEliminar);
		
		JButton btnVerTusDatos = new JButton("Ver tus datos");
		btnVerTusDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Trabajador a: empleadoBD){
					if(a.getUsuario().equals(usuario) || a.getContrasenia().equals(password)){
						JOptionPane.showMessageDialog(null, "Nombre: " + a.getNombre() +"\n" +
					"Codigo: " + a.getCodigoTrabajador() + "\n" +
					"Dni: " + a.getDNI() + "\n" + 
					"Funcion: "+a.getFuncion()+ "\n" +
					"Salario: " + a.getSalario()+ "\n" +
					"Usuario: " + a.getUsuario() + "\n" +
					"Contraseña: " + a.getContrasenia());
					}
				}
			}
		});
		btnVerTusDatos.setBounds(243, 154, 170, 29);
		contentPane.add(btnVerTusDatos);
		


	}
}