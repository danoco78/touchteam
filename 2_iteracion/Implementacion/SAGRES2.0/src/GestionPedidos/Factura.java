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
public class Factura {
    private Integer codFactura;
    private Integer estado;
    private Date fecha;
    private ArrayList<Pedido> pedidosAsociados;

    protected static final int ENCOLA = 0;
    protected static final int IMPRIMIDO = 1;
    protected static final int PAGADO = 1;

    public Factura(Integer codFactura, Integer estado, Date fecha){
        this.codFactura = codFactura;
        this.estado = estado;
        this.fecha = fecha;
    }
    public Integer getCodFactura() {
        return codFactura;
    }
    //TODO Preguntar que hace esta función
    public Factura crear(){
        Factura nueva = new Factura(0,0,fecha);
        return nueva;
    }
    public void setCodFactura(Integer codFactura) {
        this.codFactura = codFactura;
    }

    public Integer getEstado() {
        return estado;
    }

    public void modificaEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Pedido> getPedidos(){
        return pedidosAsociados;
    }

    public void asocia(Pedido p){
        this.pedidosAsociados.add(p);
    }
    
}
