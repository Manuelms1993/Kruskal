package AlgoritmoDeKruskal;

import java.util.ArrayList;

public class Grafo {
    
    private Arista[] aristas;
    private int nAristas;
    private Nodo[] nodos;

    public Grafo(int nNodos, int nAristas) {
        nodos= new Nodo[nNodos];
        aristas= new Arista[nAristas];
        nAristas=0;
        for (int i = 0; i < nNodos; i++)
            nodos[i]= new Nodo(i);  
        
    }
    
    public void setArista(int nodoA, int nodoB, float peso){
        aristas[nAristas++]= new Arista(nodos[nodoA-1], nodos[nodoB-1], peso);
    }

    public Arista[] getAristas() {
        int n=0;
        for (int i = 0; i < aristas.length; i++)
            if (aristas[i]!=null) n++;
        Arista[] a = new Arista[n];
        for (int i = 0; i < n; i++)
            a[i]=aristas[i];
        return a;
    }

    public Nodo[] getNodos() {
        return nodos;
    }

    public boolean isConexo() {
        boolean[] nodosVisitados = new boolean[nodos.length];
        recorridoEnProfundidad(nodosVisitados,0);
        for (int i = 0; i < nodosVisitados.length; i++)
            if (!nodosVisitados[i]) 
                return false;
        return true;
    }

    private void recorridoEnProfundidad(boolean[] nodosVisitados, int nodoActual) {
        if (!nodosVisitados[nodoActual]){
           nodosVisitados[nodoActual]=true;
           ArrayList<Nodo> nodo = getAristas(nodoActual);
            for (Nodo n : nodo) {
                recorridoEnProfundidad(nodosVisitados,n.getId());
            }
        }
    }

    private ArrayList<Nodo> getAristas(int nodo) {
        int n=0;
        ArrayList<Nodo> listaNodo=  new ArrayList<>();
        for (Arista arista : aristas){
            if (arista.getA().getId()==nodo)
                listaNodo.add(arista.getB());
            if(arista.getB().getId()==nodo)
                listaNodo.add(arista.getA());
        }
        return listaNodo;
    }
    
    
}