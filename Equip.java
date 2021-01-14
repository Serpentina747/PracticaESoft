import java.util.*; 
public class Equip {
    private int codi;
    private String nom;
    private int nombreJugadors;
    private Vector<Jugador> Jugadors;
    private Entrenador entrenador;
    private Partit partit;
    private int amonestacions;
    private Esquema esquemaDef;
    private Esquema esquemaAtac;

    public int amonestacions(){
        return amonestacions;
    }
    public void actualitzar(){
        
    }
    public void canviaEsquemaAtac(Esquema nou, boolean atac){     
        if(atac) esquemaAtac = nou;
        else esquemaDef = nou;
    }
    public void donarAlta(Jugador jugador){
        Jugadors.add(jugador);
    }
    public void donarBaixa(Jugador jugador){
        Jugadors.add(jugador);
    }

}