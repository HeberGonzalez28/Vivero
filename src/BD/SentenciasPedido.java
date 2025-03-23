package BD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import Model.Pedido;


public class SentenciasPedido extends Conector {
	
	PreparedStatement st;
	ResultSet rs;
	String registros[][];
	
	public SentenciasPedido() {}
	
	//Sentencia Insertar PanelFrase-------------------------------------------------------------------------
	public void insertar(Pedido ped) {

		String sql="INSERT INTO `pedidos`(`IdPedido`, `Fecha_Pedido`, `Fecha_Esperada`, `Fecha_Entrega`, `Estado`, `Comentario`, `IdCliente`)"
				+ "VALUES (NULL,?,?,?,?,?,?)";
		
		try {
            st=getConexion().prepareStatement(sql);
			
			st.setString(1, ped.getFechaped());
			st.setString(2, ped.getFechaesp());
			st.setString(3, ped.getFechaent());
			st.setString(4, ped.getEstado());
			st.setString(5, ped.getDescripcion());
			st.setInt(6, ped.getIdcliente());
			st.execute();
			System.out.println("Los datos se inserto correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al insertar los datos!");
			
		}
	}
	
	public void modificar(Pedido ped) {
		String sql="UPDATE `pedidos` SET `Fecha_Pedido`=?,`Fecha_Esperada`=?,`Fecha_Entrega`=?,`Estado`=?,"
				+ "`Comentario`=?,`IdCliente`=?' WHERE `pedidos`.`IdPedido`=?";
		
		try {
            st=getConexion().prepareStatement(sql);
			
            st.setString(1, ped.getFechaped());
			st.setString(2, ped.getFechaesp());
			st.setString(3, ped.getFechaent());
			st.setString(4, ped.getEstado());
			st.setString(5, ped.getDescripcion());
			st.setInt(6, ped.getIdcliente());
			st.setInt(7, ped.getIdpedido());
			st.execute();
			System.out.println("Los datos se modificaron correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al modificar los datos!");
			
		}
	}
	public String[][] seleccionregistro() {
		String sql="SELECT * FROM `pedidos` WHERE 1";
		
		try {
			st=getConexion().prepareStatement(sql);
			rs=st.executeQuery();
			rs.last();
			int tam=rs.getRow();
			System.out.println(tam);
			registros=new String[tam][7];
			rs.beforeFirst();
			int f=0;
			
			while(rs.next()){
				
				String fila[]=new String[7];
				for(int x=0;x<fila.length;x++)
				{
					fila[x]=rs.getString(x+1);
				}
				registros[f]=fila;
				f++;
				st.execute();
			}
			System.out.println("Los datos se inserto correctamente");
		}catch(SQLException e) {
			System.out.println("Error al insertar los datos!");
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
		
		//new SentenciasPedido().insertar(new Pedido());
		//new SentenciasPedido().modificar(new Pedido());
		//SentenciasPedido S = new SentenciasPedido();
		//S.mostrarmatriz( S.seleccionregistro() );
	
	}

}
