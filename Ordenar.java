
package AlgoritmoDeKruskal;

public class Ordenar {
    
    public static Arista [] ordenarBurbuja (Arista[] A){
        int i, j;
        Arista aux;
        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {
                if (A[j + 1].getPeso() < A[j].getPeso()) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }
        return A;
    }
}
