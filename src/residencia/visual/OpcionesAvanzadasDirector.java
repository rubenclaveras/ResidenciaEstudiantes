package residencia.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import residencia.clases.Estudiante;
import residencia.clases.Trabajador;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;

public class OpcionesAvanzadasDirector extends JFrame {

	private JPanel contentPane;
	private ArrayList<Trabajador> empleadoBD = new ArrayList<Trabajador>();
	private ArrayList<Estudiante> estudianteBD = new ArrayList<Estudiante>();
	private JLabel fondo;

	/**
	 * Create the frame.
	 */
	public OpcionesAvanzadasDirector(ArrayList<Trabajador> empleado, ArrayList<Estudiante> estudiantes) {
		this.empleadoBD = empleado;
		this.estudianteBD = estudiantes;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//poner fondo
		((JPanel) getContentPane()).setOpaque(false);
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("imagenes/Director.jpg"));
		
		JButton btnNewButton = new JButton("Estudiantes con cuotas más altas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList <Integer> listaCuotas = null;
				for (Estudiante a: estudiantes){
					listaCuotas.add(a.cuotaAnual);
				}
				int izq = 0;
				int der = (listaCuotas.size()-1);
				ArrayList <Integer> cuotasOrdenadas = quicksortEstudiantes(listaCuotas, izq, der);
				ArrayList<Estudiante> estudiantesOrdenados = null;
				for (int i=0;i<cuotasOrdenadas.size()-1; i++){
					for (Estudiante a: estudiantes){
						if (a.getCuotaAnual()==cuotasOrdenadas.get(i)){
							estudiantesOrdenados.add(a);
							break;
						}
					}
					
				}
				JOptionPane.showMessageDialog(null, estudiantesOrdenados.get(0)+"\n" +
						estudiantesOrdenados.get(1)+"\n" +
						estudiantesOrdenados.get(2)+"\n" +
						estudiantesOrdenados.get(3)+"\n" +
						estudiantesOrdenados.get(4)+"\n" +
						estudiantesOrdenados.get(5)+"\n" +
						estudiantesOrdenados.get(6)+"\n");
			}
		});
		btnNewButton.setBounds(15, 16, 277, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton2 = new JButton("Empleados con salarios mas altos");
		btnNewButton2.setBounds(15, 84, 277, 52);
		contentPane.add(btnNewButton2);
		
		JButton btnVolver = new JButton("Salir");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionesAvanzadasDirector.this.setVisible(false);
				PaginaPrincipal paginaPrincipal= new PaginaPrincipal ();
				paginaPrincipal.setVisible(true);
			}
		});
		btnVolver.setBounds(15, 297, 138, 43);
		contentPane.add(btnVolver);
		
		
		fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.TOP);
		fondo.setHorizontalAlignment(SwingConstants.RIGHT);
		fondo.setIcon(imagen);
		getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
		fondo.setBounds(-24, -16, 600, 412);
		getContentPane().add(fondo, BorderLayout.CENTER);
	
	}
	public ArrayList<Integer>  quicksortEstudiantes (ArrayList <Integer> listaCuotas, int izquierda, int derecha){
		
		int pivote = listaCuotas.get(izquierda);
		int x = izquierda;
		int y = derecha;
		int auxiliar;
		
		
		while (x<y){
			while (listaCuotas.get(x)<= pivote && x<y){
				x++;
			}
			while (listaCuotas.get(y) > pivote){
				y--;
			}
			if (x<y){
				auxiliar = listaCuotas.get(x);
				listaCuotas.set(x, listaCuotas.get(y));
				listaCuotas.set(y, auxiliar);
			}
		}
		listaCuotas.set(izquierda, listaCuotas.get(y));
		listaCuotas.set(y, pivote);
		
		if (izquierda < y-1){
			quicksortEstudiantes(listaCuotas, izquierda, y-1);
		}
		if (y+1 < derecha){
			quicksortEstudiantes(listaCuotas, y+1, derecha);
		}
		
		return listaCuotas;
	}
}
