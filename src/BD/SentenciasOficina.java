package BD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Oficina;


public class SentenciasOficina extends Conector {
	
	PreparedStatement st;
	ResultSet rs;
	String registros[][];
	
	public SentenciasOficina() {}
	
	//Sentencia Insertar PanelPropiedad-------------------------------------------------------------------------
	public void insertar(Oficina ofi) {
		String sql="INSERT INTO `oficinas`(`Codigo_oficina`, `Ciudad`, `Fax`, `Direccion`, `Telefono`, `Email`)"
				+ "VALUES (?,?,?,?,?,?)";
		
		try {
            st=getConexion().prepareStatement(sql);
			
            st.setString(1, ofi.getCodigooficina());
			st.setString(2, ofi.getCiudad());
			st.setString(3, ofi.getFax());
			st.setString(4, ofi.getDireccion());
			st.setString(5, ofi.getTelefono());
			st.setString(6, ofi.getEmail());
			st.execute();
			System.out.println("Los datos se inserto correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al insertar los datos!");
			
		}
	}
	
	public void modificar(Oficina ofi) {
		String sql="UPDATE `oficinas` SET `Ciudad`=?,"
				+ "`Fax`=?,`Direccion`=?,`Telefono`=?,`Email`=? WHERE `oficinas`.`Codigo_oficina`=?";
		
		try {
            st=getConexion().prepareStatement(sql);
			
			st.setString(1, ofi.getCiudad());
			st.setString(2, ofi.getFax());
			st.setString(3, ofi.getDireccion());
			st.setString(4, ofi.getTelefono());
			st.setString(5, ofi.getEmail());
			st.setString(6, ofi.getCodigooficina());
			st.execute();
			System.out.println("Los datos se modificaron correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al modificar los datos!");
			
		}
	}
	
	public String[][] seleccionregistro() {
		String sql="SELECT * FROM `oficinas` WHERE 1";
		
		try {
			st=getConexion().prepareStatement(sql);
			rs=st.executeQuery();
			rs.last();
			int tam=rs.getRow();
			System.out.println(tam);
			registros=new String[tam][6];
			rs.beforeFirst();
			int f=0;
			
			while(rs.next()){
				
				String fila[]=new String[6];
				for(int x=0;x<fila.length;x++)
				{
					fila[x]=rs.getString(x+1);
				}
				registros[f]=fila;
				f++;
				st.execute();
			}
			//System.out.println("Los datos se inserto correctamente");
		}catch(SQLException e) {
			//System.out.println("Error al insertar los datos!");
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
		
		//new SentenciasOficina().insertar(new Oficina());
		//new SentenciasOficina().modificar(new Oficina());
		//SentenciasOficina S = new SentenciasOficina ();
		//S.mostrarmatriz( S.seleccionregistro());
	}

}
