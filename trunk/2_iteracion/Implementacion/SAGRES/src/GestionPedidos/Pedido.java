/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Gaspar
 */
public class Pedido {
    private Integer codMesa;
    private Integer codPedido;
    private Date fecha;
    private ArrayList<ElementoPedido> elementos;

    /**
     * La variable estado puede tener 3 formas
     * 0 = Modificable
     * 1 = Bloqueado
     * 2 = Facturado
     */
    private Integer estado;

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
     * @return un objeto de tipo Date indicando ambos
     */
    public Date getFecha(){
        return fecha;
    }

    public ArrayList<ElementoPedido> obtieneElementos(){
        return this.elementos;
    }

    void asocia(ElementoColaCocina elem){

    }
    void asocia(ElementoColaBar elem){

    }
}