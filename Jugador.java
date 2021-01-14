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
    private int nExclusions;
    private boolean veuPilota;
    private boolean pendentEntrenador;
    private boolean pendentArbitre;
    private boolean banqueta;
    private Vector<Instruccio> msgEntrenador;

    public Jugador(String _nom, String _cognom, int _llicencia_federativa, String _estil, double _alcada, double _pes, Equip _equip, Entrenador _entrenador, String descripcio_rol, boolean _banqueta){
        super.nom = _nom;
        super.cognom = _cognom;
        super.llicencia_federativa = _llicencia_federativa;
        estil = _estil;
        alcada = _alcada;
        pes = _pes;
        equip = _equip;
        velocitat = 0;
        orientacio = 0;
        acceleracio = 0;
        amonestat = 0;
        rol = null;
        entrenador = _entrenador;
        nExclusions = 0;
        veuPilota = false;
        pendentEntrenador = true;
        pendentArbitre = true;
        banqueta = _banqueta;
        msgEntrenador = new Vector<Instruccio>();
    }
    public void rebreMissatge (Instruccio instruccio) {

        msgEntrenador.add(instruccio);
        System.out.println("Missatge rebut de l'entreandor: " + instruccio.missatge() + "\n");

    }

    public int excloure() {

        nExclusions++;
        return nExclusions;

    }

    public int exclusions () {
        return nExclusions;
    }

    public void enviarPista () {

        banqueta = false;
        pendentArbitre = true;
        pendentEntrenador = true;
        veuPilota = true;

    }
    
    public void enviarBanqueta () {

        banqueta = true;
        pendentArbitre = false;
        pendentEntrenador = true;
        veuPilota = true;

    }

    public void canviarRol (Assignacio assignacio) {

        rol = assignacio.nouRol();

    }

}
