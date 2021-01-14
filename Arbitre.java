import java.util.*;  
public class Arbitre extends Persona{
	
	List<Instruccio> instruccions;
	
	public Arbitre(String _nom, String _cognom, int _llicencia_federativa) {
		super.nom = _nom;
		super.cognom = _cognom;
		super.llicencia_federativa = _llicencia_federativa;
		super.partit = null;
		instruccions = new ArrayList<Instruccio>();
	}
	public void assignarPartit(Partit part) {
		
		super.partit=part;
		instruccions = new ArrayList<Instruccio>();
	}
	
	public void excloure(Sancio instr){
		
		partit.excloureJugador(instr);
		instruccions.add(instr);
	}
	@Override
	public String toString(){
		return super.nom + " " + super.cognom + " " +  super.llicencia_federativa + " ";
	}
	
}
