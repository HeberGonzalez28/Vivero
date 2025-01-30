

public class Oficina {
	//Atributos--------------------------------------------------------------------------------------
	private String codigooficina;
	private String ciudad;
	private String fax;
	private String telefono;
	private String direccion;
	private String email;
	
	//Constructor--------------------------------------------------------------------------------------
	public Oficina(String codigooficina, String ciudad, String fax, String telefono, String direccion, String email) {
		super();
		this.codigooficina = codigooficina;
		this.ciudad = ciudad;
		this.fax = fax;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}
	
	public Oficina() {
		// TODO Auto-generated constructor stub
	}
	//Metodos--------------------------------------------------------------------------------------

	public String getCodigooficina() {
		return codigooficina;
	}

	public void setCodigooficina(String codigooficina) {
		this.codigooficina = codigooficina;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
