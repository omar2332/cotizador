/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class AgregarProductoBaseDatos extends javax.swing.JPanel {

    /**
     * Creates new form AgregarProductoBaseDatos
     */
    public AgregarProductoBaseDatos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        precioLabel = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnAgregarNuevo = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnMenuPrincipal = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(487, 300));
        setMinimumSize(new java.awt.Dimension(487, 300));
        setPreferredSize(new java.awt.Dimension(487, 300));

        jLabel1.setText("Producto Nuevo");

        jLabel2.setText("Descripcion");

        areaDescripcion.setColumns(20);
        areaDescripcion.setRows(5);
        jScrollPane1.setViewportView(areaDescripcion);

        jLabel3.setText("Precio Unitario");

        jLabel4.setText("$");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnAgregarNuevo.setText("Agregar Nuevo");
        btnAgregarNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNuevoActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnMenuPrincipal.setText("Menu Principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(197, 197, 197)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAgregar)
                                    .addGap(22, 22, 22)
                                    .addComponent(btnAgregarNuevo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegresar)
                                    .addGap(10, 10, 10)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)))
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMenuPrincipal)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(precioLabel)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(precioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnAgregarNuevo)
                    .addComponent(btnRegresar)
                    .addComponent(btnMenuPrincipal))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        MenuProductos mp = new MenuProductos();//declaramos el objeto panel MenuProductos
        mp.setLocation(412,0);//posicion del panel ajustado al frame
        mp.setSize(426, 720);//tamaño del panel ajustado al frame
        /* Esto ultimo es para colocar el panel dentro del frame y ajustarlo en el centro*/
        MenuPrincipal.panelPrincipal.removeAll();
        MenuPrincipal.panelPrincipal.add(mp);
        MenuPrincipal.panelPrincipal.setLocation(0,0);
        MenuPrincipal.panelPrincipal.setSize(1250, 720);
        MenuPrincipal.panelPrincipal.revalidate();
        MenuPrincipal.panelPrincipal.repaint();
    }//GEN-LAST:event_btnRegresarActionPerformed
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if(!areaDescripcion.getText().equals("") && !precioLabel.getText().equals("")){
            if(Cotizacion.isNumeric(precioLabel.getText())){
                
                try {
                    if(MenuPrincipal.consultas.cambiosProducto("insert into productos(descripcion,precio) values ('"+ areaDescripcion.getText() +"', " +precioLabel.getText() + ")")){                
                        JOptionPane.showMessageDialog(null, "Se agrego correctamente"); 
                        MenuPrincipal.consultas.CargaDeProducto();
                    }
                   
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AgregarProductoBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Fallo al agregar");
                } catch (SQLException ex) {
                    Logger.getLogger(AgregarProductoBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Fallo al agregar");
                }
                
            }else{
               JOptionPane.showMessageDialog(null, "Por favor escriba en el campo de precios un numero"); 
            }
        }else{
             JOptionPane.showMessageDialog(null, "Llene los campos por favor");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNuevoActionPerformed
        // TODO add your handling code here:
        if(!areaDescripcion.getText().equals("") && !precioLabel.getText().equals("")){
            if(Cotizacion.isNumeric(precioLabel.getText())){
                
                try {
                    if(MenuPrincipal.consultas.cambiosProducto("insert into productos(descripcion,precio) values ('"+ areaDescripcion.getText() +"', " +precioLabel.getText() + ")")){                
                        JOptionPane.showMessageDialog(null, "Se agrego correctamente");
                        areaDescripcion.setText("");
                        precioLabel.setText("");
                        MenuPrincipal.consultas.CargaDeProducto();
                    }
                   
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AgregarProductoBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Fallo al agregar");
                } catch (SQLException ex) {
                    Logger.getLogger(AgregarProductoBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Fallo al agregar");
                }
                
            }else{
               JOptionPane.showMessageDialog(null, "Por favor escriba en el campo de precios un numero"); 
            }
        }else{
             JOptionPane.showMessageDialog(null, "Llene los campos por favor");
        }
    }//GEN-LAST:event_btnAgregarNuevoActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescripcion;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarNuevo;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField precioLabel;
    // End of variables declaration//GEN-END:variables
}
