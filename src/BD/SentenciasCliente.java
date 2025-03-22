package BD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;


public class SentenciasCliente extends Conector {
	
	PreparedStatement st;
	ResultSet rs;
	String registros[][];
	
	
	public SentenciasCliente() {}
	
	//Sentencia Insertar PanelClientes-------------------------------------------------------------------------
	public void insertar(Cliente cli) {
		String sql="INSERT INTO `clientes`(`Idcliente`, `Nombre_Cliente`, `Nombre_Contacto`, `Apellidos_Contacto`, `RTN`, `Telefono`, `Fax`, `Direccion`, `Codigo_Postal`, `Codigo_Repventas`, `Credito`)"
				+ "VALUES (NULL,?,?,?,?,?,?,?,?,?,?)";
		
		try {
            st=getConexion().prepareStatement(sql);
			
			//st.setInt(1, cli.getIdcliente());
			st.setString(1, cli.getNombrecli());
			st.setString(2,cli.getNombrecont());
			st.setString(3, cli.getApellidocont());
			st.setString(4, cli.getRtn());
			st.setString(5,cli.getTelefono());
			st.setString(6,cli.getFax());
			st.setString(7, cli.getDireccion());
			st.setString(8,cli.getCodigopostal());
			st.setString(9,cli.getCodigorepreventas());
			st.setFloat(10,cli.getCredito());
			st.execute();
			System.out.println("Los datos se inserto correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al insertar los datos!");
			
		}
	}
	
	public void modificar(Cliente cli) {
		
		String sql="UPDATE `clientes` SET `Nombre_Cliente`=?,`Nombre_Contacto`=?,`Apellidos_Contacto`=?,`RTN`=?,`Telefono`=?,"
				+ "`Fax`=?,`Direccion`=?,`Codigo_Postal`=?,`Codigo_Repventas`=?,`Credito`=? WHERE `clientes`.`Idcliente`=?";
		
		try {
            st=getConexion().prepareStatement(sql);
			
            st.setString(1, cli.getNombrecli());
			st.setString(2,cli.getNombrecont());
			st.setString(3, cli.getApellidocont());
			st.setString(4, cli.getRtn());
			st.setString(5,cli.getTelefono());
			st.setString(6,cli.getFax());
			st.setString(7, cli.getDireccion());
			st.setString(8,cli.getCodigopostal());
			st.setString(9,cli.getCodigorepreventas());
			st.setFloat(10,cli.getCredito());
			st.setInt(11, cli.getIdcliente());
			st.execute();
			System.out.println("Los datos se modificaron correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al modificar los datos!");
			
		}
	}
	
	public String[][] seleccionregistro() {
		String sql="SELECT * FROM `clientes` WHERE 1";
		
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
			System.out.println("Los datos se selecionaron correctamente");
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
	/*public Vector<comboEntidadTP> cargarComboConID(String tabla, String campos[])
	{
		String sql= "Select"+campos[0]+","+campos[1]+"from"+tabla;
		Vector<comboEntidadTP>datos=new Vector<comboEntidadTP>();
		comboEntidadTP dato=null;
		dato=new comboEntidadTP("0","Seleccionar");
		datos.add(dato);
		try {
			st=getConexion().prepareStatement(sql);
			rs=st.executeQuery();
			
			while(rs.next()) {
				dato=new comboEntidadTP(rs.getString(1),rs.getString(2));
				datos.add(dato);
				System.out.println(rs.getString(1));
			}
			st.close();
			rs.close();
		}catch(Exception var7) {
			var7.printStackTrace();
		}
		return datos;
	}*/
	public static void main(String arg[]) {
		
		//new SentenciasCliente().insertar(new Cliente());
		//new SentenciasCliente().modificar(new Cliente());
		//SentenciasCliente S = new SentenciasCliente ();
		//S.mostrarmatriz( S.seleccionregistro() );
	}

}
