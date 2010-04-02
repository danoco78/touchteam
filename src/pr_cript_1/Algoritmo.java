package pr_cript_1;

import java.util.ArrayList;

/**
 * @author Adrián Víctor Pérez Lopera
 */
public class Algoritmo {
    /**
     * @param a num entero
     * @param b num entero
     * @return mcd(a,b)
     */
    public static Integer Euclides(Integer a, Integer b) {
        Integer aux;
        while(b > 0) {
            aux = b;
            b = a%b;
            a = aux;
        }
        return a;
    }

    /**
     * @param a num entero
     * @param b num entero
     * @return (d,u,v): d = mcd(a,b); d = au + bv
     */
    public static ArrayList Bezout(Integer a, Integer b) {
        ArrayList salida = new ArrayList();
        if(b==0) {
            salida.add(a);
            salida.add(1);
            salida.add(0);
            return salida;
        }
        Integer x = 1, u = 0, y = 0, v = 1, r = a%b;
        while(r != 0) {
            Integer c = a / b, x_aux = x, y_aux = y;
            x = u; u = x_aux-(u*c);
            y = v; v = y_aux-(v*c);
            a = b; b = r;
            r = a%b;
        }
        salida.add(b);
        salida.add(u);
        salida.add(v);
        return salida;
    }

    /**
     * @param n num entero
     * @param a num entero
     * @return inverso de a en Zn, si es que existe
     */
    public static Integer Inverso(Integer n, Integer a) {
        Integer y = 0, v = 1, r = n%a;
        while(r != 0) {
            Integer c = n / a, y_aux = y;
            y = v; v = y_aux-(v*c);
            n = a; a = r;
            r = n%a;
        }
        if(a != 1) // No existe el inverso
            return 0;
        return v;
    }
}
