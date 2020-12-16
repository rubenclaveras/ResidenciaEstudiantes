package residencia.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import residencia.clases.Estudiante;
import residencia.clases.SalonComunitario;
import residencia.clases.Trabajador;
import residencia.logica.datos.CrearBD;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

/**
 * Clase que muestra una ventana que sera el menu de las diversas acciones que podra realizar el director
 */
public class MenuDirector extends JFrame {

	private JPanel contentPane;
	private ArrayList<Trabajador> empleadoBD = new ArrayList<Trabajador>();
	private ArrayList<Estudiante> estudianteBD = new ArrayList<Estudiante>();

	/**
	 * Launch the application.
	 */

	public MenuDirector(String usuario, String password, ArrayList<Trabajador> empleado, ArrayList<Estudiante> estudiantes) {
		this.empleadoBD = empleado;
		this.estudianteBD = estudiantes;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JList list;

		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDirector.this.dispose();
			}
		});
		btnSalir.setBounds(243, 199, 170, 29);
		contentPane.add(btnSalir);
		
		JButton btnVerEstudiantes = new JButton("Ver Estudiantes");
		btnVerEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list = new JList(model_1);
				list.setBounds(15, 16, 203, 212);
				contentPane.add(list);
			}
		});
		btnVerEstudiantes.setBounds(243, 13, 170, 29);
		contentPane.add(btnVerEstudiantes);
		
		JButton btnVerEmpleados = new JButton("Ver Empleados");
		btnVerEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list = new JList(model);
				list.setBounds(15, 16, 203, 212);
				contentPane.add(list);
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
