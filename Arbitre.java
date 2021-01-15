import java.util.ArrayList;

public class Arbitre extends Persona{

	ArrayList<Instruccio> instruccions;

	public Arbitre(String _nom, String _cognom, int _llicencia_federativa) {
		super.nom = _nom;
		super.cognom = _cognom;
		super.llicencia_federativa = _llicencia_federativa;
		instruccions = new ArrayList<Instruccio>();
	}
	
	public void excloure(Sancio sans){
		
		partit.exclouJugador(sans);
		instruccions.add(sans);
	}
	
}
