import java.util.Vector;

public class Canvi extends Instruccio{
    private Jugador jugadorPista;
    private Jugador jugadorBanqueta;

    //brief: constructor amb paràmetres del tipus d'instrucció canvi.
    public Canvi(int codi, Persona e, char cOv, Jugador pista, Jugador banqueta)
    {
        super.codiInstruccio = codi;
        super.emisor = e;
        super.CoV = cOv;
        jugadorPista = pista;
        jugadorBanqueta = banqueta;
    }
    //brief: retorna el jugador de la pista que anirà a la banqueta..
    public Jugador jugadorPista(){
        return jugadorPista;
    }
    //brief: retorna el jugador de la banqueta que anirà a la pista.
    public Jugador jugadorBanqueta(){
        return jugadorBanqueta;
    }
}