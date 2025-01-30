import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class SentenciasUsuario extends Conector {
	
	PreparedStatement st;
	ResultSet rs;
	String registros[][];
	
	public SentenciasUsuario() {}
	
	//Sentencia Insertar Panel------------------------------------------------------------------------
	public void insertar(Usuario usu) {
		String sql="INSERT INTO `usuarios`(`IdUsuario`, `User`, `Password`) VALUES (NULL,?,?)";
		
		try {
            st=getConexion().prepareStatement(sql);
			
			//st.setInt(1, usu.getIdusuario());
			st.setString(1, usu.getUsuario());
			st.setString(2, usu.getPassword());
			st.execute();
			System.out.println("Los datos se inserto correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al insertar los datos!");
			
		}
	}
	
	public void modificar(Usuario usu) {
		String sql="UPDATE `usuarios` SET `User`=?,`Password`=? WHERE `usuarios`.`IdUsuario`=?";
		
		try {
            st=getConexion().prepareStatement(sql);
			
			st.setString(1, usu.getUsuario());
			st.setString(2, usu.getPassword());
			st.setInt(3, usu.getIdusuario());
			st.execute();
			System.out.println("Los datos se modificaron correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al modifico los datos!");
			
		}
	}
	
		public boolean obtenerUsuario(String usuario, String password) {
		String sql="SELECT * FROM `usuarios` WHERE  User=? and Password=?";
		
		int f=0;
		
		try {
			st=getConexion().prepareStatement(sql);
			st.setString(1, usuario);
			st.setString(2, password);
			rs=st.executeQuery();
			
			
			while(rs.next()){
				f++;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(f>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String[][] seleccionregistro() {
		String sql="SELECT * FROM `usuarios` WHERE 1";
		
		try {
			st=getConexion().prepareStatement(sql);
			rs=st.executeQuery();
			rs.last();
			int tam=rs.getRow();
			System.out.println(tam);
			registros=new String[tam][3];
			rs.beforeFirst();
			int f=0;
			
			while(rs.next()){
				
				String fila[]=new String[3];
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
