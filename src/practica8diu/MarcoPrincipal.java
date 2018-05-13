package practica8diu;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MarcoPrincipal extends javax.swing.JFrame {
    private final JFileChooser fileChooser;
    private final JFileChooser fileSaver;
    private Comprimir comprimir;
    public MarcoPrincipal() {
        initComponents();
        this.comprimir = null;
        botonCancelar.setEnabled(false);
        fileChooser = new JFileChooser();
        fileSaver = new JFileChooser();
        
        barraDeProgreso.setValue(0);
        barraDeProgreso.setStringPainted(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rutaOrigen = new javax.swing.JTextField();
        rutaDestino = new javax.swing.JTextField();
        botonOrigen = new javax.swing.JButton();
        botonDestino = new javax.swing.JButton();
        botonComprimir = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        barraDeProgreso = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonOrigen.setText("Origen");
        botonOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOrigenActionPerformed(evt);
            }
        });

        botonDestino.setText("Destino");
        botonDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDestinoActionPerformed(evt);
            }
        });

        botonComprimir.setText("Comprimir");
        botonComprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComprimirActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Edilma Alvarado Espinoza & Levi Malest Villarreal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(botonComprimir)
                        .addGap(65, 65, 65)
                        .addComponent(botonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(barraDeProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rutaOrigen)
                    .addComponent(rutaDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonOrigen)
                    .addComponent(botonDestino))
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonOrigen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonDestino))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonComprimir)
                    .addComponent(botonCancelar))
                .addGap(35, 35, 35)
                .addComponent(barraDeProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean rutaCorrecta(String type) {
        
        switch(type) {
            case "origen":
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    
                    if(fileChooser.getSelectedFile().toString().equals(rutaDestino.getText())) {
                        JOptionPane.showMessageDialog(
                                rootPane,
                                "Elija un oigen diferente"
                        );
                    }
                    
                    return true;
                }
                break;
            case "destino":
                fileSaver.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                
                if(fileSaver.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    
                    if(fileSaver.getSelectedFile().toString().equals(rutaOrigen.getText())){
                        JOptionPane.showMessageDialog(
                                rootPane,
                                "Elija una ruta diferente para guardar"
                        );
                    }
                    
                    return true;
                }
                
                break;
        }
        
        return false;
    }
    
    
    private void botonOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOrigenActionPerformed
        
        if(rutaCorrecta("origen")) rutaOrigen.setText(fileChooser.getSelectedFile().toString());
        
    }//GEN-LAST:event_botonOrigenActionPerformed

    private void botonDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDestinoActionPerformed
                
        if(rutaCorrecta("destino")) rutaDestino.setText(fileSaver.getSelectedFile().toString());
        
    }//GEN-LAST:event_botonDestinoActionPerformed

    private boolean existeFichero() {
        File existeFichero = new File(this.rutaDestino.getText() + "\\" + fileChooser.getSelectedFile().getName() + ".zip");
        
        return existeFichero.exists();
    }
    
    private void botonComprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComprimirActionPerformed
        // TODO add your handling code here:
        if (this.rutaOrigen.getText().isEmpty() || this.rutaDestino.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    rootPane,
                    "Proporcione directorios válidos",
                    "Error al comprimir",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            
            if(existeFichero()) {
                int choise = JOptionPane.showConfirmDialog(
                        rootPane,
                        "Ya existe un archivo con ese nombre. \n ¿Deseas sobreescribirlo?",
                        "Archivo existente",
                        JOptionPane.YES_NO_OPTION
                );
                if (choise == JOptionPane.YES_OPTION) executeCompression(fileChooser.getSelectedFile().getName());
            }
            else {
                executeCompression(fileChooser.getSelectedFile().getName());
                botonCancelar.setEnabled(true);
            }
                     
        }
    }//GEN-LAST:event_botonComprimirActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        comprimir.cancel(true);
        barraDeProgreso.setValue(0);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void executeCompression(String nameFile) {
        comprimir = new Comprimir(barraDeProgreso,
                    botonOrigen,
                    botonDestino,
                    botonComprimir,
                    botonCancelar,
                    nameFile,
                    rutaOrigen.getText(),
                    rutaDestino.getText()
        );
        comprimir.execute();
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MarcoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarcoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarcoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarcoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarcoPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraDeProgreso;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonComprimir;
    private javax.swing.JButton botonDestino;
    private javax.swing.JButton botonOrigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField rutaDestino;
    private javax.swing.JTextField rutaOrigen;
    // End of variables declaration//GEN-END:variables
}
