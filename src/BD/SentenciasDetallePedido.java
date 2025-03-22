package BD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Main.Principal;
import View.PanelVentas;
import model.Venta;
import model.comboEntidadDP;


public class SentenciasDetallePedido extends Conector {
	
	PreparedStatement st;
	ResultSet rs;
	String registros[][];
	PanelVentas panelventas;
	Principal frm;
	
	public SentenciasDetallePedido() {}
	
	//Sentencia Insertar PanelVentas-------------------------------------------------------------------------
	public void insertar(Venta ven) {
		String sql="INSERT INTO `detalle_pedido`(`IdPedido`, `Id_producto`, `cantidad`, `precio_unidad`, `Subtotal`)"
				+ "VALUES (?,?,?,?,?)";
		
		try {
            st=getConexion().prepareStatement(sql);
			
			st.setInt(1, ven.getIdpedido());
			st.setString(2, ven.getIdproducto());
			st.setInt(3, ven.getCantidad());
			st.setFloat(4, ven.getPreciounidad());
			st.setFloat(5, ven.getSubtotal());
			st.execute();
			System.out.println("Los datos se inserto correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al insertar los datos!");
			
		}
	}
	public void modificar(Venta ven) {
		//String sql="UPDATE `detalle_pedido` SET ``Id_producto`=?,`cantidad`=?,`precio_unidad`=?,`Subtotal`=? WHERE `detalle_pedido`.`IdPedido`=?";
		String sql="UPDATE `detalle_pedido` SET `Id_producto`=?,`cantidad`=?,`precio_unidad`=?,`Subtotal`=? WHERE `IdPedido`=?";

		
		try {
            st=getConexion().prepareStatement(sql);
            
			st.setString(1, ven.getIdproducto());
			st.setInt(2, ven.getCantidad());
			st.setFloat(3, ven.getPreciounidad());
			st.setFloat(4, ven.getSubtotal());
			st.setInt(5, ven.getIdpedido());
			st.execute();
			System.out.println("Los datos se modificaron correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al modificar los datos!");
			
		}
	}
	public void eliminar(Venta ven) {
		//String sql="DELETE FROM `detalle_pedido` WHERE 1";
		String sql="DELETE FROM `detalle_pedido` WHERE `IdPedido`=?";

		
		try {
            st=getConexion().prepareStatement(sql);
            st.setInt(1, ven.getIdpedido());
            st.execute();
			System.out.println("Los datos se modificaron correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al modificar los datos!");
			
		}
	}
	/*public String[][] seleccionRegistro(String campo) {
	String sql="SELECT * FROM `detalle_pedido` WHERE Subtotal like ?";
	
	try {
		st=getConexion().prepareStatement(sql);
		st.setString(1,campo);
		rs=st.executeQuery();
		rs.last();
		int tam=rs.getRow();
		System.out.println(tam);
		registros=new String[tam][5];
		rs.beforeFirst();
		int f=0;
		
		while(rs.next()){
			
			String fila[]=new String[5];
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
}*/
	/*public void suma(String campo) {
		String sql="SELECT SUM(Subtotal) FROM `detalle_pedido` WHERE `Subtotal`";
		
		try {
            st=getConexion().prepareStatement(sql);
            rs=st.executeQuery();
            
            frm.panelventas.textTotalPagar.setText(rs.getString(0));
			System.out.println("Los datos se modificaron correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al modificar los datos!");
			
		}
	}*/
	
	public String[][] seleccionregistro() {
		String sql="SELECT * FROM `detalle_pedido` WHERE 1";
		
		try {
			st=getConexion().prepareStatement(sql);
			rs=st.executeQuery();
			rs.last();
			int tam=rs.getRow();
			System.out.println(tam);
			registros=new String[tam][5];
			rs.beforeFirst();
			int f=0;
			
			while(rs.next()){
				
				String fila[]=new String[5];
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
	public Vector<comboEntidadDP> cargarComboConID(String tabla, String campos[])
	{
		String sql = "SELECT " + campos[0] + "," + campos[1] + " FROM "  + tabla;
		Vector<comboEntidadDP>datos=new Vector<comboEntidadDP>();
		comboEntidadDP dato=null;
		dato=new comboEntidadDP("0","Seleccionar");
		datos.add(dato);
		try {
			st=getConexion().prepareStatement(sql);
			rs=st.executeQuery();
			
			while(rs.next()) {
				dato=new comboEntidadDP(rs.getString(1),rs.getString(2));
				datos.add(dato);
				System.out.println(rs.getString(1));
			}
			st.close();
			rs.close();
		}catch(Exception var7) {
			var7.printStackTrace();
		}
		return datos;
	}
   
	public static void main(String arg[]) {
		
		//new SentenciasDetallePedido().suma(new String());
		//new SentenciasDetallePedido().modificar(new Venta());
		//SentenciasDetallePedido S = new SentenciasDetallePedido ();
		//System.out.println("Recibido");
		//S.mostrarmatriz( S.seleccionRegistro(null) );
		//System.out.println(S.seleccionRegistro("")[0][5]);
	
	}

}
