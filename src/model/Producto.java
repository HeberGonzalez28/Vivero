package model;

public class Producto {
	
	
	//Atributos
	private int idproducto;
	private String codigoproducto;
	private String nombre;
	private String gama;
	private String dimensiones;
	private String proveedor;
	private String descripcion;
	private int cantStock;
	private float precioventa;
	private float precioproveedor;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(int idproducto, String codigoproducto, String nombre, String gama, String dimensiones,
			String proveedor, String descripcion, int cantStock, float precioventa, float precioproveedor) {
		super();
		this.idproducto = idproducto;
		this.codigoproducto = codigoproducto;
		this.nombre = nombre;
		this.gama = gama;
		this.dimensiones = dimensiones;
		this.proveedor = proveedor;
		this.descripcion = descripcion;
		this.cantStock = cantStock;
		this.precioventa = precioventa;
		this.precioproveedor = precioproveedor;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getCodigoproducto() {
		return codigoproducto;
	}

	public void setCodigoproducto(String codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGama() {
		return gama;
	}

	public void setGama(String gama) {
		this.gama = gama;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantStock() {
		return cantStock;
	}

	public void setCantStock(int cantStock) {
		this.cantStock = cantStock;
	}

	public float getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(float precioventa) {
		this.precioventa = precioventa;
	}

	public float getPrecioproveedor() {
		return precioproveedor;
	}

	public void setPrecioproveedor(float precioproveedor) {
		this.precioproveedor = precioproveedor;
	}
	
	
}
