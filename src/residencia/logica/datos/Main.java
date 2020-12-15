package residencia.logica.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
	
	
	private static Connection connect()

    {

        // SQLite connection string

        String name = "ResidenciaEstudiantes.db";

        String url = "jdbc:sqlite:"+name;



        Connection conn = null;



        try

        {

            conn = DriverManager.getConnection(url);

        } catch (SQLException e)

        {

            System.out.println(e.getMessage());

        }



        return conn;

    }



    /**

     * Insert a new row into the warehouses table

     *

     * @param name

     * @param capacity

     */

	public void insertarSalon(Connection conn, int numero, String tipo,
			boolean reservado, String codigoAlumno) {
		String sql = "INSERT INTO salon(numero,tipo,reservado,codigoAlumno) VALUES(?,?,?,?)";
		

		try (Connection conn2 = this.connect();

                PreparedStatement pstmt = conn2.prepareStatement(sql)) {

			
			pstmt.setInt(1, numero);
			pstmt.setString(2, tipo);
			pstmt.setBoolean(3, reservado);
			pstmt.setString(4, codigoAlumno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

        

    



    /**

     * @param args the command line arguments

     */

    public static void main(String[] args)

    {



        Main app = new Main();



        // insert three new rows

        app.insertarSalon(connect(), 106, "Videojuegos", false, null);
		app.insertarSalon(connect(), 107, "Billar", false, null);
		app.insertarSalon(connect(), 108, "Television", false, null);
		app.insertarSalon(connect(), 109, "Futbolin", false, null);
		app.insertarSalon(connect(), 110, "Musica", false, null);
    }
	

}
