/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author HP
 */
public class PasoDos extends javax.swing.JPanel{

    /**
     * Creates new form PasoDos
     */
    public int contador = 8;
    public PasoDos() {
        initComponents();
        labelDescuentoText.setText("Descuento: 0%");
    
        
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
        labelVigencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnResta = new javax.swing.JButton();
        btnSuma = new javax.swing.JButton();
        labelDescuentoText = new javax.swing.JLabel();
        sliderDescuento = new javax.swing.JSlider();
        btnRegresar = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(550, 421));
        setMinimumSize(new java.awt.Dimension(550, 421));

        jLabel1.setText("Seleccionar descuento y Vigencia del producto(Si deja en blanco seran 8 dias por defecto)");

        labelVigencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                labelVigenciaKeyTyped(evt);
            }
        });

        jLabel2.setText("Vigencia (Numero de dias)");

        btnResta.setText("-");

        btnSuma.setText("+");

        labelDescuentoText.setText("Descuento");

        sliderDescuento.setMajorTickSpacing(5);
        sliderDescuento.setPaintLabels(true);
        sliderDescuento.setPaintTicks(true);
        sliderDescuento.setValue(0);
        sliderDescuento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderDescuentoStateChanged(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(labelDescuentoText, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(sliderDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(66, 66, 66)
                .addComponent(btnContinuar)
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(btnResta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuma)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(labelDescuentoText)
                .addGap(44, 44, 44)
                .addComponent(sliderDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnContinuar)
                    .addComponent(btnCancelar))
                .addGap(41, 41, 41))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        
        PasoUno mp = new PasoUno(MenuPrincipal.CotizacionActual.cliente.nombre);
        mp.setLocation(393,210);//posicion del panel ajustado al frame
        mp.setSize(463, 300);//tamaño del panel ajustado al frame
        /* Esto ultimo es para colocar el panel dentro del frame y ajustarlo en el centro*/
        MenuPrincipal.panelPrincipal.removeAll();
        MenuPrincipal.panelPrincipal.add(mp);
        MenuPrincipal.panelPrincipal.setLocation(0,0);
        MenuPrincipal.panelPrincipal.setSize(1250, 720);
        MenuPrincipal.panelPrincipal.revalidate();
        MenuPrincipal.panelPrincipal.repaint();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        MenuPrincipal.CotizacionActual.cliente = null;
        
        MenuInicial mi = new MenuInicial();//declaramos el objeto Menuinicial
        mi.setLocation(412,0);//posicion del panel ajustado al frame
        mi.setSize(426, 720);//tamaño del panel ajustado al frame
        /* Esto ultimo es para colocar el panel dentro del frame y ajustarlo en el centro*/
        MenuPrincipal.panelPrincipal.removeAll();
        MenuPrincipal.panelPrincipal.add(mi);
        MenuPrincipal.panelPrincipal.setLocation(0,0);
        MenuPrincipal.panelPrincipal.setSize(1250, 720);
        MenuPrincipal.panelPrincipal.revalidate();
        MenuPrincipal.panelPrincipal.repaint();
    }//GEN-LAST:event_btnCancelarActionPerformed
     private boolean isNumber(char ch){
        return ch >= '0' && ch <= '9';
    }

    private boolean isValidSignal(char ch){
        if( (labelVigencia.getText() == null || "".equals(labelVigencia.getText().trim()) ) && ch == '-'){
            return true;
        }

        return false;
    }

    private boolean validatePoint(char ch){
        if(ch != '.'){
            return false;
        }

        if(labelVigencia.getText() == null || "".equals(labelVigencia.getText().trim())){
            labelVigencia.setText("0.");
            return false;
        }else if("-".equals(labelVigencia.getText())){
            labelVigencia.setText("-0.");
        }

        return true;
    }
    
    private void labelVigenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_labelVigenciaKeyTyped
        // TODO add your handling code here:
        char ch = evt.getKeyChar();

                if (!isNumber(ch) && !isValidSignal(ch) && !validatePoint(ch)  && ch != '\b') {
                    evt.consume();
                }
    }//GEN-LAST:event_labelVigenciaKeyTyped

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void sliderDescuentoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderDescuentoStateChanged
        // TODO add your handling code here:
        labelDescuentoText.setText("Descuento: " + String.valueOf(sliderDescuento.getValue()) + "%");
        
    }//GEN-LAST:event_sliderDescuentoStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnResta;
    private javax.swing.JButton btnSuma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelDescuentoText;
    private javax.swing.JTextField labelVigencia;
    private javax.swing.JSlider sliderDescuento;
    // End of variables declaration//GEN-END:variables

    
}
