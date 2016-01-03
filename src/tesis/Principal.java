package tesis;

import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class Principal extends javax.swing.JFrame {

    JFileChooser jFileChooser1;
    String path;
    Imagen imagen;

    public Principal() {
        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Procesar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblImg1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblImg2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lblImg3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lblImg4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Open = new javax.swing.JMenu();
        Abrir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Procesar.setText("Procesar");
        Procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcesarActionPerformed(evt);
            }
        });

        lblImg1.setBorder(javax.swing.BorderFactory.createTitledBorder("Img Principal"));
        jScrollPane1.setViewportView(lblImg1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("Imagen Inicial", jPanel1);

        lblImg2.setBorder(javax.swing.BorderFactory.createTitledBorder("Img Contraste"));
        jScrollPane2.setViewportView(lblImg2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mejora de Contraste", jPanel2);

        lblImg3.setBorder(javax.swing.BorderFactory.createTitledBorder("Img Binarizada"));
        jScrollPane3.setViewportView(lblImg3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Binarización", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Alineación", jPanel4);

        lblImg4.setBorder(javax.swing.BorderFactory.createTitledBorder("Img Principal"));
        jScrollPane4.setViewportView(lblImg4);

        Open.setText("Archivo");

        Abrir.setText("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        Open.add(Abrir);

        jMenuBar1.add(Open);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 810, Short.MAX_VALUE)
                        .addComponent(Procesar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Procesar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showOpenDialog(null);
        /**
         * llamamos el metodo que permite cargar la ventana
         */
        if (valorRetorno == JFileChooser.APPROVE_OPTION) {// verifica si el usuario abre o guarda el archivo

            File nombreImagen = jFileChooser1.getSelectedFile();//obtenemos el nombre del archivo
            path = nombreImagen.getAbsolutePath();//obtenemos la ruta o camino del archivo
            //String nom=nombreImagen.getName();// obtenemos el nombre                                                                         
            imagen = new Imagen(path);
            System.out.println(path);

            try {
                ImageIcon fot = new ImageIcon(new ImageIcon(path).getImage());// dentro del parentesis va la ruta
                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblImg1.getWidth(), lblImg1.getHeight(), Image.SCALE_DEFAULT));
                lblImg1.setIcon(fot);
            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_AbrirActionPerformed

    private void ProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcesarActionPerformed
        // TODO add your handlin g code here:
        /*
         histo1=new Histograma1(imagen);
         histo1.setVisible(true);*/
        double[][] Mcontraste = Contraste.mejorarContraste(imagen);
        Imagen.ventana1(Mcontraste, lblImg2);
        //imagen.convertirMatrizAImagen(Mcontraste);
        double[][] MBinarizada = Binarizacion.binarizarImagen(Mcontraste, imagen.getFilas(), imagen.getColumnas());
        Imagen.ventana1(MBinarizada, lblImg3);
        imagen.guardarImagen(MBinarizada, "imgNbin004");

        double[][] MAlineada = Alineacion.alinearImagen(MBinarizada, imagen.getFilas(), imagen.getColumnas());
//        Imagen.ventana1(MAlineada, lblImg4);
        
        double [][] MfiltroProm = Filtros.AplicarMaskAMatriz(MAlineada, imagen.getFilas(), imagen.getColumnas());
        Imagen.ventana1(MfiltroProm, lblImg4);
        imagen.guardarImagen(MfiltroProm, "Promedio");

        //Imagen.ventana1(histo1.MejorarContraste(m,M,imagen.getMatrizImg()), Imagen2);
        //imagen.guardarImagen(imagen.matrizImg, "otragris");
        //Imagen.ventana1(Contraste1.mejorarContraste(imagen, linea1,linea2), Imagen2);
        //imagen.guardarImagen(Contraste1.mejorarContraste(imagen), "MIRA1");
    }//GEN-LAST:event_ProcesarActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir;
    private javax.swing.JMenu Open;
    private javax.swing.JButton Procesar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblImg1;
    private javax.swing.JLabel lblImg2;
    private javax.swing.JLabel lblImg3;
    private javax.swing.JLabel lblImg4;
    // End of variables declaration//GEN-END:variables
}
