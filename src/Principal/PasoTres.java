/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

/**
 *
 * @author HP
 */
public class PasoTres extends javax.swing.JPanel {

    /**
     * Creates new form PasoTres
     */
    public javax.swing.JTextField[] entrada; //campo de datos
    public javax.swing.JLabel[] xs; //marca de las Xis
    public javax.swing.JPanel panel[];
    
    public PasoTres() {
        initComponents();
        
        panelInformacion.setPreferredSize(new Dimension(1000, 10*100));
        panelInformacion.setLayout(new GridLayout(10,1,300,10));
        entrada =  new javax.swing.JTextField[10];
        xs = new javax.swing.JLabel[10];
        panel = new javax.swing.JPanel[10];
        
        for(int i = 0; i<10;i++){
            xs[i] = new javax.swing.JLabel();
            
            
            entrada[i] = new javax.swing.JTextField();
            //xs[i].setPreferredSize(new Dimension(900, 100));
            panel[i] = new javax.swing.JPanel();
            panel[i].setSize(new Dimension(1000, 10));
            String texto =  "JLabel con varias linea";
            
            String separacion[] = texto.split("");
            
            String prueba = "";
            
            for( int j = 0; j<separacion.length; j++){
                
                if(j%6 == 0 && j!=0){
                    prueba += separacion[j] +"-<br>" ;
                }else{
                    prueba+= separacion[j];
                }
                
            }
            
            texto = "<html><body>" + prueba +  "</body></html>";
            
            xs[i].setText(texto);
            entrada[i].setPreferredSize(new Dimension(50, 35));
            
            panel[i].add(xs[i]); //
            panel[i].add(entrada[i]);
            
            panelInformacion.add(panel[i]);
            
            
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

        jScrollBar1 = new javax.swing.JScrollBar();
        scroll = new javax.swing.JScrollPane();
        panelInformacion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout panelInformacionLayout = new javax.swing.GroupLayout(panelInformacion);
        panelInformacion.setLayout(panelInformacionLayout);
        panelInformacionLayout.setHorizontalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 937, Short.MAX_VALUE)
        );
        panelInformacionLayout.setVerticalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
        );

        scroll.setViewportView(panelInformacion);

        jLabel1.setText("Productosas asd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
