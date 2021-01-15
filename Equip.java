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

    /*public Equip(){
        this.codi = 0;
        this.nom = "";
        this.nombreJugadors = 12;
        Jugadors = new Vector<Jugador>();
    }*/
    public Equip(int _codi, String _nom, int _nombreJugadors, Partit _partit){
        codi = _codi;
        nom = _nom;
        nombreJugadors = _nombreJugadors;
        Jugadors = null;
        entrenador = null;
        amonestacions = 0;
        partit = _partit;
        esquemaDef = null;
        esquemaAtac = null;
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

    public String nomEquip() {return nom;}

    public void donarAlta(Jugador jugador){
        Jugadors.add(jugador);
    }
    public void donarBaixa(Jugador jugador){
        Jugadors.add(jugador);
    }

    public String nom() {return nom;}
    public int nombreJugadors() {return nombreJugadors;}
    public void afageixPersonal(Vector<Jugador> _jugadorsP, Vector<Jugador> _jugadorsB, Entrenador e) {
        entrenador = e;
        Jugadors = new Vector<Jugador>();
        Jugadors.addAll(_jugadorsP);
        Jugadors.addAll(_jugadorsB);
        nombreJugadors = _jugadorsP.size() + _jugadorsB.size();
    }
    @Override
    public String toString(){
        return " CODI EQUIP: " + String.valueOf(codi) + " NOM: " + nom + " ";
    }

}