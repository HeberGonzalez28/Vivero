
public class Usuario {
	
	
	//Atributos
	private int idusuario;
	private String usuario;
	private String password;
	
	//Constructor
	public Usuario(int idusuario, String usuario, String password) {
		
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.password = password;
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
	
	

}
