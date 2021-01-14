import java.util.*;  
class Instruccio {
    private int codiInstruccio;
    private Persona emisor;
    private Vector<Persona> receptors;
    private String missatge;
    private String llocRebuda;

    public int codiInstruccio(){
        return codiInstruccio;
    }
    public Persona emisor(){
        return emisor;
    }
    public String missatge(){
        return missatge;
    }
    public Vector<Persona> receptors(){
        return receptors;
    }
}