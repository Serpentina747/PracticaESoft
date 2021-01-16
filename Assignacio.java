import java.util.*;

public class Assignacio extends Instruccio{
    private Rol nouRol;

    //brief: Constructor amb paràmetres d'Assignació.
    public Assignacio (int codi, Persona e, Vector<Jugador> recept, String miss, String llocReb, char cOv, Rol r)
    {
        super.codiInstruccio = codi;
        super.emisor = e;
        super.receptors = recept;
        super.missatge = miss;
        super.llocRebuda = llocReb;
        super.CoV = cOv;
        nouRol = r;
    }
    //brief: retorna el nou Rol que s'assigna al jugador.
    public Rol nouRol(){
        return nouRol;
    }
}