package residencia.visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import residencia.clases.Trabajador;
import residencia.excepciones.UsuarioNoExiste;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


/**
 * Clase que permitira iniciar sesion al trabajador y poder acceder al menu correcpondiente 
 */
public class LoginEmpleado extends JFrame {

	private ArrayList<Trabajador> empleadoBD = new ArrayList<Trabajador>();
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;



	/**
	 * Create the frame.
	 */
	public LoginEmpleado(ArrayList<Trabajador> empleado) {
		
		this.empleadoBD= empleado;
		
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
		
		JCheckBox chckbxDirector = new JCheckBox("Director");
		chckbxDirector.setBounds(15, 199, 139, 29);
		contentPane.add(chckbxDirector);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario = textField.getText();
				String password = passwordField.getText();
				try {
					boolean encontrado = comprobarEmpleado(usuario, password);
					if (encontrado){
						if (chckbxDirector.isSelected()){
							LoginEmpleado.this.setVisible(false);
							MenuDirector menuDirector = new MenuDirector();
							menuDirector.setVisible(true);
						}else{
							LoginEmpleado.this.setVisible(false);
							MenuEmpleado menuEmpleado = new MenuEmpleado();
							menuEmpleado.setVisible(true);
						}
					}
				} catch (UsuarioNoExiste e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
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
				RegistroEmpleado registroEmpleado = new RegistroEmpleado(empleado);
				registroEmpleado.setVisible(true);
			}
		});
		btnRegistrarse.setBounds(265, 199, 115, 29);
		contentPane.add(btnRegistrarse);
		

		
		
	}
	public boolean comprobarEmpleado(String usuario, String password) throws UsuarioNoExiste{
		boolean existencia = false;
		
		for (Trabajador a: empleadoBD){
			if(a.getUsuario().equals(usuario)){
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
