package residencia.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


/**
 * Clase que permitira iniciar sesion al trabajador y poder acceder al menu correcpondiente 
 */
public class LoginEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginEmpleado frame = new LoginEmpleado();
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
	public LoginEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(15, 19, 104, 20);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(15, 55, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(15, 97, 128, 20);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(15, 146, 146, 26);
		contentPane.add(passwordField);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEmpleado.this.setVisible(false);
				MenuEmpleado menuEmpleado = new MenuEmpleado();
				menuEmpleado.setVisible(true);
			}
		});
		btnAceptar.setBounds(265, 34, 115, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEmpleado.this.setVisible(false);
				PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
				paginaPrincipal.setVisible(true);
			}
		});
		btnCancelar.setBounds(265, 98, 115, 29);
		contentPane.add(btnCancelar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEmpleado.this.setVisible(false);
				RegistroEmpleado registroEmpleado = new RegistroEmpleado();
				registroEmpleado.setVisible(true);
			}
		});
		btnRegistrarse.setBounds(265, 199, 115, 29);
		contentPane.add(btnRegistrarse);
		
		JCheckBox chckbxDirector = new JCheckBox("Director");
		chckbxDirector.setBounds(15, 199, 139, 29);
		contentPane.add(chckbxDirector);
		
		
	}
}

