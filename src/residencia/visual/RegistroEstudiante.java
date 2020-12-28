package residencia.visual;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import residencia.clases.Estudiante;
import residencia.clases.Habitacion;
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
	private ArrayList<Estudiante> estudianteBD = new ArrayList<Estudiante>();
	private ArrayList<Habitacion> habitacionBD = new ArrayList<Habitacion>();
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
		
		this.estudianteBD = estudiantes;
		this.habitacionBD = habitacion;
		
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
				numeroHabitacion = asignarHabitacion();
				int salario = 0;
				salario = calcularSalario(numeroHabitacion);
				
				boolean UCorrecto = comprobarEstudiante(Usuario, Contrasenia);
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
					}
				}
			}
		});
		btnAceptar.setBounds(401, 238, 136, 51);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroEstudiante.this.setVisible(false);
				PaginaPrincipal paginaPrincipal= new PaginaPrincipal();
				paginaPrincipal.setVisible(true);
			}
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
	
	public boolean comprobarEstudiante(String usuario, String password) {
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
		return UsuarioCorrecto;
	}
	
	public boolean comprobarDNI(String DNI, int indice) {
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
	
	
	public String asignarCodEstudiante(){
		String numEstudiante = null;
		int i =estudianteBD.size();
		numEstudiante= codEstudiante[i];
		return numEstudiante;	
	}
	
	public int asignarHabitacion() {
		int numHabitacion = 0;
		for(Habitacion h: habitacionBD){
			if(h.isEstaOcupada()== false){
				numHabitacion= h.getNumero();
				break;
			}
		}
		return numHabitacion;
		
	}
	
	
	public int calcularSalario(int numeroHabitacion) {
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
		}
		return salario;
		
		
		
	}
	
	
}