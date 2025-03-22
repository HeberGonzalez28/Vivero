package model;

public class comboEntidadTP {
	//Atributos
	 String idtpro;
	 String gama;
	
	//Constructor
	public comboEntidadTP(String idtpro, String gama) {
		super();
		this.idtpro = idtpro;
		this.gama = gama;
	}
	//Metodos
	public String getIdtpro() {
		return idtpro;
	}
	public void setIdtpro(String idtpro) {
		this.idtpro = idtpro;
	}
	public String getGama() {
		return gama;
	}
	public void setGama(String gama) {
		this.gama = gama;
	}
	@Override
	public String toString() {
		return this.gama;
	}
	
}
