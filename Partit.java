import java.util.*;

public class Partit{
    private Equip _equipCasa;
    private Equip _equipVisitant;
    private Arbitre _arbitre1, _arbitre2;
    private Vector<Jugador> _banquetaCasa, _banquetaVisitant, _pistaCasa, _pistaVisitant,
            _jugadorsExclosos, _jugadorsExpulsats;

    public Partit()
    {
        _equipCasa = null;
        _equipVisitant = null;
        _arbitre1 = null;
        _arbitre2 = null;
        _banquetaCasa = new Vector<Jugador>();
        _banquetaVisitant = new Vector<Jugador>();
        _pistaCasa = new Vector<Jugador>();
        _pistaVisitant = new Vector<Jugador>();
        _jugadorsExclosos = new Vector<Jugador>();
        _jugadorsExpulsats = new Vector<Jugador>();

    }

    public Partit(Equip eCasa, Equip eVisitant, Arbitre arbitre1, Arbitre arbitre2,
                  Vector<Jugador> banquetaCasa, Vector<Jugador> banquetaVisitant, Vector<Jugador> pistaCasa, Vector<Jugador> pistaVisitant)
    {
        _equipCasa = eCasa;
        _equipVisitant = eVisitant;
        _arbitre1 = arbitre1;
        _arbitre2 = arbitre2;
        _banquetaCasa = banquetaCasa;
        _banquetaVisitant = banquetaVisitant;
        _pistaCasa = pistaCasa;
        _pistaVisitant = pistaVisitant;
        _jugadorsExclosos = new Vector<Jugador>();
        _jugadorsExpulsats = new Vector<Jugador>();
    }

    //Pre: instrucció != null
    //Post: Envia l'instrucció que conté un missatge als jugadors que ins indica.
    //Retorna 1 va bé, 0 si no s'envia a ningú i -1 si la llista és null
    public int missatgeJugadors(Instruccio ins)
    {
        Vector<Jugador> receptors = null;
        switch (ins.llocRebuda()) {
            case "banqueta":
                if (ins.CoV()=='C') receptors = _banquetaCasa;
                else receptors = _banquetaVisitant;
                break;
            //Altres possibles casos ...
            default:
                receptors = ins.receptors();
                break;
        }

        if (receptors == null ) return -1;
        else if (receptors.isEmpty()) return 0;
        else {
            for (Jugador j : receptors) j.rebreMissatge(ins);
            return 1;
        }
    }

    public int exclouJugador(Sancio s)
    {
        Vector<Jugador> jPista = null;
        boolean trobat=false;
        if (s.CoV()=='C') jPista = _pistaCasa;
        else jPista = _pistaVisitant;

        int i=0;
        for (Jugador j: jPista) {
            if (j.nom().equals(s.jugadorPista().nom())) {
                trobat = true;
                break;
            }
            else i++;
        }
        if (!trobat) return -1;
        else {
            _jugadorsExpulsats.add(s.jugadorPista());
            jPista.remove(i);
            return 1;
        }
    }

    public int expulsaJugador(Sancio s)
    {
        Vector<Jugador> jPista = null;
        boolean trobat=false;
        if (s.CoV()=='C') jPista = _pistaCasa;
        else jPista = _pistaVisitant;
        int i=0;
        for (Jugador j: jPista) {
            if (j.nom().equals(s.jugadorPista().nom())) {
                trobat = true;
                break;
            }
            else i++;
        }
        if (!trobat) return -1;
        else {
            _jugadorsExpulsats.add(s.jugadorPista());
            jPista.remove(i);
            return 1;
        }

    }

    public void posarJugadorPista(Jugador j)
    {
        if (j.nomEquip().equals(_equipCasa.nom())) _pistaCasa.add(j);
        else if (j.nomEquip().equals(_equipVisitant.nom())) _pistaVisitant.add(j);
    }

    public void posarJugadorBanqueta(Jugador j)
    {
        if (j.nomEquip().equals(_equipCasa.nom())) _banquetaCasa.add(j);
        else if (j.nomEquip().equals(_equipVisitant.nom())) _banquetaVisitant.add(j);
    }

    public void assignarRolJugador(Assignacio assig)
    {
        for (Jugador j: assig.receptors()) j.canviarRol(assig);
    }
    public void entrarEquips(Equip local, Equip visitant){
        _equipCasa = local;
        _equipVisitant = visitant;
    }
    public void entrarArbitres(Arbitre arbitre_1, Arbitre arbitre_2){
        _arbitre1 = arbitre_1;
        _arbitre2 = arbitre_2;
    }
    public void entrarJugadors(Vector<Jugador> jugadors, String pistaObanqueta, String localOvisitant){
        if(pistaObanqueta.equals("banqueta")){
            if(localOvisitant.equals("local")){
                _banquetaCasa.addAll(jugadors);
            } else if(localOvisitant.equals("visitant")){
                _banquetaVisitant.addAll(jugadors);
            }
        } else if (pistaObanqueta.equals("pista")){
            if(localOvisitant.equals("local")){
                _pistaCasa.addAll(jugadors);
            } else if(localOvisitant.equals("visitant")){
                _pistaVisitant.addAll(jugadors);
            }
        }
    }
    public Vector<Jugador> jugadorsEquipLocalBanqueta(){
        return _banquetaCasa;
    }
    public Vector<Jugador> jugadorsEquipLocalPista(){
        return _pistaCasa;
    }
    public Vector<Jugador> jugadorsEquipVisitantBanqueta(){
        return _banquetaVisitant;
    }
    public Vector<Jugador> jugadorsEquipVisitantPista(){
        return _pistaVisitant;
    }
}