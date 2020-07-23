package Principal;

import java.sql.SQLException;

 
public class Productos {
    public int id_productos,cantidad;
    public String descripcion;
    public double precio;
    
    

    public Productos(int id_productos, int cantidad, String descripcion, double precio) {
        this.id_productos = id_productos;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    
    
    
    public Productos(int id_productos, String descripcion, double precio) {
        this.id_productos = id_productos;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public boolean editar(int id_productos, String descripcion, double precio) throws ClassNotFoundException, SQLException{
        this.id_productos = id_productos;
        this.descripcion = descripcion;
        this.precio = precio;
        MenuPrincipal.consultas.cambiosProducto("update productos set id_producto  = "+ id_productos +", descripcion = '"+descripcion + "', precio = " + precio +" where id_producto = " + id_productos);
        
        return true;
    }
    
    
    
    
    
}
