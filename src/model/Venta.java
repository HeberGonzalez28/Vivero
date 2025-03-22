package model;
public class Venta {
	//Atributos--------------------------------------------------------------------------------------Detalle Pedido
	private int idpedido;
	private String idproducto;
	private int cantidad;
	private float preciounidad;
	private float subtotal;

	
	//Constructor--------------------------------------------------------------------------------------Detalle Pedido
	public Venta(int idpedido, String idproducto, int cantidad, float preciounidad, float subtotal) {
		super();
		
		this.idpedido = idpedido;
		this.idproducto = idproducto;
		this.cantidad = cantidad;
		this.preciounidad = preciounidad;
		this.subtotal = subtotal;
	}
	
	public Venta() {
		// TODO Auto-generated constructor stub
	}
	//Metodos--------------------------------------------------------------------------------------Detalle Pedido

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public String getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPreciounidad() {
		return preciounidad;
	}

	public void setPreciounidad(float preciounidad) {
		this.preciounidad = preciounidad;
	}
	
	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}


}
