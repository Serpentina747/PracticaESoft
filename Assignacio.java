import java.util.*;

public class Assignacio extends Instruccio{
    private Rol nouRol;

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
    public Rol nouRol(){
        return nouRol;
    }
}