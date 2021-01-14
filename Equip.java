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

    public Equip(){
        this.codi = 0;
        this.nom = "";
        this.nombreJugadors = 12;
    }
    public Equip(int _codi, String _nom, int _nombreJugadors){
        codi = _codi;
        nom = _nom;
        nombreJugadors = _nombreJugadors;
    }
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

    @Override
    public String toString(){
        return String.valueOf(codi) + "   " + nom;
    }

}