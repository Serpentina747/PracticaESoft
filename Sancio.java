public class Sancio extends Instruccio{
    private Jugador jugadorPista;
    private String tipusSancio;

    //brief : constructor amb paràmetres d'una Sancio.
    public Sancio(int codi, Persona e, char cOv, Jugador pista, String tipus)
    {
        super.codiInstruccio=codi;
        super.emisor = e;
        super.CoV=cOv;
        jugadorPista = pista;
        tipusSancio = tipus;
    }
    //brief : jugador de la pista que rep la sanció.
    public Jugador jugadorPista(){
        return jugadorPista;
    }
    //brief : retorna una cadena de caràcters amb el tipus de sanció.
    public String tipusSancio(){
        return tipusSancio;
    }
}