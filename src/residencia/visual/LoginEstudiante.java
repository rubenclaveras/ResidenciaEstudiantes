package residencia.visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import residencia.clases.Estudiante;
import residencia.clases.Habitacion;
import residencia.clases.SalonComunitario;
import residencia.excepciones.Excepciones;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

/**
 * Clase que permitira iniciar sesion al estudiante y poder acceder al menu correcpondiente 
 */
public class LoginEstudiante extends JFrame {
	
	private static ArrayList<Estudiante> estudianteBD = new ArrayList<Estudiante>();
	private JPanel contentPane;
	private JTextField usuarioField;
	private JPasswordField passwordField;
	private JLabel fondo;




	/**
	 * Create the frame.
	 */
	public LoginEstudiante(ArrayList<Estudiante> estudiantes, ArrayList<Habitacion> habitacion, ArrayList<SalonComunitario> salonComunitario) {
		LoginEstudiante.estudianteBD= estudiantes;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//poner fondo
		((JPanel) getContentPane()).setOpaque(false);
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("imagenes/Estudiantes.jpg"));
				

		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(25, 16, 83, 29);
		contentPane.add(lblUsuario);
		
		usuarioField = new JTextField();
		usuarioField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usuarioField.setBounds(25, 52, 169, 38);
		contentPane.add(usuarioField);
		usuarioField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(25, 117, 132, 20);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(25, 153, 169, 38);
		contentPane.add(passwordField);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(e-> {
				String usuario = usuarioField.getText();
				String password = passwordField.getText();
				
				boolean encontrado;
				try {
					encontrado = comprobarEstudiante(usuario, password);
					if (encontrado){
						LoginEstudiante.this.setVisible(false);
						MenuEstudiante menuEstudiante = new MenuEstudiante(estudiantes, habitacion,salonComunitario, usuario, password);
						menuEstudiante.setVisible(true);
					}
				} catch (Excepciones e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		});
		btnAceptar.setBounds(26, 288, 145, 52);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEstudiante.this.setVisible(false);
				PaginaPrincipal paginaPrincipal= new PaginaPrincipal();
				paginaPrincipal.setVisible(true);
			}
		});
		btnCancelar.setBounds(174, 287, 145, 55);
		contentPane.add(btnCancelar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEstudiante.this.setVisible(false);
				RegistroEstudiante registroEstudiante = new RegistroEstudiante(estudiantes, habitacion);
				registroEstudiante.setVisible(true);
			}
		});
		btnRegistrarse.setBounds(407, 287, 145, 55);
		contentPane.add(btnRegistrarse);
		
		fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.TOP);
		fondo.setHorizontalAlignment(SwingConstants.RIGHT);
		fondo.setIcon(imagen);
		getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
		fondo.setBounds(-24, -16, 600, 412);
		getContentPane().add(fondo, BorderLayout.CENTER);
		
		
	}
	/**
	 * Método para comprobar si el login es correcto
	 * Primero se comprueba el usuarios, y a continuación su correspondiente contraseña
	 * Nos avisará, en caso de que el login sea incorrecto, si el problema es por el usuario o la contraseña introducida
	 * @return existencia, true si el login es correcto y false si no lo es
	 */
	public static boolean comprobarEstudiante(String usuario, String password) throws Excepciones{
		boolean existencia = false;
		boolean usuarioCorrecto=true;
		
		for (Estudiante a: estudianteBD){
			if (a.getUsuario().equals(usuario)){
				if(a.getContrasenia().equals(password)){
					existencia = true;
					usuarioCorrecto=true;
					break;
					
				}else{
					usuarioCorrecto=true;
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
					throw new Excepciones ("Contraseña incorrecta");
					
				}

			}else{
				usuarioCorrecto=false;
				existencia=false;
				
			}
		}
		if (usuarioCorrecto==false){
			JOptionPane.showMessageDialog(null, "Usuario incorrecto");
			throw new Excepciones ("Usuario incorrecto");
		}
		return existencia;
	}
			
		
		
		
}
