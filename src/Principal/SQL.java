package Principal;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SQL {
   final String contraseña = "123";
   final String cadenaConexion = "jdbc:postgresql://localhost:5432/cotizador?";
   Connection conexion;
   Statement sentencia;//manejo o lectura
   ResultSet resultado;//manipulacion de registros
   
   
   
   public int UnID(String consultaSQL) throws ClassNotFoundException, SQLException{
               //Para la conexion de la base de datos en postgresql
       Class.forName("org.postgresql.Driver");

        conexion = DriverManager.getConnection(cadenaConexion, "postgres", contraseña);
        sentencia = conexion.createStatement();
        resultado = sentencia.executeQuery(consultaSQL); 
        
        int IdEntero = 0;
        while (resultado.next()) {
            
            IdEntero= resultado.getInt(1); 
        }
        
        //cerramos conexion con la base de datos
        conexion.close();
        resultado.close();
        sentencia.close();

       return IdEntero;
   }
   
   public void CargaDeProducto() throws ClassNotFoundException, SQLException{
        MenuPrincipal.ProdutosMuestra.clear();
        Class.forName("org.postgresql.Driver");
        
        conexion = DriverManager.getConnection(cadenaConexion,"postgres", contraseña);
        sentencia = conexion.createStatement();
        String consultaSQL = "Select * From productos order by id_producto";
        resultado = sentencia.executeQuery(consultaSQL); //hacer la consulta
        
        

        resultado = sentencia.executeQuery(consultaSQL);//volvemos a hacer la consulta
         //llenado de la tabla
        while(resultado.next()){
            
            
            int a = Integer.parseInt(resultado.getString("id_producto"));     
            
            String arreglo[] = resultado.getString("precio").split(""), c = "";
            for(int i= 0; i<arreglo.length;i++){
                if( arreglo[i].equals("$") || arreglo[i].equals(",")){
                }else{
                    c+=arreglo[i];
                   
                }
            }
            
            double b = Double.parseDouble(c);
            
            
            Productos producto = new Productos(a,resultado.getString("descripcion"),b);
            MenuPrincipal.ProdutosMuestra.add(producto);
            
            
             
            
        }
        
        conexion.close();
        resultado.close();
        sentencia.close();
        
   }
   
   public Cliente DatosCliente(int id) throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        Cliente cliente = null;
        conexion = DriverManager.getConnection(cadenaConexion,"postgres", contraseña);
        sentencia = conexion.createStatement();
        String consultaSQL = "Select * From  clientes where id_cliente = " + String.valueOf(id);
        resultado = sentencia.executeQuery(consultaSQL); //hacer la consulta
         while(resultado.next()){
            
            
            int a = Integer.parseInt(resultado.getString("id_cliente"));     
            String puesto = "",empresa = "",nombre = "";
            
            
            
            if(resultado.getString("apellido").equals("")){
                puesto = "Null";
            }else{
                puesto = resultado.getString("apellido");
            }
            
            if(resultado.getString("empresa").equals("")){
                empresa = "Null";
            }else{
                empresa = resultado.getString("empresa");
            }
            
            if(resultado.getString("nombre").equals("")){
                nombre = "Null";
            }else{
                nombre = resultado.getString("nombre");
            }
            
            cliente = new Cliente(a,nombre,puesto,empresa);
            
            
            
             
            
        }
        conexion.close();
        resultado.close();
        sentencia.close();
        
        return cliente;
   }
   
   public void CargaClientes() throws ClassNotFoundException, SQLException{
        MenuPrincipal.ClientesMuestra.clear();
        Class.forName("org.postgresql.Driver");
        
        conexion = DriverManager.getConnection(cadenaConexion,"postgres", contraseña);
        sentencia = conexion.createStatement();
        String consultaSQL = "Select * From  clientes order by id_cliente";
        resultado = sentencia.executeQuery(consultaSQL); //hacer la consulta
        
        

        resultado = sentencia.executeQuery(consultaSQL);//volvemos a hacer la consulta
         //llenado de la tabla
        while(resultado.next()){
            
            
            int a = Integer.parseInt(resultado.getString("id_cliente"));     
            String puesto = "",empresa = "",nombre = "";
            
            
            
            if(resultado.getString("apellido").equals("")){
                puesto = "Null";
            }else{
                puesto = resultado.getString("apellido");
            }
            
            if(resultado.getString("empresa").equals("")){
                empresa = "Null";
            }else{
                empresa = resultado.getString("empresa");
            }
            
            if(resultado.getString("nombre").equals("")){
                nombre = "Null";
            }else{
                nombre = resultado.getString("nombre");
            }
            
            Cliente cliente = new Cliente(a,nombre,puesto,empresa);
            MenuPrincipal.ClientesMuestra.add(cliente);
            
            
             
            
        }
        
        conexion.close();
        resultado.close();
        sentencia.close();
        
   }
   
   public ArrayList<Productos> listaProductos(String consultaSQL) throws ClassNotFoundException, SQLException{
       //Para la conexion de la base de datos en postgresql
        Class.forName("org.postgresql.Driver");

        conexion = DriverManager.getConnection(cadenaConexion, "postgres", contraseña);
        sentencia = conexion.createStatement();
        resultado = sentencia.executeQuery(consultaSQL); 
        ArrayList<Productos> lista = new ArrayList<Productos>();
        
        while (resultado.next()) {
              
            int id = resultado.getInt("id_producto");
            String descripcion = resultado.getString("descripcion");
            
            String temporal[] = resultado.getString("precio").split("");
            String precio = "";
            for(int i = 0;i<temporal.length;i++){
                if( !(temporal[i].equals("$") || temporal[i].equals(","))){
                    precio+=temporal[i];
                }
            }
            
           Productos product = new Productos(id,descripcion,Double.parseDouble(precio));
           lista.add(product);
            
        }
        
        //cerramos conexion con la base de datos
        conexion.close();
        resultado.close();
        sentencia.close();
        
        return lista;
       
   }
   
   public ArrayList<Cliente> listaCliente(String consultaSQL) throws ClassNotFoundException, SQLException{
       //Para la conexion de la base de datos en postgresql
        Class.forName("org.postgresql.Driver");

        conexion = DriverManager.getConnection(cadenaConexion, "postgres", contraseña);
        sentencia = conexion.createStatement();
        resultado = sentencia.executeQuery(consultaSQL); 
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        
        while(resultado.next()){
            
            
            int a = Integer.parseInt(resultado.getString("id_cliente"));     
            String puesto = "",empresa = "",nombre = "";  
            
            if(resultado.getString("apellido").equals("")){
                puesto = "Null";
            }else{
                puesto = resultado.getString("apellido");
            }
            
            if(resultado.getString("empresa").equals("")){
                empresa = "Null";
            }else{
                empresa = resultado.getString("empresa");
            }
            
            if(resultado.getString("nombre").equals("")){
                nombre = "Null";
            }else{
                nombre = resultado.getString("nombre");
            }
            
            Cliente cliente = new Cliente(a,nombre,puesto,empresa);
            lista.add(cliente);

        }
        //cerramos conexion con la base de datos
            
        conexion.close();
        resultado.close();
        sentencia.close();
        return lista;
   }
   
   public boolean cambiosProducto(String consultaSQL) throws ClassNotFoundException, SQLException{
       
        Class.forName("org.postgresql.Driver");

        conexion = DriverManager.getConnection(cadenaConexion, "postgres", contraseña);
        sentencia = conexion.createStatement();
        sentencia.execute(consultaSQL);
        
        conexion.close();
        resultado.close();
        sentencia.close();
        return true;
        
   }
   
}
