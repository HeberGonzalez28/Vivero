package Model;

public class Usuario {
	
	
	//Atributos
	private int idusuario;
	private String usuario;
	private String password;
	private String rol;
	
	//Constructor
	public Usuario(int idusuario, String usuario, String password, String rol) {
		
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	//Metodos
	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	

}
