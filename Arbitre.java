import java.util.ArrayList;

public class Arbitre extends Persona{

	ArrayList<Instruccio> instruccions;

	//brief: Constructor amb paràmetres d'Arbitre
	public Arbitre(String _nom, String _cognom, int _llicencia_federativa, Partit _partit) {
		super.nom = _nom;
		super.cognom = _cognom;
		super.llicencia_federativa = _llicencia_federativa;
		super.partit = _partit;
		instruccions = new ArrayList<Instruccio>();
	}

	//brief: Executa una exclusió amb la Sancio sans
	public void excloure(Sancio sans){
		
		partit.exclouJugador(sans);
		instruccions.add(sans);
	}
	@Override
	public String toString(){
		return " NOM: " + super.nom + " COGNON: " + super.cognom + " LLICENCIA FEDERATIVA: " + super.llicencia_federativa + " ";
	}
}
