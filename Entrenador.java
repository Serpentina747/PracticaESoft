import java.util.*; 
public class Entrenador extends Persona{
    private boolean pendentArbitre;
    private Equip equip;
    private Vector<Instruccio> instruccions;
    private char CoV;

    //brief: Constructor amb paràmetres d'Entrenador
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

    //brief: Executa un canvi de jugadors (amb el Canvi canv que conté el jugador que anirà a la banqueta i el jugador que anirà a la pista)
    public void canviarJugador(Canvi canv){
	      canv.jugadorBanqueta().enviarPista();
		  super.partit.posarJugadorPista(canv.jugadorBanqueta());
		  canv.jugadorPista().enviarBanqueta();
		  super.partit.posarJugadorBanqueta(canv.jugadorPista());
		  instruccions.add(canv);
    }

    //brief: Es mostra el missatge que conté instr i s'afageix al vector d'Instruccions
    public void rebreInstruccio(Instruccio instr){
		  System.out.println(instr.missatge());
		  instruccions.add(instr);
    }

    //brief: Assigna un rol als jugadors que conté assig
    public void assignarRol(Assignacio assig){
		  super.partit.assignarRolJugador(assig);
		  instruccions.add(assig);
    }
    //brief: Envia un missatge als jugadors controlant errors, i afageix la instrucció al vector d'instruccions
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
