
public class Tproducto {
	
	
	//Atributos
	private int id;
	private String gama;
	private String descripcion;
	
	
	//Constructor---------------------------------------------------
	public Tproducto() {
		// TODO Auto-generated constructor stub
	}

	public Tproducto(int id, String gama, String descripcion) {
		super();
		this.id = id;
		this.gama = gama;
		this.descripcion = descripcion;
	}
	//Metodos--------------------------------------------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGama() {
		return gama;
	}

	public void setGama(String gama) {
		this.gama = gama;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
