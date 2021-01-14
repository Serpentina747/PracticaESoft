public class Persona {
    protected String nom;
    protected String cognom;
    protected int llicencia_federativa;
    protected Partit partit;
    
    public Persona(){
        nom = "";
        cognom = "";
        llicencia_federativa = 0;
        partit = null;
    }
    public Persona(String _nom, String _cognom, int _llicencia_federativa){
        nom = _nom;
        cognom = _cognom;
        llicencia_federativa = _llicencia_federativa;
        partit = null;
    }
    public int llicenciaFederativa(){
        return llicencia_federativa;
    }
}