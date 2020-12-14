package residencia.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import residencia.clases.Estudiante;
import residencia.clases.Trabajador;
import residencia.excepciones.DniIncorrecto;
import residencia.excepciones.UsuarioExistente;
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


	/**
	 * Create the frame.
	 */
	public RegistroEstudiante(ArrayList<Estudiante> estudiantes) {
		this.estudianteBD = estudiantes;
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
				String Nombre = nombre.getText();
				String DNI = dni.getText();
				String Usuario = usuario.getText();
				String Contrasenia = contrasenia.getText();
				
				try {
					boolean UCorrecto = comprobarEstudiante(Usuario, Contrasenia);
					if(UCorrecto){
						boolean DCorrecto= comprobarDNI(DNI);
						if(DCorrecto){
							CrearBD base = new CrearBD("ResidenciaEstudiantes.db");
							base.createLink();
							residencia.logica.datos.EstudianteBD.insertarEstudiante(base.getConn(), "susb",
									Nombre, DNI, 10293, 103, Usuario, Contrasenia);
							base.closeLink();
						}
					}
					
					
				} catch (UsuarioExistente e1) {
					e1.printStackTrace();
				} catch (DniIncorrecto e1) {
					// TODO Auto-generated catch block
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
	
	
	public boolean comprobarEstudiante(String usuario, String password) throws UsuarioExistente{
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
			throw new UsuarioExistente("Usuario o contrasenya existente, por favor cambielas");
		}
	}
	
	public boolean comprobarDNI(String DNI) throws DniIncorrecto{
		boolean DNICorrecto = true;
		for (Estudiante e: estudianteBD){
			if(e.getDNI().equals(DNI)){
				DNICorrecto = false;
				break;
			}
		}if (DNICorrecto = true){
			return true;
		}else{
			throw new DniIncorrecto("DNI existente");
		}
	}
}

}