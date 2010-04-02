package pr_cript_1;

/**
 * @author Adrián Víctor Pérez Lopera
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("MCD: "+Algoritmo.Euclides(1005,450).toString());
        System.out.println("MCD: "+Algoritmo.Bezout(1005,450).get(0)+
                           " U: "+Algoritmo.Bezout(1005,450).get(1)+
                           " V: "+Algoritmo.Bezout(1005,450).get(2));
        System.out.println("INVERSO: "+Algoritmo.Inverso(1542,391).toString());
    }
}
