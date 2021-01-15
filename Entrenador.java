import java.util.*; 
public class Entrenador extends Persona{
    private boolean pendentArbitre;
    private Equip equip;
    private Partit partit;
    private Vector<Instruccio> instruccions;

	public Entrenador(String _nom, String _cognom, int _llicencia_federativa, Equip eq, Partit _partit) {
        super.nom = _nom;
        super.cognom = _cognom;
        super.llicencia_federativa = _llicencia_federativa;
        super.partit = _partit;
        equip=eq;
        instruccions = new Vector<Instruccio>();
        pendentArbitre=false;
	}
	
    public void canviarJugador(Canvi canv){
		partit.posarJugadorPista(canv.jugadorPista());
		partit.posarJugadorBanqueta(canv.jugadorBanqueta());
		instruccions.add(canv);
    }
    public void rebreInstruccio(Instruccio instr){
		System.out.println(instr.missatge());
		instruccions.add(instr);
    }
    public void assignarRol(Assignacio assig){
		partit.assignarRolJugador(assig);
		instruccions.add(assig);
    }
    public void enviarMissatgeJugadors(Instruccio instr){
		if (super.partit.missatgeJugadors(instr) == -1) System.out.println("NULL");
		else System.out.println("EMPTY");
		instruccions.add(instr);
    }
    public Equip equip(){
        return equip;
    }
    public boolean pendentArbitre(){
        return pendentArbitre;
    }
    @Override
    public String toString(){
      return super.nom + " " + super.cognom + " " + super.llicencia_federativa + " " + equip + " ";
    }
}
