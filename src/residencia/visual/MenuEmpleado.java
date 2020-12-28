package residencia.visual;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import residencia.clases.Trabajador;
import java.awt.Font;;

/**
 * Clase que muestra una ventana que sera el menu de las diversas acciones que podra realizar el trabajador
 */
public class MenuEmpleado extends JFrame {

	private JPanel contentPane;
	private ArrayList<Trabajador> empleadoBD = new ArrayList<Trabajador>();
	private JLabel fondo;



	/**
	 * Create the frame.
	 */
	public MenuEmpleado(String usuario, String password, ArrayList<Trabajador> empleado) {
		this.empleadoBD = empleado;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//poner fondo
		((JPanel) getContentPane()).setOpaque(false);
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("imagenes/Trabajadores.jpg"));

		
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		int i = 0;
		String ocupacion=obtenerOcupacion(usuario, password);
		for(Trabajador a: empleadoBD){
			if(ocupacion.equals(a.getFuncion())){
				model.add(i, a.getNombre());
				i++;
			}
		
		}
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setBounds(15, 16, 204, 324);
		contentPane.add(list);
		
		
		JButton btnListaCompaeros = new JButton("Lista compa\u00F1eros");
		btnListaCompaeros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setModel(model);
			}
		});
		btnListaCompaeros.setBounds(341, 16, 160, 50);
		contentPane.add(btnListaCompaeros);
		
		JButton btnCalcularSalario = new JButton("Calcular salario");
		btnCalcularSalario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Trabajador a: empleadoBD){
					if(a.getUsuario().equals(usuario) || a.getContrasenia().equals(password)){
						int salarioAnual = a.getSalario();
						int numPagas = 14;
						int salarioPorPaga= salarioAnual/numPagas;
						JOptionPane.showMessageDialog(null, "Salario anual: " + salarioAnual + "\n" +
						"Salario por pagas: " + salarioPorPaga + "\n" +
						"Numero de pagas: " + numPagas);
					}
				}

			}
		});
		btnCalcularSalario.setBounds(341, 103, 160, 50);
		contentPane.add(btnCalcularSalario);
		
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
		btnVerTusDatos.setBounds(341, 199, 160, 50);
		contentPane.add(btnVerTusDatos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEmpleado.this.setVisible(false);
				PaginaPrincipal paginaPrincipal= new PaginaPrincipal();
				paginaPrincipal.setVisible(true);
			}
		});
		btnSalir.setBounds(341, 290, 160, 50);
		contentPane.add(btnSalir);
		
		fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.TOP);
		fondo.setHorizontalAlignment(SwingConstants.RIGHT);
		fondo.setIcon(imagen);
		getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
		fondo.setBounds(-24, -16, 600, 412);
		getContentPane().add(fondo, BorderLayout.CENTER);
		

	}
	
	
	public String obtenerOcupacion(String usuario, String password){
		String ocupacion = null;
		for(Trabajador a: empleadoBD){
			if(a.getUsuario().equals(usuario) || a.getContrasenia().equals(password)){
				ocupacion=a.getFuncion();
				break;
			}
		}
		return ocupacion;
	}
}