package BD;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Connection;

//Conectar a la base de datos-------------------------------
public class Conector {

	private Connection con =null;
	
	public Conector(){
       String driver= "com.mysql.jdbc.Driver";
       String url="jdbc:mysql://127.0.0.1/";
       String db= "viverodb";
       String us= "root";
       String pa= "";
     
       try {
    	   System.out.println("Cargando driver...");
		Class.forName(driver);
		System.out.println("Driver listo!");
		
		System.out.println("Conectando a la base de datos...");
		con= (Connection)DriverManager.getConnection(url+db, us, pa);
		System.out.println("Coneccion correcta!");
		
			} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Ups Error con el conector driver!");
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Ups Error al conectar a la base de datos!");
	}
       
}
	//Metodo devuelve la coneccion------------------------
	public Connection getConexion() {
		return this.con;
	}
	
	public static void main(String arg[])
	{
		new Conector();
	}

}
