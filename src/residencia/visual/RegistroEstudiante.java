package residencia.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase que muestra una ventana en la cual el estudiante podra registrarse metiendo sus datos, los cuales e guardaran en la base de datos
 */
public class RegistroEstudiante extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField apellidos;
	private JTextField usuario;
	private JTextField contrasenia;
	private JTextField dni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroEstudiante frame = new RegistroEstudiante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroEstudiante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(15, 16, 69, 20);
		contentPane.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(122, 13, 146, 26);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(15, 58, 93, 20);
		contentPane.add(lblApellidos);
		
		apellidos = new JTextField();
		apellidos.setBounds(122, 55, 146, 26);
		contentPane.add(apellidos);
		apellidos.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(15, 98, 69, 20);
		contentPane.add(lblUsuario);
		
		usuario = new JTextField();
		usuario.setBounds(122, 97, 146, 26);
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
		btnAceptar.setBounds(298, 70, 115, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(298, 140, 115, 29);
		contentPane.add(btnCancelar);
		
		
	}

}