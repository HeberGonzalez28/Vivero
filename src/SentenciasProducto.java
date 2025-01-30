import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;




public class SentenciasProducto extends Conector {
	
	PreparedStatement st;
	ResultSet rs;
	String registros[][];
	
	//public SentenciasProducto() {}
	
	//Sentencia Insertar------------------------------------------------------------------------
	public void insertar(Producto pro) {
		String sql="INSERT INTO `productos`(`Id_producto`, `Codigo_Producto`, `Nombre`, `Gama`, `Dimensiones`, `Proveedor`, `Descripcion`, `Cant_Stock`, `Precio_Venta`, `Precio_Proveedor`)"
				+ "VALUES (NULL,?,?,?,?,?,?,?,?,?)";
		
		try {
            st=getConexion().prepareStatement(sql);
            
            st.setString(1, pro.getCodigoproducto());
			st.setString(2, pro.getNombre());
			st.setString(3, pro.getGama());
			st.setString(4, pro.getDimensiones());
			st.setString(5, pro.getProveedor());
			st.setString(6, pro.getDescripcion());
			st.setInt(7, pro.getCantStock());
			st.setFloat(8, pro.getPrecioventa());
			st.setFloat(9, pro.getPrecioproveedor());
			
			st.execute();
			System.out.println("Los datos se inserto correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al insertar los datos!");
			
		}
	}
	
	public void modificar(Producto pro) {
		String sql="UPDATE `productos` SET `Codigo_Producto`=?,`Nombre`=?,"
				+ "`Gama`=?,`Dimensiones`=?,`Proveedor`=?,`Descripcion`=?,"
				+ "`Cant_Stock`=?,`Precio_Venta`=?,`Precio_Proveedor`=? WHERE `productos`.`Id_producto`=?";
		
		try {
            st=getConexion().prepareStatement(sql);
            
			st.setString(1, pro.getCodigoproducto());
            st.setString(2, pro.getNombre());
			st.setString(3, pro.getGama());
			st.setString(4, pro.getDimensiones());
			st.setString(5, pro.getProveedor());
			st.setString(6, pro.getDescripcion());
			st.setInt(7, pro.getCantStock());
			st.setFloat(8, pro.getPrecioventa());
			st.setFloat(9, pro.getPrecioproveedor());
			st.setInt(10, pro.getIdproducto());
			st.execute();
			System.out.println("Los datos se modificaron correctamente");
		}catch(SQLException e) {e.printStackTrace();
			System.out.println("Error al modifico los datos!");
			
		}
	}
	
	public String[][] seleccionregistro() {
		String sql="SELECT * FROM `productos` WHERE 1";
		
		try {
			st=getConexion().prepareStatement(sql);
			rs=st.executeQuery();
			rs.last();
			int tam=rs.getRow();
			System.out.println(tam);
			registros=new String[tam][10];
			rs.beforeFirst();
			int f=0;
			
			while(rs.next()){
				
				String fila[]=new String[10];
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
	public Vector<comboEntidadTP> cargarComboConID(String tabla, String campos[])
	{
		String sql = "SELECT " + campos[0] + "," + campos[1] + " FROM "  + tabla;
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
	}
    public static void main(String arg[]) {
	
	}
   
}
