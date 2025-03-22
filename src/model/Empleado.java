package model;

public class Empleado {
	
	
	//Atributos
	private int idempleado;
	private String dni;
	private String nombre;
	private String apellidos;
	private String domicilio;
	private String telefono;
	private String codigorepventas;
	private String codigooficina;
	private int idjefe;
	private String cargo;
	private String email;
	
	//Constructor---------------------------------------------------
	public Empleado(int idempleado, String dni, String nombre, String apellidos, String domicilio, String telefono,
			String codigorepventas, String codigooficina, int idjefe, String cargo, String email) {
		super();
		this.idempleado = idempleado;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.codigorepventas = codigorepventas;
		this.codigooficina = codigooficina;
		this.idjefe = idjefe;
		this.cargo = cargo;
		this.email = email;
	}
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	//Metodos--------------------------------------------------------
	public int getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodigorepventas() {
		return codigorepventas;
	}

	public void setCodigorepventas(String codigorepventas) {
		this.codigorepventas = codigorepventas;
	}

	public String getCodigooficina() {
		return codigooficina;
	}

	public void setCodigooficina(String codigooficina) {
		this.codigooficina = codigooficina;
	}

	public int getIdjefe() {
		return idjefe;
	}

	public void setIdjefe(int idjefe) {
		this.idjefe = idjefe;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
