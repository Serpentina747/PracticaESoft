import java.util.*; 
public class Entrenador extends Persona{
    private boolean pendentArbitre;
    private Equip equip;
    private Vector<Instruccio> instruccions;
	private Partit partit;

	public Entrenador(Partit part, Equip eq) {
		
		partit=part;
		equip=eq;
		instruccions = new ArrayList<Instruccio>();
		pendentArbitre=false;
	}
	
    public void canviarJugador(Instruccio instr){
		partit.posarJugadorPista(instr);
		partit.posarJugadorBanqueta(instr);
		instruccions.add(instr);
    }
    public void rebreInstruccio(Instruccio instr){
		System.out.println(instr.missatge());
		instruccions.add(instr);
    }
    public void assignarRol(Instruccio instr){
		partit.assignarRolJugador(instr);
		instruccions.add(instr);
    }
    public void enviarMissatgeJugadors(Instruccio instr){
		partit.missatgeJugadors(instr);
		instruccions.add(instr);
    }
    public Equip equip(){
        return equip;
    }
    public boolean pendentArbitre(){
        return pendentArbitre;
    }
}
