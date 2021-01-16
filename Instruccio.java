import java.lang.reflect.Array;
import java.util.*;
public class Instruccio {
    protected int codiInstruccio;
    protected Persona emisor;
    protected Vector<Jugador> receptors;
    protected String missatge;
    protected String llocRebuda;
    protected char CoV;

    //brief : constructor per defecte buit.
    public Instruccio(){}

    //brief : constructor amb paràmetres.
    public Instruccio(int codi, Persona e, Vector<Jugador> recept, String miss, String llocReb, char cOv)
    {
        codiInstruccio = codi;
        emisor = e;
        receptors = recept;
        missatge = miss;
        llocRebuda = llocReb;
        CoV = cOv;
    }
    //brief : retorna un enter que correspon amb el codi de la instrucció.
    public int codiInstruccio(){
        return codiInstruccio;
    }
    //brief : retorna la persona que correspon amb l'emisor de la instrucció.
    public Persona emisor(){
        return emisor;
    }
    //brief : retorna una cadena de caràcters amb el missatge de la instrucció.
    public String missatge(){
        return missatge;
    }
    //brief : retorna una estructura de Jugadors que correspon amb els receptors del missatge.
    public Vector<Jugador> receptors(){
        return receptors;
    }
    //brief : retorna un caràcter que indica si el missatge va dirigit a persones de l'equip casa o visitant.
    public char CoV() {return CoV;}
    //brief : retorna una cadena de caràcters indicant si es rep a la banqueta o a la pista.
    public String llocRebuda() {return llocRebuda;}
}

