package AlgoritmoDeKruskal;

import java.util.Objects;

public class Arista implements Comparable{
    
    private Nodo a;
    private Nodo b;
    private float peso;

    public Arista(Nodo a, Nodo b, float peso) {
        this.a = a;
        this.b = b;
        this.peso=peso;
    }

    public Nodo getA() {
        return a;
    }

    public Nodo getB() {
        return b;
    }

    @Override
    public int compareTo(Object o) {
        Arista a = (Arista)o;
        return a.peso<this.peso? 1:(a.peso>this.peso? -1:0); 
    }

    @Override
    public String toString() {
        return "El nodo "+(a.getId()+1)+" y el nodo "+(b.getId()+1)+" estan unidos por una arista de peso "+peso+"\n";
    }

    @Override
    public int hashCode() {
        String hash = ""+a.getId()+","+b.getId()+","+peso;
        return hash.hashCode();
    }

    public float getPeso() {
        return peso;
    }
}
