package residencia.visual;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import residencia.clases.Estudiante;
import residencia.clases.Habitacion;
import residencia.clases.SalonComunitario;
import residencia.logica.datos.CrearBD;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Clase que muestra una ventana que sera el menu de las diversas acciones que podra realizar el estudiante
 */
public class MenuEstudiante extends JFrame {

	private JPanel contentPane;
	private ArrayList<Estudiante> estudianteBD = new ArrayList<Estudiante>();
	private ArrayList<Habitacion> habitacionBD = new ArrayList<Habitacion>();
	private ArrayList<SalonComunitario> salonBD = new ArrayList<SalonComunitario>();
	private JLabel fondo;

	/**
	 * Create the frame.
	 */
	public MenuEstudiante(ArrayList<Estudiante> estudiantes, ArrayList<Habitacion> habitacion,ArrayList<SalonComunitario> salonComunitario, String usuario, String password) {
		this.estudianteBD = estudiantes;
		this.habitacionBD = habitacion;
		this.salonBD = salonComunitario;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//poner fondo
		((JPanel) getContentPane()).setOpaque(false);
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("imagenes/Estudiantes.jpg"));
		
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		int i = 0;
		for(SalonComunitario s: salonBD){
			if(s.isEstaReservada()==false){
				model.add(i, String.valueOf(s.getNumero()));
				i++;
			}
		}
		
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setBounds(15, 16, 205, 324);
		contentPane.add(list);
		
		JButton btnSalonesDisponibles = new JButton("Salones disponibles");
		btnSalonesDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setModel(model);
			}
		});
		btnSalonesDisponibles.setBounds(321, 16, 197, 51);
		contentPane.add(btnSalonesDisponibles);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numSalaComunitaria = Integer.parseInt((String) list.getSelectedValue());
				String codEstu = null;
				for(Estudiante c: estudianteBD){
					if(c.getUsuario().equals(usuario) || c.getContrasenia().equals(password)){
						codEstu = c.getCodigoEstudiante();
						break;
					}
				}
				for(SalonComunitario s: salonBD){
					if(numSalaComunitaria == s.getNumero()){
						CrearBD base = new CrearBD("ResidenciaEstudiantes.db");
						base.createLink();
						residencia.logica.datos.SalonBD.borrarSalon(base.getConn(), s.getNumero());
						residencia.logica.datos.SalonBD.insertarSalon(base.getConn(), s.getNumero(), s.getTipo(), true, codEstu);
						JOptionPane.showMessageDialog(null, "Salon reservado");
						base.closeLink();
					}
				}
			}
		});
		btnReservar.setBounds(321, 88, 197, 51);
		contentPane.add(btnReservar);
		
		JButton btnCalcularCuota = new JButton("Calcular Cuota");
		btnCalcularCuota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Estudiante c: estudianteBD){
					if(c.getUsuario().equals(usuario) || c.getContrasenia().equals(password)){
						int cuotaAnual = c.getCuotaAnual();
						int meses = 12;
						int cuotaPorMes= cuotaAnual/meses;
						JOptionPane.showMessageDialog(null, "Cuota anual: " + cuotaAnual + "\n" +
						"Cuota por mes: " + cuotaPorMes + "\n" +
						"Numero de meses: " + meses);
					}
				}

			}
		});
		btnCalcularCuota.setBounds(321, 155, 197, 51);
		contentPane.add(btnCalcularCuota);
		
		JButton btnVerTusDatos = new JButton("Ver tus datos");
		btnVerTusDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Estudiante c: estudianteBD){
					if(c.getUsuario().equals(usuario) || c.getContrasenia().equals(password)){
						String tipoHabitacion = null;
						for(Habitacion h: habitacionBD){
							if(c.getHabitacion()== h.getNumero()){
								tipoHabitacion= h.getTipo();
								break;
							}
						}
						JOptionPane.showMessageDialog(null, "Nombre: " + c.getNombre() +"\n" +
					"Codigo: " + c.getCodigoEstudiante() + "\n" +
					"Dni: " + c.getDNI() + "\n" + 
					"Numero de habitacion: "+c.getHabitacion()+ "\n" +
					"Tipo de habitacion"+ tipoHabitacion + "\n" +
					"Cuota: " + c.getCuotaAnual()+ "\n" +
					"Usuario: " + c.getUsuario() + "\n" +
					"Contraseña: " + c.getContrasenia());
					}
				}
			}
		});
		btnVerTusDatos.setBounds(321, 222, 197, 51);
		contentPane.add(btnVerTusDatos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEstudiante.this.setVisible(false);
				PaginaPrincipal paginaPrincipal= new PaginaPrincipal();
				paginaPrincipal.setVisible(true);
			}
		});
		btnSalir.setBounds(321, 289, 197, 51);
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