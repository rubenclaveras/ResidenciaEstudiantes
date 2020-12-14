package residencia.visual;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import residencia.clases.Estudiante;
import residencia.excepciones.UsuarioNoExiste;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

/**
 * Clase que permitira iniciar sesion al estudiante y poder acceder al menu correcpondiente 
 */
public class LoginEstudiante extends JFrame {
	
	private ArrayList<Estudiante> estudianteBD = new ArrayList<Estudiante>();
	private JPanel contentPane;
	private JTextField usuarioField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public LoginEstudiante(ArrayList<Estudiante> estudiantes) {
		this.estudianteBD= estudiantes;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(25, 16, 69, 20);
		contentPane.add(lblUsuario);
		
		usuarioField = new JTextField();
		usuarioField.setBounds(25, 52, 146, 26);
		contentPane.add(usuarioField);
		usuarioField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(25, 106, 132, 20);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(25, 153, 146, 26);
		contentPane.add(passwordField);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = usuarioField.getText();
				String password = passwordField.getText();
				
				try {
					boolean encontrado = comprobarEstudiante(usuario, password);
					if (encontrado){
						LoginEstudiante.this.setVisible(false);
						MenuEstudiante menuEstudiante = new MenuEstudiante();
						menuEstudiante.setVisible(true);
					}
					
				} catch (UsuarioNoExiste e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		btnAceptar.setBounds(260, 51, 115, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEstudiante.this.setVisible(false);
				PaginaPrincipal paginaPrincipal= new PaginaPrincipal();
				paginaPrincipal.setVisible(true);
			}
		});
		btnCancelar.setBounds(260, 108, 115, 29);
		contentPane.add(btnCancelar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEstudiante.this.setVisible(false);
				RegistroEstudiante registroEstudiante = new RegistroEstudiante(estudiantes);
				registroEstudiante.setVisible(true);
			}
		});
		btnRegistrarse.setBounds(260, 179, 115, 29);
		contentPane.add(btnRegistrarse);
		
		
		
	}
	
	public boolean comprobarEstudiante(String usuario, String password) throws UsuarioNoExiste{
		boolean existencia = false;
		
		for (Estudiante a: estudianteBD){
			if (a.getUsuario().equals(usuario)){
				existencia = true;
				break;

			}else{
				if(a.getContrasenia().equals(password)){
					existencia = true;
					break;
				}
			}
		}
		
		if (existencia==true){
			return true;
		}else{
			throw new UsuarioNoExiste("Usuario o contrasenya no Existente");
		}
	}

}