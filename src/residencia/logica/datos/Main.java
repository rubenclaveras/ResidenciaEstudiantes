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

        app.insertarSalon(connect(), 101, "Television", true, "ES0001");
		app.insertarSalon(connect(), 102, "Billar", true, "ES0003");
		app.insertarSalon(connect(), 103, "Videojuegos", true, "ES0004");
		app.insertarSalon(connect(), 104, "Futbolin", true, "ES0006");
		app.insertarSalon(connect(), 105, "Musica", true, "ES0007");
    }
	

}
