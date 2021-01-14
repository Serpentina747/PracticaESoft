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

    public void rebreMissatge (Instruccio instruccio) {

        msgEntrenador.add(instruccio);
        System.out.println("Missatge rebut de l'entreandor: " + instruccio.missatge() + "\n");

    }

    public int excloure() {

        exclusions++;
        return exclusions;

    }

    public int exclosions () {
        return exclusions;
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

    public void canviarRol (Instruccio instruccio) {

        rol = instruccio.nouRol();

    }

}
