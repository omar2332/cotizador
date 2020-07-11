package Principal;


import java.util.List;


public class Cotizacion {
    public String fecha;
    public int posc,id_coti,vigencia = 8;
    public double iva,descuento,total,subtotal;
    public Cliente cliente;
    public List<Productos> listaProducto;

    public Cotizacion(int id_coti, double iva, double descuento) {
        this.id_coti = id_coti;
        this.iva = iva;
        this.descuento = descuento;
    }
    
    
    public void setFechaActual(){
        
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
