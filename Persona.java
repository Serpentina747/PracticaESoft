public class Persona {
    protected String nom;
    protected String cognom;
    protected int llicencia_federativa;
    protected Partit partit;
    
    //brief : constructor per defecte de la classe Persona.
    public Persona(){
        nom = "";
        cognom = "";
        llicencia_federativa = 0;
        partit = null;
    }
    //brief : constructor per amb paràmetres de la classe Persona.
    public Persona(String _nom, String _cognom, int _llicencia_federativa, Partit _partit){
        nom = _nom;
        cognom = _cognom;
        llicencia_federativa = _llicencia_federativa;
        partit = _partit;
    }
    //brief : retorna un enter que correspon amb el numero de la llicencia federativa.
    public int llicenciaFederativa(){
        return llicencia_federativa;
    }
    //brief : retorna una cadena de caràcters que correspon amb el nom de la persona.
    public String nom() {return nom;}
}