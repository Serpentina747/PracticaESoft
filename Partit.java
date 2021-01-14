import java.util.*; 
public class Partit{

    private Equip equip_1;
    private Equip equip_2;
    private Arbitre arbitre_1;
    private Arbitre arbitre_2;
    private Vector<Jugador> BanquetaEquipCasa;
    private Vector<Jugador> BanquetaEquipForaster;
    private Vector<Jugador> Pista;


    public Partit(){
        equip_1 = null;
        equip_2 = null;
        arbitre_1 = null;
        arbitre_2 = null;
        BanquetaEquipCasa = null;
        BanquetaEquipForaster = null;
        Pista = null;
    }
    public Partit(Equip _equip_1, Equip _equip_2, Arbitre _arbitre_1, Arbitre _arbitre_2){
        equip_1 = _equip_1;
        equip_2 = _equip_2;
        arbitre_1 = _arbitre_1;
        arbitre_2 = _arbitre_2;
        BanquetaEquipCasa = new Vector<Jugador>();
        BanquetaEquipForaster = new Vector<Jugador>();
        Pista = new Vector<Jugador>();
    }
    public void excloureJugador(Sancio sancio){

    }
    public void posarJugadorPista(Canvi canvi){

    }
    public void posarJugadorBanqueta(Canvi canvi){
        
    }
    public void assignarRolJugador(Assignacio assignacio){
        
    }
    public void missatgeJugadors(Instruccio Instruccio){
        
    }
    
}