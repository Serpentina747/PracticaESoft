public class Arbitre extends Persona{
	
	Partit partit;
	List<Instruccio> instruccions;
	
	public Arbitre(Partit part) {
		
		partit=part;
		instruccions = new ArrayList<Instruccio>();
	}
	
	public void excloure(Instruccio instr){
		
		partit.excloureJugador(instr);
		instruccions.add(instr);
	}
	
}
