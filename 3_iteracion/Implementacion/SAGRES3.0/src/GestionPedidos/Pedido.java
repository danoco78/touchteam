/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Gaspar
 */
public class Pedido {
    private Integer codMesa;
    private Integer codPedido;
    private Timestamp fecha;
    private ArrayList<ElementoPedido> elementos;
    private Integer estado;
    /**
     * La variable estado puede tener 3 formas
     * 0 = Modificable
     * 1 = Bloqueado
     * 2 = Facturado
     */
    public static Integer MODIFICABLE = 0;
    public static Integer BLOQUEADO = 1;
    public static Integer FACTURADO = 2;



    public Pedido(){
        super();
        elementos = new ArrayList<ElementoPedido>();
    }
    
    public Pedido(Integer codMesa, Integer codPedido, Integer estado, Timestamp fecha){
        this();
        this.codMesa = codMesa;
        this.codPedido = codPedido;
        this.estado = estado;
        this.fecha = fecha;
    }
    public void setEstado(Integer estado){
        this.estado = estado;
    }

    public Integer getCodMesa(){
        return codMesa;
    }
    public Integer getCodPedido(){
        return codPedido;
    }
    public Integer getEstado(){
        return estado;
    }

    /*
     * @brief Obtiene la fecha y la hora del pedido
     * @return un objeto de tipo Timestamp indicando ambos
     */
    public Timestamp getFecha(){
        return fecha;
    }

    public ArrayList<ElementoPedido> obtieneElementos(){
        return this.elementos;
    }

    public void asocia(ElementoColaCocina elem){
        elementos.add(elem);
    }
    public void asocia(ElementoColaBar elem){
        elementos.add(elem);
    }

    public ArrayList<ElementoPedido> getElementos() {
        return this.elementos;
    }

    /**
     * Comprueba si un pedido es igual a otro, esto sucede cuando tanto el código
     * como sus elementos (sus estados) son iguales.
     * @param p Pedido a comparar
     * @return Booleano que indica si son iguales
     */
    public boolean equals(Pedido p){
        boolean iguales = true;
        iguales = this.codPedido == p.getCodPedido();
        if(iguales){
            ArrayList<ElementoPedido> elementosP = p.getElementos();
            if(this.elementos.size() == elementosP.size()){
                Iterator<ElementoPedido> it = elementos.iterator();
                Iterator<ElementoPedido> itthat;
                while(it.hasNext() && iguales){
                    ElementoPedido next = it.next();
                    boolean encontrado = false;
                    itthat = p.getElementos().iterator();
                    ElementoPedido elePed2 = null;
                    while(itthat.hasNext() && !encontrado){
                        elePed2 = itthat.next();
                        if(elePed2.equals(next)){
                            encontrado = true;
                        }
                    }
                    if(!encontrado) iguales = false;
                    else if(elePed2.getEstado() != next.getEstado())
                        iguales = false;
                }
            }else{
                iguales = false;
            }
        }

        return iguales;
    }
}
