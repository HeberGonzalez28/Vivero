
public class Pedido {
	
	
	//Atributos
	private int idpedido;
	private String fechaped;
	private String fechaesp;
	private String fechaent;
	private String estado;
	private String descripcion;
	private int idcliente;
	
	//Constructor
	public Pedido(int idpedido, String fechaped, String fechaesp, String fechaent,String estado, String descripcion, int idcliente) {
		super();
		this.idpedido = idpedido;
		this.fechaped = fechaped;
		this.fechaesp = fechaesp;
		this.fechaent = fechaent;
		this.estado = estado;
		this.descripcion = descripcion;
		this.idcliente = idcliente;
	}

	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	//Metodos

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public String getFechaped() {
		return fechaped;
	}

	public void setFechaped(String fechaped) {
		this.fechaped = fechaped;
	}

	public String getFechaesp() {
		return fechaesp;
	}

	public void setFechaesp(String fechaesp) {
		this.fechaesp = fechaesp;
	}

	public String getFechaent() {
		return fechaent;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setFechaent(String fechaent) {
		this.fechaent = fechaent;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	

	
}
