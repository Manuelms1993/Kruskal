package AlgoritmoDeKruskal;


public class Main {

    public static void main(String[] args) {
        Grafo g = new Grafo(7,13);
        g.setArista(1, 2, 1);
        g.setArista(2, 3, 2);
        g.setArista(1, 4, 4);
        g.setArista(1, 5, 6);
        g.setArista(2, 5, 4);
        g.setArista(3, 5, 4);
        g.setArista(3, 6, 6);
        g.setArista(3, 7, 4);
        g.setArista(4, 7, 4);
        g.setArista(5, 7, 7);
        g.setArista(5, 6, 8);
        g.setArista(5, 4, 3);
        g.setArista(6, 7, 3);
        test(g);
        
        g = new Grafo(7,13);
        g.setArista(1, 2, 1);
        g.setArista(2, 3, 1);
        g.setArista(1, 4, 1);
        g.setArista(1, 5, 1);
        g.setArista(2, 5, 1);
        g.setArista(3, 5, 1);
        g.setArista(3, 6, 1);
        g.setArista(3, 7, 1);
        g.setArista(4, 7, 1);
        g.setArista(5, 7, 1);
        g.setArista(5, 6, 1);
        g.setArista(5, 4, 1);
        g.setArista(6, 7, 1);
        test(g);
        
        int nodos=10000;
        g = new Grafo(nodos,nodos-1);
        for (int i = 1; i < nodos; i++) {
            g.setArista(i, i+1,(float) Math.random()*10);
        }
        test(g);
    }
    
    public static void test(Grafo g){
        System.out.println("Ejecutando Prueba...");
        if (!g.isConexo()){
            System.out.println("Precondicion: El grafo no es conexo");
            System.exit(1);
        }
        
        float pesoResultado=0,minimo,maximo;
        long time = System.nanoTime();
        ConjuntoArista a = Kruskal(g);
        time= System.nanoTime()-time;
        System.out.println("El tiempo en segundos es: "+ time/1000+" MicroSegundos");

        if (a.estaLleno()){
            Arista[] T = a.getAristas();
            Arista[] conjuntoAristas = Ordenar.ordenarBurbuja(g.getAristas());
            pesoResultado=sum(T,0,T.length-1);
            minimo=sum(conjuntoAristas,0,g.getNodos().length-2);
            maximo=sum(conjuntoAristas,conjuntoAristas.length-g.getNodos().length+1,conjuntoAristas.length-1);
            System.out.println("La suma es "+pesoResultado+" ["+minimo+","+maximo+"]");
        }else
            System.out.println("El grafo no es conexo");
        System.out.println("Prueba terminada.\n");
    }
    
    public static float  sum (Arista[] a, int inf, int sup){
        float s=0;
        for (int i = inf; i <= sup; i++) 
            s+=a[i].getPeso();
        return s;
    }
    
    public static ConjuntoArista Kruskal (Grafo G){
        Arista[] conjuntoAristas = Ordenar.ordenarBurbuja(G.getAristas());
        Nodo[] nodos = G.getNodos();
        int n = nodos.length;
        ConjuntoArista T = new ConjuntoArista(n-1);
        //Inicializa3
        int[] componentesConexas= new int[n];
        for (int i = 0; i < componentesConexas.length; i++)
            componentesConexas[i]=-1;
        for (int i = 0; i < conjuntoAristas.length; i++) {
            Arista e = conjuntoAristas[i];
            int compu = buscar(e.getA(),componentesConexas);
            int compv = buscar(e.getB(),componentesConexas);
            if (compu!=compv){
                fusionar(compu,compv,componentesConexas);
                T.add(e);
            }
            if(T.estaLleno()) return T;
        }
        return new ConjuntoArista(1);
    }

    private static int buscar(Nodo b, int[] componentesConexas) {
        int i = b.getId();
        while (componentesConexas[i]>-1)
            i = componentesConexas[i];
        return i;
    }

    private static void fusionar(int a, int b, int[] componentesConexas) {
        if (componentesConexas[a] == componentesConexas[b]){
            componentesConexas[a] = componentesConexas[a] - 1;
            componentesConexas[b] = a;
        }else{
            if (componentesConexas[a] < componentesConexas[b]){
		componentesConexas[b] = a;
            }else{
                componentesConexas[a] = b;
            }
        }
    }
    
}
