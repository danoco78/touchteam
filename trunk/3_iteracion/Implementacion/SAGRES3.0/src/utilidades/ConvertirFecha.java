/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;
import java.sql.Timestamp;

/**
 *
 * @author nabil
 */
public class ConvertirFecha {
    public String fecha;

    public ConvertirFecha(){
        this.fecha = "";
    }
    public String obtieneAnioMesDia(Timestamp f){
        int numero;
        String cad;
         this.fecha = "'";
        numero = f.getYear()+1900;
        cad = Integer.toString(numero);
        fecha = fecha +cad+"-";
        numero = f.getMonth()+1;
        if(numero <10){
            cad = "0"+Integer.toString(numero);
        }
        else
            cad = Integer.toString(numero);
        
        fecha = fecha +cad+"-";
        numero = f.getDate();
        if(numero <10){
            cad = "0"+Integer.toString(numero);
        }
        else
            cad = Integer.toString(numero);
        fecha = fecha +cad+"'";
         return this.fecha;
    }
    public String mes(Timestamp i)
    {   int numero;
        String cadena;
        numero = i.getMonth()+1;
        if(numero <10){
            cadena = "0"+Integer.toString(numero);
        }
        else
            cadena = Integer.toString(numero);
      return cadena;
    }
    public String mesAnio(Timestamp i)
    {   int numero;
        String cad;
        fecha = "";
        numero = i.getYear()+1900;
        cad = Integer.toString(numero);
        fecha = fecha +cad+"/";
        numero = i.getMonth()+1;
        if(numero <10){
            cad = "0"+Integer.toString(numero);
        }
        else
            cad = Integer.toString(numero);

       fecha = fecha +cad;
       return fecha;
    }
    
}
