import java.util.*; 
public class Entrenador extends Persona{
    private boolean pendentArbitre;
    private Equip equip;
    private ArrayList<Instruccio> instruccions;
	  private Partit partit;

  public Entrenador(String _nom, String _cognom, int _llicencia_federativa, Equip _equip){
    super.nom = _nom;
    super.cognom = _cognom;
    super.llicencia_federativa = _llicencia_federativa;
    equip = _equip;
    pendentArbitre = false;
    instruccions = new ArrayList<Instruccio>();
    partit = null;
  }
	public Entrenador(Partit part, Equip eq) {
		
		partit=part;
		equip=eq;
		instruccions = new ArrayList<Instruccio>();
		pendentArbitre=false;
	}
	
    public void canviarJugador(Canvi instr){
		partit.posarJugadorPista(instr);
		partit.posarJugadorBanqueta(instr);
		instruccions.add(instr);
    }
    public void rebreInstruccio(Canvi instr){
		System.out.println(instr.missatge());
		instruccions.add(instr);
    }
    public void assignarRol(Assignacio instr){
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

    @Override
    public String toString(){
      return super.nom + " " + super.cognom + " " + super.llicencia_federativa + equip + " ";
    }
}
