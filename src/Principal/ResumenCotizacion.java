/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.sql.SQLException;

import java.text.DecimalFormat;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HP
 */
public class ResumenCotizacion extends javax.swing.JPanel {

    /**
     * Creates new form ResumenCotizacion
     */
    public int n = MenuPrincipal.CotizacionActual.listaProducto.size();
    
    public n2t numeroletras = new n2t();
    
    
    public ResumenCotizacion() {
        initComponents();
        
        
        DecimalFormat df = new DecimalFormat("###,###.00");
        
        MenuPrincipal.CotizacionActual.setFechaActual();
        labelFecha.setText("Fecha: " + MenuPrincipal.CotizacionActual.fecha);
        labelCotizacion.setText("Cotizacion: SISA -" +String.valueOf(MenuPrincipal.CotizacionActual.id_coti));
        labelVigencia.setText("Vigencia " + String.valueOf( MenuPrincipal.CotizacionActual.vigencia) + " dias");
        
        if(MenuPrincipal.CotizacionActual.cliente.empresa.isEmpty()){
            labelEmpresa.setText("Empresa: Desconocida");
        }else{
            labelEmpresa.setText("Empresa: " + MenuPrincipal.CotizacionActual.cliente.empresa);
        }
        
        if(MenuPrincipal.CotizacionActual.cliente.nombre.isEmpty()){
            labelNombre.setText("Nombre: Desconocido");
        }else{
            labelNombre.setText("Nombre: "+MenuPrincipal.CotizacionActual.cliente.nombre);
        }
        
        if(MenuPrincipal.CotizacionActual.cliente.puesto.isEmpty()){
            labelPuesto.setText("Puesto: Desconocido");
        }else{
            labelPuesto.setText("Puesto: "+MenuPrincipal.CotizacionActual.cliente.puesto);
        }
        
        
        
        String arreglotabla[][] = new String[n][5];//arreglo donde se guarda informacion mostrada en la tabla principal
        
        for(int i=0; i<n;i++){
            
            arreglotabla[i][0] = String.valueOf(MenuPrincipal.CotizacionActual.listaProducto.get(i).id_productos);
            arreglotabla[i][1] = String.valueOf(MenuPrincipal.CotizacionActual.listaProducto.get(i).cantidad);
            arreglotabla[i][2] = MenuPrincipal.CotizacionActual.listaProducto.get(i).descripcion;
            
            String precio = df.format(MenuPrincipal.CotizacionActual.listaProducto.get(i).precio);
            arreglotabla[i][3] = String.valueOf(precio);
            double mult = MenuPrincipal.CotizacionActual.listaProducto.get(i).precio*MenuPrincipal.CotizacionActual.listaProducto.get(i).cantidad;
            String precio_cantidad= df.format(mult);
            arreglotabla[i][4] = String.valueOf(precio_cantidad);
        }
        
        TablaInventario.setModel(new javax.swing.table.DefaultTableModel(
                arreglotabla,
                new String[]{
                    "ID", "Cantidad", "Descripcion", "Precio Unitario", "Precio Total"
                }
        ));

        //damos formato a las columnas
        TablaInventario.getColumnModel().getColumn(0).setPreferredWidth(50);
        TablaInventario.getColumnModel().getColumn(1).setPreferredWidth(50);
        TablaInventario.getColumnModel().getColumn(2).setPreferredWidth(300);
        TablaInventario.getColumnModel().getColumn(3).setPreferredWidth(100);
        TablaInventario.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        MenuPrincipal.CotizacionActual.subtotal = calcularSubTotal();
        double subtotal = MenuPrincipal.CotizacionActual.subtotal;
        MenuPrincipal.CotizacionActual.iva = calcularIVA();
        MenuPrincipal.CotizacionActual.descuento = calcularDescuento();
        MenuPrincipal.CotizacionActual.total = calcularTotal(MenuPrincipal.CotizacionActual.descuento,MenuPrincipal.CotizacionActual.iva);
        double total = MenuPrincipal.CotizacionActual.total;
        
        
        
        

        
        labelSubtotal.setText("Subtotal: " + df.format(subtotal));
        labelTotal.setText("Total: "+ df.format(total));
        labelIVA.setText("IVA: " + df.format(MenuPrincipal.CotizacionActual.iva));
        labelDescuento.setText("Descuento: " + df.format(MenuPrincipal.CotizacionActual.descuento));
        btnEditar.setVisible(false);
        
        if(MenuPrincipal.CotizacionActual.guardado){
            btnPDF.setText("PDF");
            btnRegresar.setVisible(false);
            btnCancelar.setText("Menu Principal");
            btnGuardar.setVisible(false);
            btnEditar.setVisible(true);
        }
        
        
        
    }
    
    
    public double calcularSubTotal(){
        double subtotal = 0.0;
        
        
        for(int i=0;i<n; i++){
            int cantidad = MenuPrincipal.CotizacionActual.listaProducto.get(i).cantidad;
            double precio = MenuPrincipal.CotizacionActual.listaProducto.get(i).precio;
            subtotal+=cantidad*precio;
        } 
        
        return subtotal;
        
    }
    
