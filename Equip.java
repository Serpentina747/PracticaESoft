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
    char CoV;


    //brief: Constructor amb paràmetres d'Equip.
    public Equip(int _codi, String _nom, int _nombreJugadors, Partit _partit, char cOv){
        codi = _codi;
        nom = _nom;
        nombreJugadors = _nombreJugadors;
        Jugadors = null;
        entrenador = null;
        amonestacions = 0;
        partit = _partit;
        esquemaDef = null;
        esquemaAtac = null;
        CoV = cOv;
    }

    //brief: retorna un enter que representa el nombre d'amonestacions de l'equip.
    public int amonestacions(){
        return amonestacions;
    }

    //No sabem que ha de fer ben bé encara!
    public void actualitzar(){
        
    }

    //brief: Canvia l'esquema de l'equip per el nou esquema nou
    public void canviaEsquemaAtac(Esquema nou, boolean atac){     
        if(atac) esquemaAtac = nou;
        else esquemaDef = nou;
    }
    //brief: retorna una cadena de caràcter amb el nom de l'equip.
    public String nomEquip() {return nom;}

    //brief: Afageix un jugador a l'equip
    public void donarAlta(Jugador jugador){
        Jugadors.add(jugador);
    }
    //brief: Treu un jugador de l'equip
    public void donarBaixa(Jugador jugador){
        Jugadors.add(jugador);
    }
    //brief: retorna un enter amb el nombre de jugadors de l'equip.
    public int nombreJugadors() {return nombreJugadors;}

    //brief: Afageix totes les persones de l'equip: Entrenador(e), Jugadors(pista + banqueta)
    public void afageixPersonal(Vector<Jugador> _jugadorsP, Vector<Jugador> _jugadorsB, Entrenador e) {
        entrenador = e;
        Jugadors = new Vector<Jugador>();
        Jugadors.addAll(_jugadorsP);
        Jugadors.addAll(_jugadorsB);
        nombreJugadors = _jugadorsP.size() + _jugadorsB.size();
    }

    //brief: retorna una cadena de caràcter amb el nom de l'equip.
    public String nom() {return nom;}
    //brief: retorna l'entrenador de l'equip.
    public Entrenador entrenador() {return entrenador;}
    //brief: mètode toString de l'equip.
    @Override
    public String toString(){
        return " CODI EQUIP: " + String.valueOf(codi) + " NOM: " + nom + " ";
    }

}