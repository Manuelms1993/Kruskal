package AlgoritmoDeKruskal;

import java.util.TreeSet;

public class ConjuntoArista {
    
    private Arista[] aristas;
    private int actual;
    
    public ConjuntoArista(int tam) {
        aristas=new Arista[tam];
        actual=0;
    }

    public Arista[] getAristas() {
        return aristas;
    }

    public boolean estaLleno() {
        return aristas[aristas.length-1]!=null;
    }
    
    private void incrementar() {
        if ( actual<aristas.length-1) 
            actual++;
    }

    public void add(Arista e) {
        aristas[actual]=e;
        incrementar();
    }
}
