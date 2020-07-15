package Principal;
// Julio Sorprendeme
//Que pez.
//khjjkhkhkj

public class Cliente {
    public int id_cliente;
    public String nombre,puesto,empresa,rfc,domicilio,embarcar,contacto,telefono,correo;

    public Cliente(int id_cliente, String nombre, String puesto, String empresa) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.puesto = puesto;
        this.empresa = empresa;
    }

    public Cliente(int id_cliente, String nombre, String puesto, String empresa, String rfc, String domicilio, String embarcar, String contacto, String telefono, String correo) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.puesto = puesto;
        this.empresa = empresa;
        this.rfc = rfc;
        this.domicilio = domicilio;
        this.embarcar = embarcar;
        this.contacto = contacto;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getRfc() {
        return rfc;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getEmbarcar() {
        return embarcar;
    }

    public String getContacto() {
        return contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
    
    

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setEmbarcar(String embarcar) {
        this.embarcar = embarcar;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
    
    
    
    
}
