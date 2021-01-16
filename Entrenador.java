import java.util.*; 
public class Entrenador extends Persona{
    private boolean pendentArbitre;
    private Equip equip;
    private Vector<Instruccio> instruccions;
    private char CoV;

	public Entrenador(String _nom, String _cognom, int _llicencia_federativa, Equip eq, Partit _partit, char cOv) {
      super.nom = _nom;
      super.cognom = _cognom;
      super.llicencia_federativa = _llicencia_federativa;
      super.partit = _partit;
      equip=eq;
      instruccions = new Vector<Instruccio>();
      pendentArbitre=false;
      CoV = cOv;
	  }
    public void canviarJugador(Canvi canv){
	      canv.jugadorBanqueta().enviarPista();
		  super.partit.posarJugadorPista(canv.jugadorBanqueta());
		  canv.jugadorPista().enviarBanqueta();
		  super.partit.posarJugadorBanqueta(canv.jugadorPista());
		  instruccions.add(canv);
    }
    public void rebreInstruccio(Instruccio instr){
		  System.out.println(instr.missatge());
		  instruccions.add(instr);
    }
    public void assignarRol(Assignacio assig){
		  super.partit.assignarRolJugador(assig);
		  instruccions.add(assig);
    }
    public void enviarMissatgeJugadors(Instruccio instr){
		  if (super.partit.missatgeJugadors(instr) == -1) System.out.println("HI HA HAGUT UN ERROR");
		  else System.out.println("MISSATGE TRANSMES");
		  instruccions.add(instr);
    }
    public Equip equip(){
      return equip;
    }
    public boolean pendentArbitre(){
        return pendentArbitre;
    }
    public char CoV() {return CoV;}
    @Override
    public String toString(){
      return " NOM: " + super.nom + " COGNOM: " + super.cognom + " LLICENCIA FEDERATIVA: " + super.llicencia_federativa + " EQUIP: " + equip + " ";
    }
}
