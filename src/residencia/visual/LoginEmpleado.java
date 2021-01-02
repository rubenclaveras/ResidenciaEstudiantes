package residencia.visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import residencia.clases.Estudiante;
import residencia.clases.Trabajador;
import residencia.excepciones.Excepciones;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;


/**
 * Clase que permitira iniciar sesion al trabajador y poder acceder al menu correcpondiente 
 */
public class LoginEmpleado extends JFrame {

	private ArrayList<Trabajador> empleadoBD = new ArrayList<Trabajador>();
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel fondo;



	/**
	 * Create the frame.
	 */
	public LoginEmpleado(ArrayList<Trabajador> empleado, ArrayList<Estudiante> estudiantes) {
		
		this.empleadoBD= empleado;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//poner fondo
		((JPanel) getContentPane()).setOpaque(false);
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("imagenes/Trabajadores.jpg"));

				
		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(15, 19, 104, 20);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(15, 55, 175, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(15, 113, 128, 20);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(15, 146, 175, 41);
		contentPane.add(passwordField);
		
		JCheckBox chckbxDirector = new JCheckBox("DIRECTOR");
		chckbxDirector.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxDirector.setBackground(SystemColor.inactiveCaption);
		chckbxDirector.setBounds(15, 210, 175, 42);
		contentPane.add(chckbxDirector);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario = textField.getText();
				String password = passwordField.getText();
				boolean encontrado;
				try {
					encontrado = comprobarEmpleado(usuario, password);
					if (encontrado){
						if (chckbxDirector.isSelected()){
							boolean director= comprobarDirector (usuario, password);
							if (director){
								LoginEmpleado.this.setVisible(false);
								MenuDirector menuDirector = new MenuDirector(usuario, password, empleado, estudiantes);
								menuDirector.setVisible(true);
							}else{
								JOptionPane.showMessageDialog(null, "Opción solo disponible para el director");
							}
						}else{
							LoginEmpleado.this.setVisible(false);
							MenuEmpleado menuEmpleado = new MenuEmpleado(usuario, password, empleado);
							menuEmpleado.setVisible(true);
						}
					}
				} catch (Excepciones e1) {
					
					e1.printStackTrace();
				}

			}
		});
		btnAceptar.setBounds(15, 289, 138, 51);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEmpleado.this.setVisible(false);
				PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
				paginaPrincipal.setVisible(true);
			}
		});
		btnCancelar.setBounds(154, 289, 138, 51);
		contentPane.add(btnCancelar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEmpleado.this.setVisible(false);
				RegistroEmpleado registroEmpleado = new RegistroEmpleado(empleado);
				registroEmpleado.setVisible(true);
			}
		});
		btnRegistrarse.setBounds(413, 289, 138, 51);
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
	public boolean comprobarEmpleado(String usuario, String password) throws Excepciones{
		boolean existencia = false;
		boolean usuarioCorrecto=true;
		
		for (Trabajador a: empleadoBD){
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
	/**
	 * Método para comprobar si el empleado es o no el director
	 * Solo el director podrá acceder al menu director, si un empleado intenta acceder sin serlo no podrá
	 * @param usuario
	 * @param password
	 * @return isDirector, true si es el director y false si no lo es
	 */
	public boolean comprobarDirector (String usuario, String password){
		boolean isDirector = false;
		for (Trabajador a: empleadoBD){
			if (a.getUsuario().equals(usuario)){
				if(a.getContrasenia().equals(password)){
					if (a.getFuncion().equals("Director") ){
						isDirector = true;
					}else{
						isDirector = false;
					}
				}
			}
		}
		return isDirector;
	}

}