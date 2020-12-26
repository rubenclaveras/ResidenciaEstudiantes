package residencia.visual;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import residencia.clases.Trabajador;
import residencia.logica.datos.CrearBD;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class RegistroEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField dni;
	private JTextField funcion;
	private JTextField usuario;
	private JTextField contrasenia;
	private ArrayList<Trabajador> empleadoBD = new ArrayList<Trabajador>();
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

					
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(15, 52, 103, 20);
		contentPane.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(133, 45, 160, 37);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDni.setBounds(15, 83, 69, 20);
		contentPane.add(lblDni);
		
		dni = new JTextField();
		dni.setBounds(133, 88, 160, 37);
		contentPane.add(dni);
		dni.setColumns(10);
		
		JLabel lblFuncion = new JLabel("FUNCION:");
		lblFuncion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFuncion.setBounds(15, 220, 103, 20);
		contentPane.add(lblFuncion);
		
		funcion = new JTextField();
		funcion.setBounds(133, 213, 160, 37);
		contentPane.add(funcion);
		funcion.setColumns(10);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(15, 263, 85, 20);
		contentPane.add(lblUsuario);
		
		usuario = new JTextField();
		usuario.setBounds(133, 256, 160, 37);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("CONTRASE\u00D1A:");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasenia.setBounds(15, 302, 132, 20);
		contentPane.add(lblContrasenia);
		
		contrasenia = new JTextField();
		contrasenia.setBounds(133, 295, 160, 37);
		contentPane.add(contrasenia);
		contrasenia.setColumns(10);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codEmpleado = asignarCodEmpleado();
				String Nombre = nombre.getText();
				String DNI = dni.getText();
				String Funcion = funcion.getText();
				int salario = 0;
				salario = calcularSalario(Funcion);
				String Usuario = usuario.getText();
				String Contrasenia = contrasenia.getText();
				
				boolean UCorrecto = comprobarEmpleado(Usuario, Contrasenia);
				if(UCorrecto){
					boolean DCorrecto= comprobarDNI(DNI);
					if(DCorrecto){
						CrearBD base = new CrearBD("ResidenciaEstudiantes.db");
						base.createLink();
						residencia.logica.datos.EmpleadoBD.insertarEmpleado(base.getConn(), codEmpleado , 
								Nombre, DNI, salario, Funcion, Usuario, Contrasenia);
						base.closeLink();
					}
				}
			}
		});
		btnAceptar.setBounds(385, 246, 132, 43);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroEmpleado.this.dispose();
			}
		});
		btnCancelar.setBounds(385, 289, 132, 43);
		contentPane.add(btnCancelar);
		
		lblmantenimientoOLimpieza = new JLabel("(Mantenimiento \r\no limpieza)");
		lblmantenimientoOLimpieza.setForeground(new Color(255, 255, 255));
		lblmantenimientoOLimpieza.setBackground(new Color(255, 255, 255));
		lblmantenimientoOLimpieza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmantenimientoOLimpieza.setBounds(297, 216, 243, 29);
		contentPane.add(lblmantenimientoOLimpieza);
		
		fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.TOP);
		fondo.setHorizontalAlignment(SwingConstants.RIGHT);
		fondo.setIcon(imagen);
		getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
		fondo.setBounds(-24, -16, 600, 412);
		getContentPane().add(fondo, BorderLayout.CENTER);
	}
	
	public boolean comprobarEmpleado(String usuario, String password) {
		boolean UsuarioCorrecto = true;
		
		for (Trabajador a: empleadoBD){
			if(a.getUsuario().equals(usuario)){
				UsuarioCorrecto = false;
				break;
			}else{
				if(a.getContrasenia().equals(password)){
					UsuarioCorrecto = false;
					break;
				}
			}
		}
		return UsuarioCorrecto;
	}
	
	
	public boolean comprobarDNI(String DNI) {
		boolean DNICorrecto = true;
		for (Trabajador a: empleadoBD){
			if(a.getDNI().equals(DNI)){
				DNICorrecto = false;
				break;
			}
		}
		return DNICorrecto;
}
	
	public String asignarCodEmpleado(){
		String numEmpleado = null;
		int i;
		for(i=0;i<=codEmpleado.length;i++){
			for(Trabajador a: empleadoBD){
				if(!codEmpleado[i].equals(a.getCodigoTrabajador())){
					numEmpleado = codEmpleado[i];
					break;
				}
			}
			if(numEmpleado!= null){
				break;
			}
		}
		return numEmpleado;	
	}
	
	
	public int calcularSalario(String ocupacion){
		int Salario = 0;
		if(ocupacion == "Mantenimiento" || ocupacion == "mantenimiento"){
			Salario = 25000;
		}else if (ocupacion == "Limpieza" || ocupacion == "limpieza"){
			Salario = 20000;
		}else if (ocupacion == "Director" || ocupacion == "director"){
			Salario = 30000;
		}
		return Salario;
	}
}
