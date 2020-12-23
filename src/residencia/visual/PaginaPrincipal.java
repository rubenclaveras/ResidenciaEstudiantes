package residencia.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import residencia.clases.Estudiante;
import residencia.clases.Habitacion;
import residencia.clases.SalonComunitario;
import residencia.clases.Trabajador;
import residencia.logica.datos.CrearBD;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;

/**
 * Clase que muestra la ventana principal del programa y direcciona a las siguientes ventanas
 */
public class PaginaPrincipal extends JFrame {
	
	

	private JPanel contentPane;
	private ArrayList<Estudiante> estudiantes;
	private ArrayList<Trabajador> empleado;
	private ArrayList<Habitacion> habitacion;
	private ArrayList<SalonComunitario> salonComunitario;
	private JLabel fondo;

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
		setForeground(SystemColor.activeCaptionText);
		
		
		
		CrearBD base = new CrearBD("ResidenciaEstudiantes.db");
		base.createLink();
		
		estudiantes = residencia.logica.datos.EstudianteBD.seleccionEstudiantes(base.getConn());
		empleado = residencia.logica.datos.EmpleadoBD.seleccionEmpleados(base.getConn());
		habitacion = residencia.logica.datos.HabitacionBD.seleccionHabitaciones(base.getConn());
		salonComunitario = residencia.logica.datos.SalonBD.seleccionSalones(base.getConn());
		
		base.closeLink();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//poner fondo
		((JPanel) getContentPane()).setOpaque(false);
        ImageIcon imagen = new ImageIcon(this.getClass().getResource("imagenes/Imagen1.jpg"));
		
		JButton btnEmpleado = new JButton("Empleado");
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEmpleado loginEmpleado = new LoginEmpleado(empleado, estudiantes);
				loginEmpleado.setVisible(true);
				PaginaPrincipal.this.setVisible(false);
			}
		});
		btnEmpleado.setBounds(15, 311, 128, 29);
		contentPane.add(btnEmpleado);
		
		JButton btnEstudiante = new JButton("Estudiante");
		btnEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEstudiante loginEstudiante = new LoginEstudiante(estudiantes, habitacion, salonComunitario);
				loginEstudiante.setVisible(true);
				PaginaPrincipal.this.setVisible(false);
			}
		});
		btnEstudiante.setBounds(147, 311, 128, 29);
		contentPane.add(btnEstudiante);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaPrincipal.this.dispose();
			}
		});
		btnSalir.setBounds(428, 311, 135, 29);
		contentPane.add(btnSalir);
		
		fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.TOP);
		fondo.setHorizontalAlignment(SwingConstants.RIGHT);
		fondo.setIcon(imagen);
		getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
		fondo.setBounds(-24, -16, 600, 412);
		getContentPane().add(fondo, BorderLayout.CENTER);
	}
}