    public double calcularIVA(){
        double iva = 0.0;
        
        iva+=MenuPrincipal.CotizacionActual.iva*MenuPrincipal.CotizacionActual.subtotal;         
        
        return iva;
    }
    
    public double calcularDescuento(){
        double descuento = 0.0;
        
        descuento += MenuPrincipal.CotizacionActual.descuento*MenuPrincipal.CotizacionActual.subtotal;         
        
        return descuento;
    }
    
    public double calcularTotal(double descuento,double iva){
        double total = 0.0;
        
        total+=  iva +MenuPrincipal.CotizacionActual.subtotal-descuento;         
        
        return total;
    }
    
    
    public void guardar(){
        
        DecimalFormat df2 = new DecimalFormat("###.00");
        String id_cotizacion = String.valueOf(MenuPrincipal.CotizacionActual.id_coti);
        String id_cliente= String.valueOf(MenuPrincipal.CotizacionActual.cliente.id_cliente);
        String fecha = MenuPrincipal.CotizacionActual.fecha;
        String descuento = String.valueOf(MenuPrincipal.CotizacionActual.descuento);
        String total= String.valueOf(MenuPrincipal.CotizacionActual.total);
        String subtotal = String.valueOf(MenuPrincipal.CotizacionActual.subtotal);
        String iva = String.valueOf(MenuPrincipal.CotizacionActual.iva);
        String vigencia = String.valueOf(MenuPrincipal.CotizacionActual.vigencia);
        String total_string = String.valueOf(df2.format(MenuPrincipal.CotizacionActual.total));
        String[] total_temp = total_string.split("\\.");
       
        
        String totalletras = numeroletras.convertirLetras( Integer.parseInt(total_temp[0]), 
                Integer.parseInt(total_temp[1]));
        
        String sql_insertar = "INSERT INTO cotizacion( id_cliente, fecha_creacion,fecha_modificacion ,descuento, total, subtotal, iva,vigencia,num_letras)"
                + "VALUES ( " + id_cliente+ ", '"+ fecha+"','"+ fecha+"' ,"+descuento+", "+total+", "+subtotal+", "+iva +","+vigencia+", '"+totalletras +"');";
        
        boolean var = true;
        try {
            var = MenuPrincipal.consultas.cambiosProducto(sql_insertar);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ResumenCotizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(var){
            
            for(int i = 0; i<n;i++){
                
                String id_producto = String.valueOf(MenuPrincipal.CotizacionActual.listaProducto.get(i).id_productos);
                String cantidad = String.valueOf(MenuPrincipal.CotizacionActual.listaProducto.get(i).cantidad);
                double mult = MenuPrincipal.CotizacionActual.listaProducto.get(i).precio*MenuPrincipal.CotizacionActual.listaProducto.get(i).cantidad;
                String precio_cantidad= String.valueOf(mult);
                
                sql_insertar = "INSERT INTO cot_productos(id_cotizacion, id_producto, cantidad, cantidadxproducto)"
                        + "	VALUES ("+id_cotizacion+", "+id_producto+", "+cantidad+", "+precio_cantidad+");";
                
                try {
                        var = MenuPrincipal.consultas.cambiosProducto(sql_insertar);
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(ResumenCotizacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
            }
            
            MenuPrincipal.CotizacionActual.guardado();
            
        }
        
        
        
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaInventario = new javax.swing.JTable();
        labelSubtotal = new javax.swing.JLabel();
        labelIVA = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        labelDescuento = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelEmpresa = new javax.swing.JLabel();
        labelPuesto = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelVigencia = new javax.swing.JLabel();
        labelCotizacion = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        TablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaInventario);

        labelSubtotal.setText("Subtotal: ");

        labelIVA.setText("IVA:");

        labelTotal.setText("Total");

        labelDescuento.setText("Descuento");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Cliente");

        labelNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNombre.setText("Nombre:");

        labelEmpresa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelEmpresa.setText("Empresa:");

        labelPuesto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPuesto.setText("Puesto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addComponent(labelPuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPuesto)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnPDF.setText("Guardar+PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Preview");

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));

        labelVigencia.setText("Vigencia");

        labelCotizacion.setText("Cotizacion #");

        labelFecha.setText("Fecha: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelVigencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(labelCotizacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelVigencia)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnEditar.setText("Editar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(60, 60, 60)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addGap(43, 43, 43)
                        .addComponent(btnGuardar)
                        .addGap(74, 74, 74)
                        .addComponent(btnPDF))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelIVA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(189, 189, 189)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(27, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(labelSubtotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelIVA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDescuento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelTotal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRegresar)
                    .addComponent(btnGuardar)
                    .addComponent(btnPDF)
                    .addComponent(btnEditar))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        
        MenuPrincipal.CotizacionActual = null;
        MenuInicial mi = new MenuInicial();//declaramos el objeto Menuinicial
        mi.setLocation(142,0);//posicion del panel ajustado al frame
        mi.setSize(965, 720);//tamaño del panel ajustado al frame
         /* Esto ultimo es para colocar el panel dentro del frame y ajustarlo en el centro*/
        MenuPrincipal.panelPrincipal.removeAll();
        MenuPrincipal.panelPrincipal.add(mi);
        MenuPrincipal.panelPrincipal.setLocation(0,0);
        MenuPrincipal.panelPrincipal.setSize(1250, 720);
        MenuPrincipal.panelPrincipal.revalidate();
        MenuPrincipal.panelPrincipal.repaint();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        PasoTres mp = new PasoTres(MenuPrincipal.CotizacionActual.listaProducto);
        //[550, 421]
        mp.setLocation(125,119);//posicion del panel ajustado al frame
        mp.setSize(1000, 511);//tamaño del panel ajustado al frame
        
        /* Esto ultimo es para colocar el panel dentro del frame y ajustarlo en el centro*/
        MenuPrincipal.panelPrincipal.removeAll();
        MenuPrincipal.panelPrincipal.add(mp);
        MenuPrincipal.panelPrincipal.setLocation(0,0);
        MenuPrincipal.panelPrincipal.setSize(1250, 720);
        MenuPrincipal.panelPrincipal.revalidate();
        MenuPrincipal.panelPrincipal.repaint();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardar();
        
        btnPDF.setText("PDF");
        btnRegresar.setVisible(false);
        btnCancelar.setText("Menu Principal");
        JOptionPane.showMessageDialog(this,
        "Se ha guardado correctamente");
        btnGuardar.setEnabled(false);
        
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        
        if(!MenuPrincipal.CotizacionActual.guardado){
            guardar();
            btnGuardar.setEnabled(false);
            btnPDF.setText("PDF");
            btnRegresar.setVisible(false);
            btnCancelar.setText("Menu Principal");
            JOptionPane.showMessageDialog(this,
            "Se ha guardado correctamente");
            btnGuardar.setEnabled(false);
        }
        
        try {
            // TODO add your handling code here:
            
            
            JasperReport reporte = null;
            String path = "src\\PDFS\\cotizacion.jasper";
            
            reporte =  (JasperReport) JRLoader.loadObjectFromFile(path);
            
            Map parametros  = new HashMap();
            parametros.put("filtro", MenuPrincipal.CotizacionActual.id_coti);
            JasperPrint jprint =  JasperFillManager.fillReport(reporte,parametros,MenuPrincipal.consultas.getConexion());
            
            JasperViewer view = new  JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(MenuPrincipal.DISPOSE_ON_CLOSE);
            view.setVisible(true);
            
 
            
           
            
            
        } catch (JRException ex) {
            Logger.getLogger(ResumenCotizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaInventario;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCotizacion;
    private javax.swing.JLabel labelDescuento;
    private javax.swing.JLabel labelEmpresa;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelIVA;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPuesto;
    private javax.swing.JLabel labelSubtotal;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelVigencia;
    // End of variables declaration//GEN-END:variables
}
