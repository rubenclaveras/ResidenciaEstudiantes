package residencia.visual;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.ws.Endpoint;

import residencia.clases.Trabajador;
import residencia.excepciones.Excepciones;
import residencia.logica.datos.CrearBD;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class RegistroEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField dni;
	private JTextField funcion;
	private JTextField usuario;
	private JTextField contrasenia;
	private static ArrayList<Trabajador> empleadoBD = new ArrayList<Trabajador>();
	private String[] codEmpleado = new String[23];
	private JLabel fondo;
	private JLabel lblmantenimientoOLimpieza;


	/**
	 * Create the frame.
	 */
	public RegistroEmpleado(ArrayList<Trabajador> empleado) {
		
		codEmpleado[0]="D0001";
		codEmpleado[1]="EM0002";
		codEmpleado[2]="EM0003";
		codEmpleado[3]="EM0004";
		codEmpleado[4]="EM0005";
		codEmpleado[5]="EM0006";
		codEmpleado[6]="EM0007";
		codEmpleado[7]="EM0008";
		codEmpleado[8]="EM0009";
		codEmpleado[9]="EM0010";
		codEmpleado[10]="EM0011";
		codEmpleado[11]="EM0012";
		codEmpleado[12]="EM0013";
		codEmpleado[13]="EM0014";
		codEmpleado[14]="EM0015";
		codEmpleado[15]="EM0016";
		codEmpleado[15]="EM0017";
		codEmpleado[16]="EM0018";
		codEmpleado[17]="EM0019";
		codEmpleado[18]="EM0020";
		codEmpleado[19]="EM0021";
		codEmpleado[20]="EM0022";
		codEmpleado[21]="EM0023";
		codEmpleado[22]="EM0024";
	
		RegistroEmpleado.empleadoBD= empleado;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//poner fondo
		((JPanel) getContentPane()).setOpaque(false);
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("imagenes/Trabajadores.jpg"));

					
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBackground(SystemColor.inactiveCaption);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(15, 52, 103, 20);
		contentPane.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombre.setBounds(133, 45, 160, 37);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDni.setBounds(15, 96, 69, 20);
		contentPane.add(lblDni);
		
		dni = new JTextField();
		dni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dni.setBounds(133, 88, 160, 37);
		contentPane.add(dni);
		dni.setColumns(10);
		
		JLabel lblFuncion = new JLabel("FUNCION:");
		lblFuncion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFuncion.setBounds(15, 199, 103, 20);
		contentPane.add(lblFuncion);
		
		funcion = new JTextField();
		funcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funcion.setBounds(133, 191, 160, 37);
		contentPane.add(funcion);
		funcion.setColumns(10);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(15, 245, 85, 20);
		contentPane.add(lblUsuario);
		
		usuario = new JTextField();
		usuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usuario.setBounds(133, 237, 160, 37);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("CONTRASE\u00D1A:");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasenia.setBounds(15, 295, 132, 20);
		contentPane.add(lblContrasenia);
		
		contrasenia = new JTextField();
		contrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contrasenia.setBounds(133, 287, 160, 37);
		contentPane.add(contrasenia);
		contrasenia.setColumns(10);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(e-> {
				String codEmpleado = asignarCodEmpleado();
				String Nombre = nombre.getText();
				String DNI = dni.getText();
				String Funcion = funcion.getText();
				int salario = 0;
				try {
					salario = calcularSalario(Funcion);
				} catch (Excepciones e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String Usuario = usuario.getText();
				String Contrasenia = contrasenia.getText();
				
				boolean UCorrecto = false;
				try {
					UCorrecto = comprobarEmpleado(Usuario);
				} catch (Excepciones e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(UCorrecto){
					int indice=0;
					boolean DCorrecto= comprobarDNI(DNI, indice);
					if(DCorrecto){
						CrearBD base = new CrearBD("ResidenciaEstudiantes.db");
						base.createLink();
						residencia.logica.datos.EmpleadoBD.insertarEmpleado(base.getConn(), codEmpleado , 
								Nombre, DNI, salario, Funcion, Usuario, Contrasenia);
						base.closeLink();
						JOptionPane.showMessageDialog(null, "Registro completado correctamente");
						
						RegistroEmpleado.this.setVisible(false);
						EnviarCorreo enviarCorreo= new  EnviarCorreo(Nombre, DNI, Usuario, Contrasenia);
						enviarCorreo.setVisible(true);
					}
				}
				
				
		});
		btnAceptar.setBounds(385, 235, 132, 43);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroEmpleado.this.setVisible(false);
				PaginaPrincipal paginaPrincipal= new PaginaPrincipal();
				paginaPrincipal.setVisible(true);
			}
		});
		btnCancelar.setBounds(385, 279, 132, 43);
		contentPane.add(btnCancelar);
		
		lblmantenimientoOLimpieza = new JLabel("(Mantenimiento \r\no Limpieza)");
		lblmantenimientoOLimpieza.setForeground(SystemColor.info);
		lblmantenimientoOLimpieza.setBackground(new Color(255, 255, 255));
		lblmantenimientoOLimpieza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmantenimientoOLimpieza.setBounds(296, 195, 243, 29);
		contentPane.add(lblmantenimientoOLimpieza);
		
		fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.TOP);
		fondo.setHorizontalAlignment(SwingConstants.RIGHT);
		fondo.setIcon(imagen);
		getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
		fondo.setBounds(-24, -16, 600, 412);
		getContentPane().add(fondo, BorderLayout.CENTER);
	}
	/**
	 * Método para comprobar si el registro es correcto, no se puede utilizar un nombre de usuario que ya esté en uso
	 * @param usuario
	 * @return UsuarioCorrecto, true si es correcto, false si no lo es
	 * @throws Excepciones
	 */
	public static boolean comprobarEmpleado(String usuario) throws Excepciones  {
		boolean UsuarioCorrecto = true;
		
		for (Trabajador a: empleadoBD){
			if(a.getUsuario().equals(usuario)){
				UsuarioCorrecto = false;
				break;
			}
		}
		if(UsuarioCorrecto == true){
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "Usuario ya registrado");
			throw new Excepciones ("Usuario ya esitente ");
		}
	}
	
	/**
	 * Método para comprobar si el DNI es correcto, al ser un número único no puede coincidir con uno ya reegistrado en la base de datos
	 * @param DNI
	 * @param indice
	 * @return DNICorrecto, true si es correcto, false si es incorrecto
	 */
	public static boolean comprobarDNI(String DNI, int indice) {
		boolean DNICorrecto = true;
		
		if (indice==empleadoBD.size()){
			DNICorrecto = true;
		}else{
			if (DNI.equals(empleadoBD.get(indice).DNI)){
				JOptionPane.showMessageDialog(null, "DNI ya registrado");
				DNICorrecto = false;
			}else{
				comprobarDNI (DNI, indice+1);
			}
		}
		return DNICorrecto;
	}
	/**
	 * Método para asignar el código, este es un identificador único.
	 * Para ello, se dispone de una lista con todos los códigos disponibles (la residencia tiene un límite de aforo de 23 empleados)
	 * Se mirará el numero de empleados que hay, y se cogerá de la lista de codigos el siguiente disponible
	 * @return numEmpleado, el codigo a usar
	 */
	public String asignarCodEmpleado(){
		String numEmpleado = null;
		int i =empleadoBD.size();
		numEmpleado= codEmpleado[i];	
		return numEmpleado;	
	}
	
	/**
	 * Metodo para calcular el salario del trabajador, en base a la función que desempeña
	 * @param ocupacion
	 * @return Salario, el salario anual
	 * @throws Excepciones
	 */
	public static int calcularSalario(String ocupacion) throws Excepciones{
		int Salario = 25000;
		if(ocupacion.toString() == "Mantenimiento" || ocupacion.toString() == "mantenimiento"){
			Salario = 25000;
		}else if (ocupacion.toString() == "Limpieza" || ocupacion.toString() == "limpieza"){
			Salario = 20000;
		}else if (ocupacion.toString() == "Director" || ocupacion.toString() == "director"){
			Salario = 30000;
		}
		return Salario;
		
	}
}