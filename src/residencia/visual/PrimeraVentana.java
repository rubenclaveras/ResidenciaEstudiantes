package residencia.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class PrimeraVentana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeraVentana frame = new PrimeraVentana();
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
	public PrimeraVentana() {
		setBackground(new Color(135, 206, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(15, 44, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(15, 115, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(15, 16, 69, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(15, 86, 139, 20);
		contentPane.add(lblContrasea);
		
		JCheckBox chckbxEstudiante = new JCheckBox("Estudiante");
		chckbxEstudiante.setBackground(new Color(135, 206, 250));
		chckbxEstudiante.setBounds(15, 169, 105, 29);
		contentPane.add(chckbxEstudiante);
		
		JCheckBox chckbxEmpleado = new JCheckBox("Empleado");
		chckbxEmpleado.setBackground(new Color(135, 206, 250));
		chckbxEmpleado.setBounds(127, 169, 114, 29);
		contentPane.add(chckbxEmpleado);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setBackground(new Color(211, 211, 211));
		btnEntrar.setBounds(15, 210, 115, 29);
		contentPane.add(btnEntrar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(211, 211, 211));
		btnSalir.setBounds(141, 210, 115, 29);
		contentPane.add(btnSalir);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBackground(new Color(211, 211, 211));
		btnRegistrarse.setBounds(298, 210, 115, 29);
		contentPane.add(btnRegistrarse);
		
		JCheckBox chckbxAdministrador = new JCheckBox("Administrador");
		chckbxAdministrador.setBackground(new Color(135, 206, 250));
		chckbxAdministrador.setBounds(239, 169, 139, 29);
		contentPane.add(chckbxAdministrador);
	}
}
