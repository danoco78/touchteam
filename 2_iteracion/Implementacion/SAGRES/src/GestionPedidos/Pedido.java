/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPedidos;
import java.util.Date;

/**
 *
 * @author Gaspar
 */
public class Pedido {
    private Integer codMesa;
    private Integer codPedido;
    private Date fecha;
    /**
     * La variable estado puede tener 3 formas
     * 0 = Modificable
     * 1 = Bloqueado
     * 2 = Facturado
     */
    private Integer estado;

    public void setCodPedido(Integer codPedido) {
        this.codPedido = codPedido;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCodMesa(Integer codMesa){
        this.codMesa = codMesa;
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
     * @return un objeto de tipo Date indicando ambos
     */
    public Date getFecha(){
        return fecha;
    }
}
