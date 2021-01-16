import java.util.*;

public class Partit{
    private Equip _equipCasa;
    private Equip _equipVisitant;
    private Arbitre _arbitre1, _arbitre2;
    private Vector<Jugador> _banquetaCasa, _banquetaVisitant, _pistaCasa, _pistaVisitant,
            _jugadorsExclosos, _jugadorsExpulsats;

    //brief: Constructor per defecte de Partit
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

    //brief: Constructor amb paràmetres de Partit
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
        else if (receptors.isEmpty()) return -1;
        else {
            for (Jugador j : receptors) j.rebreMissatge(ins);
            return 1;
        }
    }

    //brief: Exclou un jugador de la llista que el conté afegint-lo a la llista d'exclosos i traient-lo de la pista.
        //   Si el jugador té més de 3 excllusions, l'expulsa cridant expulsaJugador(s)
    //Retorna 1 si exclou al jugador, 2 si l'expulsa i -1 si no el troba
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
            _jugadorsExclosos.add(s.jugadorPista());
            jPista.remove(i);

            if (s.jugadorPista().excloure()==3){
                expulsaJugador (s);
                return 2;
            } else return 1;
        }
    }

    //brief: Expulsa un jugador de la llista que el conté afegint-lo a la llista d'expulsats i traient-lo de la pista.
    //Retorna 1 si exclou al jugador, 2 si l'expulsa i -1 si no el troba
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
            _jugadorsExclosos.remove(s.jugadorPista());
            return 1;
        }

    }

    //brief: Mira on es troba el Jugador j, l'afageix a la pista i el treu de la banqueta
    public void posarJugadorPista(Jugador j)
    {
        if (j.nomEquip().equals(_equipCasa.nom())) {
            _pistaCasa.add(j);
            _banquetaCasa.remove(j);
            System.out.println("Jugador " + j.nom() + " inserit a Pista");
        }
        else if (j.nomEquip().equals(_equipVisitant.nom())) {
            _pistaVisitant.add(j);
            _banquetaVisitant.remove(j);
            System.out.println("Jugador " + j.nom() + " inserit a Pista");
        }
        else {System.out.println("Error, jugador no inserit a pista!");}

    }

    //brief: Mira on es troba el Jugador j, l'afageix a la banqueta i el treu de la pista
    public void posarJugadorBanqueta(Jugador j)
    {
        if (j.nomEquip().equals(_equipCasa.nom())) {
            _banquetaCasa.add(j);
            _pistaCasa.remove(j);
            System.out.println("Jugador " + j.nom() + " inserit a Banqueta");
        }
        else if (j.nomEquip().equals(_equipVisitant.nom())) {
            _banquetaVisitant.add(j);
            _pistaVisitant.remove(j);
            System.out.println("Jugador " + j.nom() + " inserit a Banqueta");
        }
        else {System.out.println("Error, jugador no inserit a banqueta!");}

    }

    //brief: Assigna el rol que conté assig a tots els jugadors que s'ha de canviar
    public void assignarRolJugador(Assignacio assig)
    {
        for (Jugador j: assig.receptors()) j.canviarRol(assig);
    }

    //brief: S'afageixen els Equips al partit
    public void entrarEquips(Equip local, Equip visitant){
        _equipCasa = local;
        _equipVisitant = visitant;
    }

    //brief: S'afageixen els àrbitres al partit
    public void entrarArbitres(Arbitre arbitre_1, Arbitre arbitre_2){
        _arbitre1 = arbitre_1;
        _arbitre2 = arbitre_2;
    }

    //brief: S'afageixen els jugadors al partit als seus corresponents vectors
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

    // brief: retorna l'estructura corresponent als jugadors de l'equip local que es troben a la banqueta.
    public Vector<Jugador> jugadorsEquipLocalBanqueta(){
        return _banquetaCasa;
    }
    // brief: retorna l'estructura corresponent als jugadors de l'equip local que es troben a la pista.
    public Vector<Jugador> jugadorsEquipLocalPista(){
        return _pistaCasa;
    }
    // brief: retorna l'estructura corresponent als jugadors de l'equip visitant que es troben a la banqueta.
    public Vector<Jugador> jugadorsEquipVisitantBanqueta(){
        return _banquetaVisitant;
    }
    // brief: retorna l'estructura corresponent als jugadors de l'equip visitant que es troben a la pista.
    public Vector<Jugador> jugadorsEquipVisitantPista(){
        return _pistaVisitant;
    }
    // brief: retorna l'equip que representa l'equip local.
    public Equip equipLocal(){
        return _equipCasa;
    }
    // brief: retorna l'equip que representa l'equip visitant.
    public Equip equipVisitant(){
        return _equipVisitant;
    }
    // brief: retorna l'àrbitre 1.
    public Arbitre arbitre1(){
        return _arbitre1;
    }
    // brief: retorna l'àrbitre 2.
    public Arbitre arbitre2(){
        return _arbitre2;
    }
}
