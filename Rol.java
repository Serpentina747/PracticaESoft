public class Rol {
	
	protected int codiRol;
	protected String nomRol;
	protected String orientacio;
	protected String posicionament;
	
	//brief: constructor per defecte d'un Rol.
	public Rol() {
		codiRol=0;
		nomRol="";
	}
	//brief: retorna una cadena de caràcters amb la orientació del Rol.
	public String orientacio(){
		
		if(codiRol==0) orientacio= "No te cap orientacio assignada";
		
		return orientacio;
		
	}
	//brief: retorna una cadena de caràcters amb el posicionament del Rol.
	public String posicionament() {
		
		if(codiRol==0) posicionament= "No te cap posicionament assignat";
		
		return posicionament;
	}
	//brief: mètode toString del Rol.
	@Override public String toString(){
		return codiRol + " " + nomRol + " " + orientacio +  " " + posicionament + " ";
	}
}
