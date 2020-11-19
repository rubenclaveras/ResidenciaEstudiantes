package residencia.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase que muestra la ventana principal del programa y direcciona a las siguientes ventanas
 */
public class PaginaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaPrincipal frame = new PaginaPrincipal();
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
	public PaginaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEmpleado = new JButton("Empleado");
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEmpleado loginEmpleado = new LoginEmpleado();
				loginEmpleado.setVisible(true);
				PaginaPrincipal.this.setVisible(false);
			}
		});
		btnEmpleado.setBounds(36, 55, 128, 53);
		contentPane.add(btnEmpleado);
		
		JButton btnEstudiante = new JButton("Estudiante");
		btnEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEstudiante loginEstudiante = new LoginEstudiante();
				loginEstudiante.setVisible(true);
				PaginaPrincipal.this.setVisible(false);
			}
		});
		btnEstudiante.setBounds(246, 55, 128, 53);
		contentPane.add(btnEstudiante);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaPrincipal.this.dispose();
			}
		});
		btnSalir.setBounds(145, 160, 135, 53);
		contentPane.add(btnSalir);
	}

}

