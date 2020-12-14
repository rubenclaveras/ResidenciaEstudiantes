package residencia.visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import residencia.clases.Habitacion;
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
 * Clase que muestra una ventana en la cual el trabajador podra registrarse metiendo sus datos, los cuales e guardaran en la base de datos
 */
public class RegistroEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField usuario;
	private JTextField contrasenia;
	private JTextField dni;
	private JTextField Ocupacion;
	private ArrayList<Trabajador> empleadoBD = new ArrayList<Trabajador>();
	private String[] codEmpleado = new String[23];
	
	

	/**
	 * Create the frame.
	 */
	public RegistroEmpleado(ArrayList<Trabajador> empleado) {
		
		
		codEmpleado[0]="EM0001";
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
		codEmpleado[16]="EM0017";
		codEmpleado[17]="EM0018";
		codEmpleado[18]="EM0019";
		codEmpleado[19]="EM0020";
		codEmpleado[20]="EM0021";
		codEmpleado[21]="EM0022";
		codEmpleado[22]="EM0023";
		codEmpleado[23]="EM0024";
		
		this.empleadoBD= empleado;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(15, 16, 69, 20);
		contentPane.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(109, 13, 146, 26);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(15, 59, 69, 20);
		contentPane.add(lblUsuario);
		
		usuario = new JTextField();
		usuario.setBounds(109, 56, 146, 26);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setBounds(15, 106, 85, 20);
		contentPane.add(lblContrasenia);
		
		contrasenia = new JTextField();
		contrasenia.setBounds(109, 103, 146, 26);
		contentPane.add(contrasenia);
		contrasenia.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(15, 152, 69, 20);
		contentPane.add(lblDni);
		
		dni = new JTextField();
		dni.setBounds(109, 145, 146, 26);
		contentPane.add(dni);
		dni.setColumns(10);
		
		JLabel lblFuncion = new JLabel("Funci\u00F3n:");
		lblFuncion.setBounds(15, 188, 95, 20);
		contentPane.add(lblFuncion);
		
		Ocupacion = new JTextField();
		Ocupacion.setBounds(109, 185, 146, 26);
		contentPane.add(Ocupacion);
		Ocupacion.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codEmpleado = asignarCodEmpleado();
				String Nombre = nombre.getText();
				String DNI = dni.getText();
				String ocupacion = Ocupacion.getText();
				int salario = calcularSalario(ocupacion);
				String Usuario = usuario.getText();
				String Contrasenia = contrasenia.getText();
				
				try {
					boolean UCorrecto = comprobarEmpleado(Usuario, Contrasenia);
					if(UCorrecto){
						boolean DCorrecto= comprobarDNI(DNI);
						if(DCorrecto){
							CrearBD base = new CrearBD("ResidenciaEstudiantes.db");
							base.createLink();
							residencia.logica.datos.EmpleadoBD.insertarEmpleado(base.getConn(), codEmpleado , 
									Nombre, DNI, salario, ocupacion, Usuario, Contrasenia);
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
		btnAceptar.setBounds(298, 59, 115, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroEmpleado.this.dispose();
			}
		});
		btnCancelar.setBounds(298, 133, 115, 29);
		contentPane.add(btnCancelar);
		
	}
	
	
	
	public boolean comprobarEmpleado(String usuario, String password) throws UsuarioExistente{
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
		if (UsuarioCorrecto==true){
			return true;
		}else{
			throw new UsuarioExistente("Usuario o contrasenya existente, por favor cambielas");
		}
	}
	
	
	public boolean comprobarDNI(String DNI) throws DniIncorrecto{
		boolean DNICorrecto = true;
		for (Trabajador a: empleadoBD){
			if(a.getDNI().equals(DNI)){
				DNICorrecto = false;
				break;
			}
		}if (DNICorrecto = true){
			return true;
		}else{
			throw new DniIncorrecto("DNI existente");
		}
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
		}else{
			System.out.println("ocupacion no correcta");
		}
		return Salario;
	}
	
	
	
	
	
}

