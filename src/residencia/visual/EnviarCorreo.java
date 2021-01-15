package residencia.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;

/**
 * Clase que permitira recibir un correo de toda la informacion del registro y dara la bienvenida a la residencia  
 * @author Gorka Esteban
 */
public class EnviarCorreo extends JFrame {

	private JPanel contentPane;
	private JTextField txtCorreo;
	private String Nombre;
	private String DNI;
	private String Usuario;
	private String Contrasenia;
	

	/**
	 * Create the frame.
	 * @param Contrasenia 
	 * @param Usuario 
	 * @param DNI 
	 * @param Nombre 
	 */
	public EnviarCorreo(String Nombre, String DNI, String Usuario, String Contrasenia) {
		this.Nombre= Nombre;
		this.DNI= DNI;
		this.Usuario= Usuario;
		this.Contrasenia= Contrasenia;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(15, 84, 69, 20);
		contentPane.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(80, 81, 333, 26);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(e-> {

				Properties props = new Properties();
				props.setProperty("mail.smtp.host", "smtp.gmail.com");
				props.setProperty("mail.smtp.starttls.enable", "true");
				props.setProperty("mail.smtp.port", "587");
				props.setProperty("mail.smtp.auth", "true");

				Session session = Session.getDefaultInstance(props);
				String correoRemitente = "residencia.estudiante.correo@gmail.com";
				String passwordRemitente = "residenciaestudiante";
				String correoReceptor = txtCorreo.getText();
				String asunto = "Bienvenido a nuestra residencia de estudiantes";
				String mensaje = "Saludos, " + Nombre + "\n"
						+"\n"
						+"Se acaba de registrar usted con los siguentes datos. " + "\n"
						+"DNI: " + DNI + "\n"
						+ "Usuario: " + Usuario + "\n"
						+ "Contraseña: " + Contrasenia + "\n"+
						"Si tiene cualquier duda o inconveniente no dude en contactar al correo remitente. Estaremos encantados de solucioner su problema" + "\n"
						+"\n"
						+"Un cordial saludo.";

				MimeMessage message = new MimeMessage(session);
				try {
					message.setFrom(new InternetAddress(correoRemitente));

					message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
					message.setSubject(asunto);
					message.setText(mensaje);

					Transport t = session.getTransport("smtp");
					t.connect(correoRemitente, passwordRemitente);
					t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
					t.close();

					JOptionPane.showMessageDialog(null, "correo enviado correctamente");
				} catch (AddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		});
		btnAceptar.setBounds(62, 175, 115, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnviarCorreo.this.dispose();
				PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
				paginaPrincipal.setVisible(true);
			}
		});
		btnCancelar.setBounds(239, 175, 115, 29);
		contentPane.add(btnCancelar);
	}
}
