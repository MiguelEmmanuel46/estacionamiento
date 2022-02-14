/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import componentes.Funciones;
import componentes.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author sombra
 */
public class ConfiguracionCaja extends javax.swing.JFrame {
Metodos metodos = new Metodos();
Funciones f = new Funciones();
    /**
     * Creates new form CajaAlternative
     */
    public ConfiguracionCaja() {
       
        initComponents();
       this.setTitle("Iniciar caja, y corte          Usuario:"+Metodos.nombreEmpleado);
        try{
            setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/multimedia/iconoApp.png")));
        }catch(Exception ex){JOptionPane.showMessageDialog(null,"wdwd"+ex);}
            //NO PERMITO QUE PUEDAN CAMBIAR EL TAMAÑO DE LA VENTANA
        //this.setResizable(false);

        //AHORA LA CENTRARÉ EN LA PANTALLA
        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();

        this.setLocation(((pantalla.width - cuadro.width) / 2),  (pantalla.height - cuadro.height) / 50);
        txtMontoInicial.setEditable(false);
        jButton1.setEnabled(false);
        
        double tempCaja = metodos.selectDataCaja(metodos.getDateT());
        
        if (tempCaja == 0.0) {
            txtMontoInicial.setEditable(true);
            jButton1.setEnabled(true);
        }else{
        txtMontoInicial.setEditable(false);
        jButton1.setEnabled(false);
        }
        labelCajaEstablecida.setText("Monto iniciado en: $"+Double.toString(metodos.selectDataCaja(metodos.getDateT())));
        labelCajaEstablecidaFecha.setText(metodos.getDateT());
        try{
        Funciones f = new Funciones();
        String fechaSistema=metodos.getDateT();
        java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(fechaSistema);
        jDateChooser1.setDate(date2);
        }catch (ParseException ex) {
            Logger.getLogger(ConfiguracionCaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnReporte.setEnabled(false);
        
        //jPanel1.add(datePicker);
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
        jLabel4 = new javax.swing.JLabel();
        txtMontoInicial = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        buttonCorte = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        labelCajaEstablecidaFecha = new javax.swing.JLabel();
        labelCajaEstablecida = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Defina el monto inicial de la caja");

        txtMontoInicial.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonCorte.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        buttonCorte.setText("Corte");
        buttonCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCorteActionPerformed(evt);
            }
        });

        txtInfo.setColumns(20);
        txtInfo.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        txtInfo.setRows(5);
        jScrollPane1.setViewportView(txtInfo);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jLabel5.setText("Cierra caja");

        labelCajaEstablecidaFecha.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        labelCajaEstablecidaFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        labelCajaEstablecida.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        labelCajaEstablecida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jDateChooser1.setFocusable(false);
        jDateChooser1.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N

        btnReporte.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(dashboardLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCajaEstablecidaFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCajaEstablecida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMontoInicial, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addComponent(buttonCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(txtMontoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelCajaEstablecida, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCajaEstablecidaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(19, 19, 19)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCorte)
                    .addComponent(btnReporte))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String fecha = metodos.getDateT();
        String hora = metodos.getHourT();
        Double monto_inicial = Double.parseDouble(txtMontoInicial.getText());        
        metodos.insertCaja(fecha,hora,monto_inicial);
        labelCajaEstablecida.setText("Monto establecido en: $"+Double.toString(metodos.selectDataCaja(metodos.getDateT())));
          txtMontoInicial.setEditable(false);
          jButton1.setEnabled(false);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonCorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCorteActionPerformed
    /*try {*/
        // TODO add your handling code here:
        txtInfo.setText("");
        
        String date3 = f.getFecha(jDateChooser1);
        Double ingresos,egresos,caja,res1,res2,res3;
        ingresos = metodos.getIngresosCaja(date3);
        egresos = metodos.getEgresosCaja(date3);
        caja = metodos.selectDataCaja(date3);
        res1 = caja-egresos;
        res2 = caja+ingresos;
        res3 = caja+ingresos-egresos;
        txtInfo.append("Caja: $"+caja+"\n"+"Ingresos: $"+ingresos+"\nEgresos: $"+egresos+"\nTotal = $"+res3);
        btnReporte.setEnabled(true);
        
    /*} catch (ParseException ex) {
        Logger.getLogger(ConfiguracionCaja.class.getName()).log(Level.SEVERE, null, ex);
    }
       */
        
        
    }//GEN-LAST:event_buttonCorteActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        
         String date3 = f.getFecha(jDateChooser1);
        metodos.reporteCaja(date3);
        
    }//GEN-LAST:event_btnReporteActionPerformed

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
            java.util.logging.Logger.getLogger(ConfiguracionCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ConfiguracionCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JPanel buttonBack;
    private javax.swing.JPanel buttonClose;
    private javax.swing.JButton buttonCorte;
    private javax.swing.JPanel dashboard;
    private javax.swing.JPanel header;
    private javax.swing.JPanel iconMaxClose;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCajaEstablecida;
    private javax.swing.JLabel labelCajaEstablecidaFecha;
    private javax.swing.JTextArea txtInfo;
    private javax.swing.JTextField txtMontoInicial;
    // End of variables declaration//GEN-END:variables
}
