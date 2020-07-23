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
    public boolean guardado;
    
    public Cotizacion(int id_coti, double iva, double descuento) {
        this.id_coti = id_coti;
        this.iva = iva;
        this.descuento = descuento;
        this.guardado = false;
    }
    
    public void guardado(){
         this.guardado = true;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setPosc(int posc) {
        this.posc = posc;
    }

    public void setId_coti(int id_coti) {
        this.id_coti = id_coti;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setListaProducto(List<Productos> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public void setTotalConLetras(String totalConLetras) {
        this.totalConLetras = totalConLetras;
    }
    
    
    
    
    
    
    
    public void setFechaActual(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); //tomamos la fecha actual 
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
