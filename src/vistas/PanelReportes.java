/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import componentes.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author sombra
 */
public class PanelReportes extends javax.swing.JFrame {
Metodos metodos = new Metodos();
    /**
     * Creates new form CajaAlternative
     */
    public PanelReportes() {
       
        initComponents();
        this.setTitle("Panel reportes          Usuario:"+Metodos.correoEmpleado);
        try{
            setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/multimedia/iconoApp.png")));
        }catch(Exception ex){JOptionPane.showMessageDialog(null,"wdwd"+ex);}
            //NO PERMITO QUE PUEDAN CAMBIAR EL TAMAÑO DE LA VENTANA
        this.setResizable(true);

        //AHORA LA CENTRARÉ EN LA PANTALLA
        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();

               this.setLocation(((pantalla.width - cuadro.width) / 2),
                (pantalla.height - cuadro.height) / 50);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        iconMaxClose = new javax.swing.JPanel();
        buttonClose = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonBack = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dashboard = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        header.setBackground(new java.awt.Color(15, 19, 52));
        header.setPreferredSize(new java.awt.Dimension(666, 50));
        header.setLayout(new java.awt.BorderLayout());

        iconMaxClose.setBackground(new java.awt.Color(5, 10, 46));
        iconMaxClose.setPreferredSize(new java.awt.Dimension(150, 50));
        iconMaxClose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonClose.setBackground(new java.awt.Color(5, 10, 46));
        buttonClose.setPreferredSize(new java.awt.Dimension(50, 50));
        buttonClose.setLayout(new java.awt.BorderLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        buttonClose.add(jLabel1, java.awt.BorderLayout.CENTER);

        iconMaxClose.add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 50, 50));

        buttonBack.setBackground(new java.awt.Color(5, 10, 46));
        buttonBack.setPreferredSize(new java.awt.Dimension(50, 50));
        buttonBack.setLayout(new java.awt.BorderLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/back_32px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        buttonBack.add(jLabel2, java.awt.BorderLayout.CENTER);

        iconMaxClose.add(buttonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 50));

        jPanel3.setBackground(new java.awt.Color(5, 10, 46));
        jPanel3.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jLabel3, java.awt.BorderLayout.CENTER);

        iconMaxClose.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        header.add(iconMaxClose, java.awt.BorderLayout.LINE_END);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/iconoAries.png"))); // NOI18N
        header.add(jLabel11, java.awt.BorderLayout.CENTER);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        dashboard.setBackground(new java.awt.Color(144, 203, 249));

        jButton1.setText("Reporte entradas/salidas estacionamiento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reporte usuarios con plan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Reporte entradas/salidas usuarios con plan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(357, Short.MAX_VALUE))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(342, Short.MAX_VALUE))
        );

        getContentPane().add(dashboard, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
/********************************************************************************************************************************************************/
   public void changecolor(JPanel hover, Color rand){
        hover.setBackground(rand);
    }
   
    public void clickmenu(JPanel h1, JPanel h2, int numberbool) {
        if (numberbool == 1) {
            h1.setBackground(new Color(25, 29, 74));
            h2.setBackground(new Color(5, 10, 46));
        } else {
            h1.setBackground(new Color(5, 10, 46));
            h2.setBackground(new Color(25, 29, 74));
        }
    }

    
   
   /**************************************************************************************************************************************************/
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
//        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        changecolor(buttonClose,new Color(255,0,0));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        changecolor(buttonClose,new Color(5,10,46));
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        changecolor(buttonBack,new Color(251,153,255));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        changecolor(buttonBack,new Color(5,10,46));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.dispose();
        Panel o = new Panel();
        o.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ReporteUsuariosConPlan rp = new ReporteUsuariosConPlan();
        rp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ReportesEntradasSalidasDiarias rp = new ReportesEntradasSalidasDiarias();
        this.dispose();
        rp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ReporteEntradasSalidasPlan ruesp = new ReporteEntradasSalidasPlan();
        this.dispose();
        ruesp.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(PanelReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonBack;
    private javax.swing.JPanel buttonClose;
    private javax.swing.JPanel dashboard;
    private javax.swing.JPanel header;
    private javax.swing.JPanel iconMaxClose;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
