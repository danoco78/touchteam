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
public class Factura {
    private Integer codFactura;
    private Integer estado;
    private Date fecha;

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



}
