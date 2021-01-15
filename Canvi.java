import java.util.Vector;

public class Canvi extends Instruccio{
    private Jugador jugadorPista;
    private Jugador jugadorBanqueta;

    public Canvi(int codi, Persona e, char cOv, Jugador pista, Jugador banqueta)
    {
        super.codiInstruccio = codi;
        super.emisor = e;
        super.CoV = cOv;
        jugadorPista = pista;
        jugadorBanqueta = banqueta;
    }

    public Jugador jugadorPista(){
        return jugadorPista;
    }
    public Jugador jugadorBanqueta(){
        return jugadorBanqueta;
    }
}