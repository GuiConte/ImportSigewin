/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportaMarcas;

import ImportadorNTS.Main;
import ImportadorNTS.ManipuladorProperties;
import ImportadorNTS.Produtos;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author LAB
 */
public class MainMarcas extends javax.swing.JFrame {

    ArrayList<Marcas> marcas;
    ArrayList<Produto_Marca> produtos_marcas;

    public MainMarcas() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPathCSV = new javax.swing.JTextField();
        btnPathCSV = new javax.swing.JButton();
        btnLerCSV = new javax.swing.JButton();
        txtPathBD = new javax.swing.JTextField();
        btnPathBD = new javax.swing.JButton();
        btnIniciarImport = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPathCSVProdMarca = new javax.swing.JTextField();
        btnPathCSVProdMarca = new javax.swing.JButton();
        btnLerCSVProdMarca = new javax.swing.JButton();
        btnUpdateProd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Caminho do arquivo CSV:");

        btnPathCSV.setText("...");
        btnPathCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPathCSVActionPerformed(evt);
            }
        });

        btnLerCSV.setText("1º Ler Arquivo CSV");
        btnLerCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLerCSVActionPerformed(evt);
            }
        });

        btnPathBD.setText("...");
        btnPathBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPathBDActionPerformed(evt);
            }
        });

        btnIniciarImport.setText("2º Iniciar Importação");
        btnIniciarImport.setEnabled(false);
        btnIniciarImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarImportActionPerformed(evt);
            }
        });

        jLabel2.setText("Caminho do BD Firebird:");

        jLabel3.setText("Caminho do CSV Produto x Marca:");

        btnPathCSVProdMarca.setText("...");
        btnPathCSVProdMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPathCSVProdMarcaActionPerformed(evt);
            }
        });

        btnLerCSVProdMarca.setText("3º Ler CSV Prod x Marca");
        btnLerCSVProdMarca.setFocusable(false);
        btnLerCSVProdMarca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLerCSVProdMarca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLerCSVProdMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLerCSVProdMarcaActionPerformed(evt);
            }
        });

        btnUpdateProd.setText("4º Update Produtos");
        btnUpdateProd.setEnabled(false);
        btnUpdateProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPathBD)
                                    .addComponent(txtPathCSV))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnPathCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPathBD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPathCSVProdMarca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPathCSVProdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnUpdateProd, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(61, 61, 61)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnLerCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnIniciarImport, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnLerCSVProdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPathCSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPathCSV))
                .addGap(18, 18, 18)
                .addComponent(btnLerCSV)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPathBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPathBD))
                .addGap(18, 18, 18)
                .addComponent(btnIniciarImport)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPathCSVProdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPathCSVProdMarca))
                .addGap(18, 18, 18)
                .addComponent(btnLerCSVProdMarca)
                .addGap(35, 35, 35)
                .addComponent(btnUpdateProd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPathCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPathCSVActionPerformed
        JFileChooser chooserCSV = new JFileChooser("c:\\Workspace");
        int escolha = chooserCSV.showOpenDialog(getParent());
        String pathCSV = chooserCSV.getSelectedFile().getAbsolutePath();
        Properties props;
        txtPathCSV.setText(pathCSV);

        System.out.println("Caminho CSV Salvo\n");
    }//GEN-LAST:event_btnPathCSVActionPerformed

    private void btnLerCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLerCSVActionPerformed
        ManipuladorCSV csv = new ManipuladorCSV();
        try {
            marcas = csv.lerCSV(txtPathCSV.getText());
            btnIniciarImport.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(MainMarcas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLerCSVActionPerformed

    private void btnPathBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPathBDActionPerformed
        JFileChooser chooserBD = new JFileChooser("c:\\Workspace");
        int escolha = chooserBD.showOpenDialog(getParent());
        String pathBD = chooserBD.getSelectedFile().getAbsolutePath();

        Conexao.pathBD = pathBD;
        txtPathBD.setText(pathBD);

        System.out.println("Caminho BD Salvo\n");
    }//GEN-LAST:event_btnPathBDActionPerformed

    private void btnIniciarImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarImportActionPerformed

        // try {
        ManipuladorFirebird fb = new ManipuladorFirebird();
        new Thread() {
            @Override
            public void run() {
                try {
                    fb.desativarId();
                    fb.cadastrarMarca(marcas);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    System.out.println(ex.getErrorCode());
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }.start();
        System.out.println("Importação Concluida\n");
    }//GEN-LAST:event_btnIniciarImportActionPerformed

    private void btnPathCSVProdMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPathCSVProdMarcaActionPerformed
        JFileChooser chooserCSV = new JFileChooser("c:\\Workspace");
        int escolha = chooserCSV.showOpenDialog(getParent());
        String pathCSV = chooserCSV.getSelectedFile().getAbsolutePath();
        Properties props;
        txtPathCSVProdMarca.setText(pathCSV);

        System.out.println("Caminho CSV Salvo\n");
    }//GEN-LAST:event_btnPathCSVProdMarcaActionPerformed

    private void btnLerCSVProdMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLerCSVProdMarcaActionPerformed
        ManipuladorCSV csv = new ManipuladorCSV();
        try {
            produtos_marcas = csv.lerCSVProdMarca(txtPathCSVProdMarca.getText());
            btnUpdateProd.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(MainMarcas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLerCSVProdMarcaActionPerformed

    private void btnUpdateProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProdActionPerformed
        ManipuladorFirebird fb = new ManipuladorFirebird();
        new Thread() {
            @Override
            public void run() {
                try {
                    fb.atualizarProduto(produtos_marcas);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    System.out.println(ex.getErrorCode());
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }.start();
        System.out.println("Importação Concluida\n");
    }//GEN-LAST:event_btnUpdateProdActionPerformed

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
            java.util.logging.Logger.getLogger(MainMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMarcas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarImport;
    private javax.swing.JButton btnLerCSV;
    private javax.swing.JButton btnLerCSVProdMarca;
    private javax.swing.JButton btnPathBD;
    private javax.swing.JButton btnPathCSV;
    private javax.swing.JButton btnPathCSVProdMarca;
    private javax.swing.JButton btnUpdateProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JTextField txtPathBD;
    private static javax.swing.JTextField txtPathCSV;
    private static javax.swing.JTextField txtPathCSVProdMarca;
    // End of variables declaration//GEN-END:variables
}