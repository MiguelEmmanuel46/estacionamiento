/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import componentes.CustomFont;
import componentes.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author sombra
 */
public class EntradaSalidaAlternative extends javax.swing.JFrame {
Metodos metodos = new Metodos();
int id_tarifaDB =0;

    /**
     * Creates new form CajaAlternative
     */
    public EntradaSalidaAlternative() {
        
       
        initComponents();
        this.setTitle("Entradas/Salidas de estacionamiento          Usuario:"+Metodos.correoEmpleado);
        try{
            setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/multimedia/iconoApp.png")));
        }catch(Exception ex){JOptionPane.showMessageDialog(null,"wdwd"+ex);}
                Map<Integer, String> datos = metodos.getRate();
        datos.forEach((k,v) -> vESListaVehiculo.addItem(v));
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
        int idTarifa = vESListaVehiculo.getSelectedIndex()+1;   
        id_tarifaDB = idTarifa;
        txtTarifa.setText(Double.toString(metodos.getVehicleType(idTarifa)));
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        labelVEReloj.setText(formateador.format(LocalDateTime.now()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
        
        //NO PERMITO QUE PUEDAN CAMBIAR EL TAMAÑO DE LA VENTANA
        //this.setResizable(false);

        //AHORA LA CENTRARÉ EN LA PANTALLA
        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();

        this.setLocation(((pantalla.width - cuadro.width) / 2),   (pantalla.height - cuadro.height) / 2);
        jLabel8.setText("Empleado: "+Metodos.nombreEmpleado);
        
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
        jPanel1 = new javax.swing.JPanel();
        txtPlaca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        vESListaVehiculo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTarifa = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        labelVEReloj = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaMensajes = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPlacaSalida = new javax.swing.JTextField();

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

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/iconoAries.png"))); // NOI18N
        header.add(jLabel11, java.awt.BorderLayout.CENTER);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        dashboard.setBackground(new java.awt.Color(144, 203, 249));
        dashboard.setLayout(new javax.swing.BoxLayout(dashboard, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(144, 203, 249));

        txtPlaca.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jButton1.setText("Registrar entrada");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Placa");

        vESListaVehiculo.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        vESListaVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vESListaVehiculoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TipoVehiculo");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tarifa");

        txtTarifa.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPlaca)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vESListaVehiculo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTarifa, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vESListaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        dashboard.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(144, 203, 249));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 8)); // NOI18N

        labelVEReloj.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        labelVEReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVEReloj.setText("  ");
        labelVEReloj.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addComponent(labelVEReloj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(labelVEReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dashboard.add(jPanel2);

        jPanel4.setBackground(new java.awt.Color(144, 203, 249));

        areaMensajes.setColumns(20);
        areaMensajes.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        areaMensajes.setRows(5);
        jScrollPane1.setViewportView(areaMensajes);

        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jButton2.setText("Registrar Salida");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Placa");

        txtPlacaSalida.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPlacaSalida))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtPlacaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        dashboard.add(jPanel4);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String hora_entrada = labelVEReloj.getText();
        String placa = txtPlaca.getText().toUpperCase();
        int tipoAuto = vESListaVehiculo.getSelectedIndex()+1;
        Double tarifa = Double.parseDouble(txtTarifa.getText());
        String correo = Metodos.correoEmpleado;
        LocalDate todaysDate = LocalDate.now();

        String fechaF = todaysDate.toString();

        //hora_salida
        //tiempo
        //id_tarifa
        //dinero_generado
        //

        int checkEnrollment = 0;
        checkEnrollment = metodos.obtenerId(placa);
        if (checkEnrollment == 0) {
            metodos.saveMovimientos(fechaF,hora_entrada,id_tarifaDB,placa,correo);
            metodos.generarTicket(correo,fechaF,hora_entrada,id_tarifaDB,placa);
            txtPlaca.setText("");
        }else{
            //JOptionPane.showMessageDialog(null,"El dato ya esta registrado en la base de datos y no ha registrado salida");
            JOptionPane.showMessageDialog(null,"El dato ya esta registrado en la base de datos y no ha registrado salida");
            txtPlaca.setText("");
        }

        //metodos.generarTicket(correo,fechaF,hora_entrada,id_tarifaDB,placa);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void vESListaVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vESListaVehiculoActionPerformed
        // TODO add your handling code here:
        int idTarifa = vESListaVehiculo.getSelectedIndex()+1;
        id_tarifaDB = idTarifa;
        txtTarifa.setText(Double.toString(metodos.getVehicleType(idTarifa)));
    }//GEN-LAST:event_vESListaVehiculoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        areaMensajes.setText("");
        String[] mensajes = null;
        String horaF = labelVEReloj.getText();
        String placas = txtPlacaSalida.getText();
        boolean checkisEnrollment;
        checkisEnrollment = metodos.checkEnrollmentIsNull(placas);
        if (checkisEnrollment==true) {
            mensajes = metodos.calculateRateToPay(horaF, placas);
            for (int i = 0; i < mensajes.length; i++) {
                areaMensajes.append(mensajes[i]);
            }
            //metodos.updateMovimientos(fecha,placa,hora_salida,mensajes,dinero_generado);
            System.out.println(mensajes[3]);
        }else{
            JOptionPane.showMessageDialog(null, "La Placa ya ha registrado salida");
        }

        txtPlacaSalida.setText("");
        /*for (int i = 0; i < nvec.size(); i++) {
            System.out.println(nvec.elementAt(i)+"\n");
        }*/

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(EntradaSalidaAlternative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntradaSalidaAlternative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntradaSalidaAlternative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntradaSalidaAlternative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntradaSalidaAlternative().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMensajes;
    private javax.swing.JPanel buttonBack;
    private javax.swing.JPanel buttonClose;
    private javax.swing.JPanel dashboard;
    private javax.swing.JPanel header;
    private javax.swing.JPanel iconMaxClose;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelVEReloj;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPlacaSalida;
    private javax.swing.JTextField txtTarifa;
    private javax.swing.JComboBox vESListaVehiculo;
    // End of variables declaration//GEN-END:variables
}
