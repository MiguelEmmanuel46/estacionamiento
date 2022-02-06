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
public class Panel extends javax.swing.JFrame {
Metodos metodos = new Metodos();

    /**
     * Creates new form Caja
     */
    public Panel() {
       
        initComponents();
            //NO PERMITO QUE PUEDAN CAMBIAR EL TAMAÑO DE LA VENTANA
        this.setResizable(false);

        //AHORA LA CENTRARÉ EN LA PANTALLA
        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();

        this.setLocation(((pantalla.width - cuadro.width) / 2),
                (pantalla.height - cuadro.height) / 2);
        
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
        dashboard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete_32px.png"))); // NOI18N
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

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        dashboard.setBackground(new java.awt.Color(73, 128, 242));

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(846, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1156, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        jPanel13.setBackground(new java.awt.Color(73, 128, 242));

        jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel12.setText("pension");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap(212, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(0, 33, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(8, 8, 8))
        );

        jPanel12.add(jPanel13);

        jPanel16.setBackground(new java.awt.Color(73, 128, 242));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Reportes");
        jPanel16.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jPanel12.add(jPanel16);

        jPanel18.setBackground(new java.awt.Color(73, 128, 242));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel7.setText("pension");
        jPanel18.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jPanel12.add(jPanel18);

        jPanel20.setBackground(new java.awt.Color(73, 128, 242));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel10.setText("jLabel10");
        jPanel20.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jPanel12.add(jPanel20);

        jPanel6.add(jPanel12);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jPanel8.setBackground(new java.awt.Color(73, 128, 242));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setText("Entrada/Salida de Vehiculo");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/entrada.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 200, 190));

        jPanel7.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(73, 128, 242));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel13.setText("Caja");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 50, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/caja.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel7.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(73, 128, 242));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel15.setText("Cambiar Contraseña");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/password.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel7.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(73, 128, 242));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel17.setText("Establecer Caja");
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/settingsCaja.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        jPanel11.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel7.add(jPanel11);

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1156, Short.MAX_VALUE)
            .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dashboardLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
            .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dashboardLayout.createSequentialGroup()
                    .addGap(0, 31, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 31, Short.MAX_VALUE)))
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
        System.exit(0);
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

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
       
        EntradaSalidaAlternative p = new EntradaSalidaAlternative();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
        changecolor(jPanel8,new Color(255,255,186));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // TODO add your handling code here:
        changecolor(jPanel8,new Color(73,128,242));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
        changecolor(jPanel9,new Color(255,255,186));
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:
         changecolor(jPanel9,new Color(73,128,242));
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        // TODO add your handling code here:
        changecolor(jPanel10,new Color(255,255,186));
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        // TODO add your handling code here:
        changecolor(jPanel10,new Color(73,128,242));
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        this.dispose();
        Caja caja = new Caja();
        caja.setVisible(true);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        if (Metodos.tipoEmpleado.equals("Administrador")) {
            this.dispose();
            ChangePassword changeP = new ChangePassword();
            changeP.setVisible(true);
        }else{
        JOptionPane.showMessageDialog(null,"No eres administrador");
        }
        
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        changecolor(jPanel11,new Color(255,255,186));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
        changecolor(jPanel11,new Color(73,128,242));
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        ConfiguracionCaja ccja = new ConfiguracionCaja();
        this.dispose();
        ccja.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

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
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonBack;
    private javax.swing.JPanel buttonClose;
    private javax.swing.JPanel dashboard;
    private javax.swing.JPanel header;
    private javax.swing.JPanel iconMaxClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
