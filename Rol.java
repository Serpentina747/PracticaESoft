public class Rol {
	
	int codiRol;
	String nomRol;
	String orientacio;
	String posicionament;
	
	public Rol() {
		codiRol=0;
		nomRol="";
	}
	
	public String orientacio(){
		
		if(codiRol==0) orientacio= "No te cap orientacio assignada";
		
		return orientacio;
		
	}
	
	public String posicionament() {
		
		if(codiRol==0) posicionament= "No te cap posicionament assignat";
		
		return posicionament;
	}
}
