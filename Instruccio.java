import java.lang.reflect.Array;
import java.util.*;
public class Instruccio {
    protected int codiInstruccio;
    protected Persona emisor;
    protected Vector<Jugador> receptors;
    protected String missatge;
    protected String llocRebuda;
    protected char CoV;


    public Instruccio(int codi, Persona e, Vector<Jugador> recept, String miss, String llocReb, char cOv)
    {
        codiInstruccio = codi;
        emisor = e;
        receptors = recept;
        missatge = miss;
        llocRebuda = llocReb;
        CoV = cOv;
    }
    public int codiInstruccio(){
        return codiInstruccio;
    }
    public Persona emisor(){
        return emisor;
    }
    public String missatge(){
        return missatge;
    }
    public Vector<Jugador> receptors(){
        return receptors;
    }
    public char CoV() {return CoV;}
    public String llocRebuda() {return llocRebuda;}
}

