public class Sancio extends Instruccio{
    private Jugador jugadorPista;
    private String tipusSancio;

    public Sancio(int codi, Persona e, char cOv, Jugador pista, String tipus)
    {
        super.codiInstruccio=codi;
        super.emisor = e;
        super.CoV=cOv;
        jugadorPista = pista;
        tipusSancio = tipus;
    }
    public Jugador jugadorPista(){
        return jugadorPista;
    }
    public String tipusSancio(){
        return tipusSancio;
    }
}