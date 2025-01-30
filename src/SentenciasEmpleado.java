import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class SentenciasEmpleado extends Conector {
	
	PreparedStatement st;
	ResultSet rs;
	String registros[][];
	
	public SentenciasEmpleado() {}
	
	//Sentencia Insertar Panel------------------------------------------------------------------------
	public void insertar(Empleado emp) {
		String sql="INSERT INTO `empleados`(`Id_empleado`, `DNI`, `Nombre`, `Apellidos`, `Domicilio`, `Telefono`, `Codigo_Repventas`, `Codigo_oficina`, `Id_jefe`, `Cargo`, `Email`)"
				+ "VALUES (NULL,?,?,?,?,?,?,?,?,?,?)";
		
		try {
            st=getConexion().prepareStatement(sql);
			
			//st.setInt(0, emp.getIdempleado());
			st.setString(1, emp.getDni());
			st.setString(2, emp.getNombre());
			st.setString(3, emp.getApellidos());
			st.setString(4, emp.getDomicilio());
			st.setString(5, emp.getTelefono());
			st.setString(6, emp.getCodigorepventas());
			st.setString(7, emp.getCodigooficina());
			st.setInt(8, emp.getIdjefe());
			st.setString(9, emp.getCargo());
			st.setString(10, emp.getEmail());
			st.execute();
			System.out.println("Los datos se inserto correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al insertar los datos!");
			
		}
	}
	
	public void modificar(Empleado emp) {
		String sql="UPDATE `empleados` SET `DNI`=?,`Nombre`=?,`Apellidos`=?,"
				+ "`Domicilio`=?,`Telefono`=?,`Codigo_Repventas`=?,`Codigo_oficina`=?,`Id_jefe`=?,`Cargo`=?,`Email`=? WHERE `empleados`.`Id_empleado`=?";
		
		try {
            st=getConexion().prepareStatement(sql);
			
			st.setString(1, emp.getDni());
			st.setString(2, emp.getNombre());
			st.setString(3, emp.getApellidos());
			st.setString(4, emp.getDomicilio());
			st.setString(5, emp.getTelefono());
			st.setString(6, emp.getCodigorepventas());
			st.setString(7, emp.getCodigooficina());
			st.setInt(8, emp.getIdjefe());
			st.setString(9, emp.getCargo());
			st.setString(10, emp.getEmail());
			st.setInt(11, emp.getIdempleado());
			st.execute();
			System.out.println("Los datos se modificaron correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al modifico los datos!");
			
		}
	}
	
	public String[][] seleccionregistro() {
		String sql="SELECT * FROM `empleados` WHERE 1";
		
		try {
			st=getConexion().prepareStatement(sql);
			rs=st.executeQuery();
			rs.last();
			int tam=rs.getRow();
			System.out.println(tam);
			registros=new String[tam][11];
			rs.beforeFirst();
			int f=0;
			
			while(rs.next()){
				
				String fila[]=new String[11];
				for(int x=0;x<fila.length;x++)
				{
					fila[x]=rs.getString(x+1);
				}
				registros[f]=fila;
				f++;
				st.execute();
			}
			System.out.println("Los datos se seleciono correctamente");
		}catch(SQLException e) {
			System.out.println("Error al selecionar los datos!");
		}
		return registros;
	}
	
	public void mostrarmatriz(String[][] m)
	{
		for(int x=0;x<m.length;x++)
		{
			System.out.print(m[x][0]+" "+m[x][1]);
		}
	}
    public static void main(String arg[]) {
	
		//new SentenciasUsuario().insertar(new Usuario());
		//new SentenciasUsuario().modificar(new Usuario());
		//SentenciasUsuario S = new SentenciasUsuario ();
		//S.mostrarmatriz( S.seleccionregistro());
	}



}
