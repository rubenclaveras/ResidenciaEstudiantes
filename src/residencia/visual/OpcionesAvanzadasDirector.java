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
		
		JButton btnNewButton = new JButton("Estudiantes ordenados por cuota anual");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ArrayList <Integer> listaCuotas = new ArrayList <Integer> ();
				for (Estudiante a: estudiantes ){
					listaCuotas.add(a.getCuotaAnual());
				}
				 
				
				 
				ArrayList <Integer> cuotasOrdenadas = quicksortOrden(listaCuotas);
				ArrayList<String> estudiantesOrdenados = new ArrayList<String> () ;
				ArrayList<String> estudiantesAuxiliar = new ArrayList<String> () ;
				for (Estudiante a: estudiantes){
					estudiantesAuxiliar.add(a.getNombre());
				}
				//Todo esto se hace para: crear una lista auxiliar con los nombres de todos los estudiantes, y a continuacion se van comparando los estudiantes
				// con las cuotas ordenadas. Si coincide, se añade a una lista con los nombres de los estudiantes ordenados, y se elimina de la lista auxiliar con los nombres.
				// Se hace de esta manera para así evitar poner dos veces a un estudiante cuando hay mas de uno que paga anualmente la misma cantidad.
				for (int i= 0;i < (cuotasOrdenadas.size())-1; i++){
					for (Estudiante a: estudiantes){
						if (a.getCuotaAnual()==cuotasOrdenadas.get(i)){
							if (estudiantesAuxiliar.contains(a.getNombre())){
								estudiantesOrdenados.add(a.getNombre()+ " " + cuotasOrdenadas.get(i) + "€");
								estudiantesAuxiliar.remove(a.getNombre());
							}
							
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
		btnNewButton.setBounds(15, 16, 313, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton2 = new JButton("Empleados ordenados por salario anual");
		btnNewButton2.setBounds(15, 84, 313, 52);
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
	/**
	 * Metodo que nos devolverá la lista ordenada
	 * @param listaCuotas lista con todas las cuotas
	 * @return lista ordenada
	 */
	public ArrayList<Integer> quicksortOrden (ArrayList<Integer> listaCuotas){
		return quicksort1(listaCuotas);
	}
	/**
	 *  Metodo que le pasa a quicksort los valores que necesita
	 * @param listaCuotas lista con todas las cuotas
	 * @return lista ordenada
	 */
	public ArrayList<Integer> quicksort1 (ArrayList<Integer> listaCuotas){
		return quicksort2 (listaCuotas, 0, (listaCuotas.size())-1);
	}
	/**
	 * Metodo para hacer el quicksort y ordenar la lista de las cuotas. Se usa como pivote el elemento de la izquierda.
	 * @param listaCuotas lista con todas las cuotas
	 * @param izq el puntero que señala por la izquierda
	 * @param der el puntero que señala por la derecha
	 * @return lista ordenada
	 */
	public ArrayList<Integer> quicksort2 (ArrayList<Integer> listaCuotas, int izq, int der){
		
		if (izq>=der)
			return listaCuotas;
		
		int i = izq, d = der;
		
		if (izq!=der){
			int pivote;
			int aux;
			pivote = izq;
			while (izq != der){
				while (listaCuotas.get(der) >= listaCuotas.get(pivote) && izq < der)
					der--;
				
				while (listaCuotas.get(izq) < listaCuotas.get(pivote) && izq < der)
					izq++;
				
			
			if (der != izq){
				aux = listaCuotas.get(der);
				listaCuotas.set(der, listaCuotas.get(izq));
				listaCuotas.set(izq, aux);
		}
		}
		if (izq == der){
			quicksort2 (listaCuotas, i, izq-1);
			quicksort2 (listaCuotas, izq+1, d);
		}
		}
		else
			return listaCuotas;
		
		return listaCuotas;
	}
	
	 
}
