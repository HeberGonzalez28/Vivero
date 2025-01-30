
public class comboEntidadDP {
	//Atributos
	 String idpro;
	 String codproducto;
	 
	public comboEntidadDP(String idpro, String codproducto) {
		super();
		this.idpro = idpro;
		this.codproducto = codproducto;
	}
	public comboEntidadDP()
	{
		
	}

	public String getIdpro() {
		return idpro;
	}

	public void setIdpro(String idpro) {
		this.idpro = idpro;
	}

	public String getCodproducto() {
		return codproducto;
	}

	public void setCodproducto(String codproducto) {
		this.codproducto = codproducto;
	}
	@Override
	public String toString() {
		return this.codproducto;
	}
	
	
}
