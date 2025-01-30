import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SentenciasTipoProducto extends Conector{
	
	PreparedStatement st;
	ResultSet rs;
	String registros[][];
	
	 public void insertar(Tproducto tpro) {
			String sql="INSERT INTO `gama_producto`(`Id_gama`,`Gama`, `Descripcion`) VALUES (NULL,?,?)";
			
			try {
	            st=getConexion().prepareStatement(sql);
				
				st.setString(1, tpro.getGama());
				st.setString(2, tpro.getDescripcion());
				st.execute();
				System.out.println("Los datos se inserto correctamente");
			}catch(SQLException e) {e.printStackTrace();
				System.out.println("Error al insertar los datos!");
				
			}
		}
	    public void modificar(Tproducto tpro) {
			String sql="UPDATE `gama_producto` SET `Gama`=?,`Descripcion`=? WHERE `gama_producto`.`Id_gama`=?";
			
			try {
	            st=getConexion().prepareStatement(sql);
				
	            st.setString(1, tpro.getDescripcion());
	            st.setString(2,tpro.getGama());
	            st.setInt(3, tpro.getId());
				st.execute();
				System.out.println("Los datos se modificaron correctamente");
			}catch(SQLException e) {e.printStackTrace();
				System.out.println("Error al modifico los datos!");
				
			}
		}
	    public String[][] seleccionregistrotpro() {
			String sql="SELECT * FROM `gama_producto` WHERE 1";
			
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

}
