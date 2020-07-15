package Principal;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Cotizacion {
    
    public String fecha;
    public int posc,id_coti,vigencia = 8;
    public double iva,descuento,total,subtotal;
    public Cliente cliente;
    public List<Productos> listaProducto;
    public String totalConLetras ;
    
    public Cotizacion(int id_coti, double iva, double descuento) {
        this.id_coti = id_coti;
        this.iva = iva;
        this.descuento = descuento;
    }
    
    
    public void setFechaActual(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //tomamos la fecha actual 
        this.fecha= dateFormat.format(date);
    }
    
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Float.parseFloat(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
    
}
