package vistas;
import componentes.Metodos;
//import componentes.ConexionToReport;
import java.awt.Dimension;
import javax.swing.JOptionPane;
//import Vistas.GuardarDatos2;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
//import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author montielme
 */
public class Panel extends javax.swing.JFrame {
Metodos instanciaMetodos = new Metodos();
public static String ruta="C:\\FTPFilesDownloaded\\";
public static String datoEditar;
public static int p2        ;
public static String usuarioTS="No";//labelUsuario
//Filtrar fil = new Filtrar();
//Rubro rubro = new Rubro();
    /**
     * Creates new form Consulta
     */

    public Panel() {
        initComponents();
      /*  labelUsuario.setText(usuarioTS);
        panelMavs.setBackgroung("Multimedia/fondoD.png");
        panelMavs.setLayout(null);
        panelMavs.setMaximumSize(new Dimension(1200, 530));
        panelMavs.setMinimumSize(new Dimension(1200,530));
        setLayout(null);
        //btnNuevoRegistro.layout();
        instanciaMetodos.crearTabla(jTable2);  
         panelContainerTable.setBackground(new Color(0, 0, 0,0));
         //btnBuscar.setBackground(new Color(155, 0, 0));
         btnBuscar.setForeground(Color.white);
          btnEliminar.setBackground(new java.awt.Color(249,148,32));
          btnEditar.setBackground(new java.awt.Color(249,148,32));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
         //jButton2.setVisible(false);
        campoBusquedaNombre.setToolTipText("Escribe un nombre para buscar los folios que pertenecen a el.");
        jList1.setToolTipText("Al selecionar un folio de esta lista podras buscar o editar.");*/
    }
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(729, 401));
        setMinimumSize(new java.awt.Dimension(729, 401));
        setResizable(false);
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
