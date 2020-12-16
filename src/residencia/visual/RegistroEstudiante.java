package residencia.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import residencia.clases.Estudiante;
import residencia.clases.Habitacion;
import residencia.excepciones.Excepciones;
import residencia.logica.datos.CrearBD;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * Clase que muestra una ventana en la cual el estudiante podra registrarse metiendo sus datos, los cuales e guardaran en la base de datos
 */
public class RegistroEstudiante extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField usuario;
	private JTextField contrasenia;
	private JTextField dni;
	private ArrayList<Estudiante> estudianteBD = new ArrayList<Estudiante>();
	private ArrayList<Habitacion> habitacionBD = new ArrayList<Habitacion>();
	private String[] codEstudiante = new String[23];


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
		codEstudiante[16]="ES0017";
		codEstudiante[17]="ES0018";
		codEstudiante[18]="ES0019";
		codEstudiante[19]="ES0020";
		codEstudiante[20]="ES0021";
		codEstudiante[21]="ES0022";
		codEstudiante[22]="ES0023";
		codEstudiante[23]="ES0024";
		
		this.estudianteBD = estudiantes;
		this.habitacionBD = habitacion;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(15, 36, 69, 20);
		contentPane.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(122, 33, 146, 26);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(15, 90, 69, 20);
		contentPane.add(lblUsuario);
		
		usuario = new JTextField();
		usuario.setBounds(122, 87, 146, 26);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setBounds(15, 140, 93, 20);
		contentPane.add(lblContrasenia);
		
		contrasenia = new JTextField();
		contrasenia.setBounds(122, 137, 146, 26);
		contentPane.add(contrasenia);
		contrasenia.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(15, 182, 69, 20);
		contentPane.add(lblDni);
		
		dni = new JTextField();
		dni.setBounds(122, 179, 146, 26);
		contentPane.add(dni);
		dni.setColumns(10);
		
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
				} catch (Excepciones e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				int salario = 0;
				try {
					salario = calcularSalario(numeroHabitacion);
				} catch (Excepciones e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					boolean UCorrecto = comprobarEstudiante(Usuario, Contrasenia);
					if(UCorrecto){
						boolean DCorrecto= comprobarDNI(DNI);
						if(DCorrecto){
							CrearBD base = new CrearBD("ResidenciaEstudiantes.db");
							base.createLink();
							residencia.logica.datos.EstudianteBD.insertarEstudiante(base.getConn(), codEstudiante,
									Nombre, DNI, salario, numeroHabitacion, Usuario, Contrasenia);
							base.closeLink();
						}
					}
					
					
				} catch (Excepciones e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnAceptar.setBounds(298, 70, 115, 29);
		contentPane.add(btnAceptar);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroEstudiante.this.dispose();
			}
		});
		btnCancelar.setBounds(298, 140, 115, 29);
		contentPane.add(btnCancelar);
		
		
	}
	
	
	public boolean comprobarEstudiante(String usuario, String password) throws Excepciones{
		boolean UsuarioCorrecto = true;
		
		for (Estudiante e: estudianteBD){
			if(e.getUsuario().equals(usuario)){
				UsuarioCorrecto = false;
				break;
			}else{
				if(e.getContrasenia().equals(password)){
					UsuarioCorrecto = false;
					break;
				}
			}
		}
		if (UsuarioCorrecto==true){
			return true;
		}else{
			throw new Excepciones("Usuario o contrasenya existente, por favor cambielas");
		}
	}
	
	public boolean comprobarDNI(String DNI) throws Excepciones{
		boolean DNICorrecto = true;
		for (Estudiante e: estudianteBD){
			if(e.getDNI().equals(DNI)){
				DNICorrecto = false;
				break;
			}
		}if (DNICorrecto = true){
			return true;
		}else{
			throw new Excepciones("El DNI introducido ya existe");
		}
	}
	
	
	public String asignarCodEstudiante(){
		String numEstudiante = null;
		int i;
		for(i=0;i<=codEstudiante.length;i++){
			for(Estudiante e: estudianteBD){
				if(!codEstudiante[i].equals(e.getCodigoEstudiante())){
					numEstudiante = codEstudiante[i];
				}
			}
			if(numEstudiante!= null){
				break;				
			}
		}
		return numEstudiante;	
	}
	
	public int asignarHabitacion() throws Excepciones{
		int numHabitacion = 0;
		for(Habitacion h: habitacionBD){
			if(h.isEstaOcupada()== false){
				numHabitacion= h.getNumero();
				break;
			}
		}if(numHabitacion!= 0){
			return numHabitacion;
		}else{
			throw new Excepciones ("Todas las habitaciones estan ocupadas");
		}
		
	}
	
	
	public int calcularSalario(int numeroHabitacion) throws Excepciones{
		int salario = 0;
		for(Habitacion h: habitacionBD){
			if(h.getNumero()== numeroHabitacion){
				if(h.getTipo().equals("Individual")){
					salario=  5400;//450 X 12
					break;
				}else if(h.getTipo().equals("Doble")){
					salario = 4200; //350 X 12
					break;
				}
				
			}
		}if(salario!=0){
			return salario;
		}else{
			throw new Excepciones("No se ha podido calcular el salario");
		}
		
		
		
	}
	
	
}

