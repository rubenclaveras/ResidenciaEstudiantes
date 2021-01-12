package residencia.visual;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import residencia.clases.Estudiante;
import residencia.clases.Habitacion;
import residencia.clases.Trabajador;
import residencia.excepciones.Excepciones;
import residencia.junit.EstudianteBDTest;
import residencia.logica.datos.CrearBD;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RegistroEstudiante extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField dni;
	private JTextField usuario;
	private JTextField contrasenia;
	private static ArrayList<Estudiante> estudianteBD = new ArrayList<Estudiante>();
	private static ArrayList<Habitacion> habitacionBD = new ArrayList<Habitacion>();
	private String[] codEstudiante = new String[23];
	private JLabel fondo;
	
	


	/**
	 * Create the frame.
	 */
	public RegistroEstudiante(ArrayList<Estudiante> estudiantes, ArrayList<Habitacion> habitacion) {
		codEstudiante[0]="ES0001";
		codEstudiante[1]="ES0002";
		codEstudiante[2]="ES0003";
		codEstudiante[3]="ES0004";
		codEstudiante[4]="ES0005";
		codEstudiante[5]="ES0006";
		codEstudiante[6]="ES0007";
		codEstudiante[7]="ES0008";
		codEstudiante[8]="ES0009";
		codEstudiante[9]="ES0010";
		codEstudiante[10]="ES0011";
		codEstudiante[11]="ES0012";
		codEstudiante[12]="ES0013";
		codEstudiante[13]="ES0014";
		codEstudiante[14]="ES0015";
		codEstudiante[15]="ES0016";
		codEstudiante[15]="ES0017";
		codEstudiante[16]="ES0018";
		codEstudiante[17]="ES0019";
		codEstudiante[18]="ES0020";
		codEstudiante[19]="ES0021";
		codEstudiante[20]="ES0022";
		codEstudiante[21]="ES0023";
		codEstudiante[22]="ES0024";
		
		RegistroEstudiante.estudianteBD = estudiantes;
		RegistroEstudiante.habitacionBD = habitacion;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//poner fondo
		((JPanel) getContentPane()).setOpaque(false);
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("imagenes/Estudiantes.jpg"));
				
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(31, 42, 102, 20);
		contentPane.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombre.setBounds(167, 33, 163, 41);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDni.setBounds(31, 131, 69, 20);
		contentPane.add(lblDni);
		
		dni = new JTextField();
		dni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dni.setBounds(167, 122, 163, 41);
		contentPane.add(dni);
		dni.setColumns(10);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(31, 221, 121, 20);
		contentPane.add(lblUsuario);
		
		usuario = new JTextField();
		usuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usuario.setBounds(167, 212, 163, 41);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("CONTRASE\u00D1A:");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasenia.setBounds(31, 303, 136, 20);
		contentPane.add(lblContrasenia);
		
		contrasenia = new JTextField();
		contrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contrasenia.setBounds(167, 294, 163, 41);
		contentPane.add(contrasenia);
		contrasenia.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codEstudiante = null;
				codEstudiante = asignarCodEstudiante();
				String Nombre = nombre.getText();
				String DNI = dni.getText();
				String Usuario = usuario.getText();
				String Contrasenia = contrasenia.getText();
				int numeroHabitacion = 0;
				try {
					numeroHabitacion = asignarHabitacion();
				} catch (Excepciones e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				int salario = 0;
				try {
					salario = calcularCuota(numeroHabitacion);
				} catch (Excepciones e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				boolean UCorrecto = false;
				try {
					UCorrecto = comprobarEstudiante(Usuario);
				} catch (Excepciones e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(UCorrecto){
					int indice=0;
					boolean DCorrecto= comprobarDNI(DNI, indice);
					if(DCorrecto){
						CrearBD base = new CrearBD("ResidenciaEstudiantes.db");
						base.createLink();
						residencia.logica.datos.EstudianteBD.insertarEstudiante(base.getConn(), codEstudiante,
								Nombre, DNI, salario, numeroHabitacion, Usuario, Contrasenia);
						base.closeLink();
						JOptionPane.showMessageDialog(null, "Registro completado correctamente");
						
						RegistroEstudiante.this.setVisible(false);
						EnviarCorreo enviarCorreo= new  EnviarCorreo(Nombre, DNI, Usuario, Contrasenia);
						enviarCorreo.setVisible(true);
					}
				}
			}
		});
		btnAceptar.setBounds(401, 238, 136, 51);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e-> {
				RegistroEstudiante.this.setVisible(false);
				PaginaPrincipal paginaPrincipal= new PaginaPrincipal();
				paginaPrincipal.setVisible(true);
		});
		btnCancelar.setBounds(401, 289, 136, 51);
		contentPane.add(btnCancelar);
		
		fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.TOP);
		fondo.setHorizontalAlignment(SwingConstants.RIGHT);
		fondo.setIcon(imagen);
		getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
		fondo.setBounds(-24, -16, 600, 412);
		getContentPane().add(fondo, BorderLayout.CENTER);
	}
	
	/**
	 * Método para comprobar si el registro es correcto, no se puede utilizar un nombre de usuario que ya esté en uso
	 * @param usuario
	 * @return UsuarioCorrecto, true si es correcto, false si no lo es
	 * @throws Excepciones
	 */
	public static boolean comprobarEstudiante(String usuario) throws Excepciones {
		boolean UsuarioCorrecto = true;
		
		for (Estudiante e: estudianteBD){
			if(e.getUsuario().equals(usuario)){
				UsuarioCorrecto = false;
				break;
			}
		}
		if(UsuarioCorrecto == true){
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "Usuario ya registrado");
			throw new Excepciones ("Usuario ya esitente ");
		}
	}
	
	/**
	 * Método para comprobar si el DNI es correcto, al ser un número único no puede coincidir con uno ya reegistrado en la base de datos
	 * @param DNI
	 * @param indice
	 * @return DNICorrecto, true si es correcto, false si es incorrecto
	 */
	public static boolean comprobarDNI(String DNI, int indice) {
		boolean DNICorrecto = false;
		
		if (indice==estudianteBD.size()){
			DNICorrecto = true;
		}else{
			if (DNI.equals(estudianteBD.get(indice).DNI)){
				JOptionPane.showMessageDialog(null, "DNI ya registrado");
				DNICorrecto = false;
			}else{
				comprobarDNI (DNI, indice+1);
			}
		}
		return DNICorrecto;
	}
	
	/**
	 * Método para asignar el código, este es un identificador único.
	 * Para ello, se dispone de una lista con todos los códigos disponibles (la residencia tiene un límite de aforo de 23 estudiantes)
	 * Se mirará el numero de estudiantes que hay, y se cogerá de la lista de codigos el siguiente disponible
	 * @return numEstudiantes, el codigo a emplear
	 */
	public String asignarCodEstudiante(){
		String numEstudiante = null;
		int i =estudianteBD.size();
		numEstudiante= codEstudiante[i];
		return numEstudiante;	
	}
	
	/**
	 * Método para asignar una habitación a los nuevos estudiantes
	 * @return numHabitacion, el numero de la habitacion que ocupará
	 * @throws Excepciones
	 */
	public static int asignarHabitacion() throws Excepciones {
		int numHabitacion = 1;
		for(Habitacion h: habitacionBD){
			if (h.isEstaOcupada() == false){
				numHabitacion = h.getNumero();
				break;
			}
		}
		if(numHabitacion!= 0){
			return numHabitacion;
		}else{
			throw new Excepciones ("Todas las habitaciones estan ocupadas en este instante");
		}
	
	}
	
	/**
	 * Método para calcular la cuota a pagar por el estudiante, en función de si su habitación es doble o individual
	 * @param numeroHabitacion
	 * @return cuota, cantidad a pagar anualmente
	 * @throws Excepciones
	 */
	public static int calcularCuota(int numeroHabitacion) throws Excepciones {
		int cuota = 0;
		for(Habitacion h: habitacionBD){
			if(h.getNumero()== numeroHabitacion){
				if(h.getTipo().equals("Individual")){
					cuota=  5400;//450 X 12
					break;
				}else if(h.getTipo().equals("Doble")){
					cuota = 4200; //350 X 12
					break;
				}
				
			}
		}
		if(cuota!=0){
			return cuota;
		}else{
			throw new Excepciones ("No se ha podido calcular el salario");
		}
		
		
		
		
	}
	
	
}