import java.util.*; 
import java.io.*;

public class Jugador extends Persona{
    private String estil;
    private double alcada;
    private double pes;
    private Equip equip;
    private double velocitat;
    private double orientacio;
    private double acceleracio;
    private int amonestat;
    private Rol rol;
    private Entrenador entrenador;
    private boolean veuPilota;
    private boolean pendentEntrenador;
    private boolean pendentArbitre;
    private boolean banqueta;
    private Vector<Instruccio> msgEntrenador;
    private int exclusions;

    //brief: Constructor amb paràmetres de Jugador
    public Jugador(String _nom, String _cognom, int _llicencia_federativa, String _estil, double _alcada, double _pes, Equip _equip, Entrenador _entrenador, String descripcio_rol, boolean _banqueta, String atacOdefensa, Partit _partit){
        super.nom = _nom;
        super.cognom = _cognom;
        super.llicencia_federativa = _llicencia_federativa;
        super.partit = _partit;
        estil = _estil;
        alcada = _alcada;
        pes = _pes;
        equip = _equip;
        velocitat = 0;
        orientacio = 0;
        acceleracio = 0;
        amonestat = 0;
        rol = crearRol(descripcio_rol, atacOdefensa);
        entrenador = _entrenador;
        exclusions = 0;
        veuPilota = false;
        pendentEntrenador = true;
        pendentArbitre = true;
        banqueta = _banqueta;
        msgEntrenador = new Vector<Instruccio>();
    }

    //brief: Es rep la instrucció instruccio, es guarda al vector d'instruccions i es mostra el missatge que conté
    public void rebreMissatge (Instruccio instruccio) {

        msgEntrenador.add(instruccio);
        System.out.println(" JUGADOR: " + super.nom + " COGNOM: " + super.cognom + " TEXT REBUT: " + instruccio.missatge());

    }

    //brief: Actualitza l'estat del Jugador per una exclusió
    public int excloure() {

        exclusions++;
        return exclusions;

    }

    //brief: retorna les exclusions que té el jugador.
    public int exclosions () {
        return exclusions;
    }

    //brief: Actualitza l'estat del Jugador per anar a jugar a la Pista
    public void enviarPista () {

        banqueta = false;
        pendentArbitre = true;
        pendentEntrenador = true;
        veuPilota = true;

    }

    // brief: Actualitza l'estat del Jugador per entrar a la Banqueta
    public void enviarBanqueta () {

        banqueta = true;
        pendentArbitre = false;
        pendentEntrenador = true;
        veuPilota = true;

    }

    // brief: Assigna el rol que conté la Assignacio assig al Jugador
    public void canviarRol (Assignacio assig) {

        rol = assig.nouRol();

    }

    // brief: retorna el nom de l'equip al qual pertany el jugador.
    public String nomEquip() {return equip.nomEquip();}

    //brief: Crea el rol corresponent amb els paràmetres entrats, si els paràmetres són incorrectes retorna null, si són correctes retorna el Rol
    public Rol crearRol(String descripcio_rol, String atacOdefensa){
        if(atacOdefensa.equals("D")){
            if(descripcio_rol.equals("exterior_esquerra")){
                return new Defensa("exterior", "esquerra");

            } else if (descripcio_rol.equals("lateral_esquerra")){
                return new Defensa("lateral", "esquerra");

            } else if (descripcio_rol.equals("central_esquerra")){
                return new Defensa("central", "esquerra");
                
            } else if (descripcio_rol.equals("central_dret")){
                return new Defensa("central", "dret");
                
            } else if (descripcio_rol.equals("lateral_dret")){
                return new Defensa("lateral", "dret");
                
            } else if (descripcio_rol.equals("exterior_dret")){
                return new Defensa("exterior", "dret");
                
            } else if (descripcio_rol.equals("porter")){
                return new Porter("porter", "porter");  
            }
            else return null;
        }  else if (atacOdefensa.equals("A")){
            if(descripcio_rol.equals("exterior_esquerra")){
                return new Atacant("exterior", "esquerra");
            } else if (descripcio_rol.equals("lateral_esquerra")){
                return new Atacant("lateral", "esquerra");

            } else if (descripcio_rol.equals("central")){
                return new Atacant("central", "central");
                
            } else if (descripcio_rol.equals("lateral_dret")){
                return new Atacant("lateral", "dret");
                
            } else if (descripcio_rol.equals("exterior_dret")){
                return new Atacant("exterior", "dret");
                
            } else if (descripcio_rol.equals("pivot")){
                return new Atacant("pivot", "pivot");
                
            } else if (descripcio_rol.equals("porter")){
                return new Atacant("porter", "porter");
                
            }
            else return null;
        }
        return null;
    }
    // Mètode toString.
    @Override public String toString(){
        String a = "";
        if(banqueta) {a = "banqueta";}
        else{a = "pista";}
        return "NOM: " + super.nom + " COGNOM: " + super.cognom + " LLICENCIA FEDERATIVA: " + 
        super.llicencia_federativa + " ESTIL: " + estil + " ALCADA: " + alcada + " PES: "  + pes + 
        " EQUIP: " + equip + " ROL: " + rol + " BANQUETA/PISTA: " + a + " AMONESTACIONS: " + amonestat +  " EXCLUSIONS: " +  exclusions + " "; 
    }

}
