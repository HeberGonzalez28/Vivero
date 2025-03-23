package Model;


public class Cliente {
	//Atributos--------------------------------------------------------------------------------------
	private int idcliente;
	private String nombrecli;
	private String nombrecont;
	private String apellidocont;
	private String rtn;
	private String telefono;
	private String fax;
	private String direccion;
	private String codigopostal;
	private String codigorepreventas;
	private float credito;
	
	//Constructor--------------------------------------------------------------------------------------

	public Cliente(int idcliente, String nombrecli, String nombrecont, String apellidocont, String rtn, String telefono,
			String fax, String direccion, String codigopostal, String codigorepreventas, float credito) {
		super();
		this.idcliente = idcliente;
		this.nombrecli = nombrecli;
		this.nombrecont = nombrecont;
		this.apellidocont = apellidocont;
		this.rtn = rtn;
		this.telefono = telefono;
		this.fax = fax;
		this.direccion = direccion;
		this.codigopostal = codigopostal;
		this.codigorepreventas = codigorepreventas;
		this.credito = credito;
	}

	//Metodos--------------------------------------------------------------------------------------
	
	public Cliente() {
		//Constructor vacio...
	
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombrecli() {
		return nombrecli;
	}

	public void setNombrecli(String nombrecli) {
		this.nombrecli = nombrecli;
	}

	public String getNombrecont() {
		return nombrecont;
	}

	public void setNombrecont(String nombrecont) {
		this.nombrecont = nombrecont;
	}

	public String getApellidocont() {
		return apellidocont;
	}

	public void setApellidocont(String apellidocont) {
		this.apellidocont = apellidocont;
	}

	public String getRtn() {
		return rtn;
	}

	public void setRtn(String rtn) {
		this.rtn = rtn;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

	public String getCodigorepreventas() {
		return codigorepreventas;
	}

	public void setCodigorepreventas(String codigorepreventas) {
		this.codigorepreventas = codigorepreventas;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}

	

}
