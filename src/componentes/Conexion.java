/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author soporte
 */
public class Conexion {
    public static Connection con = null;
    
    public static Connection conectar() {
        
        try {
            String url = "jdbc:mysql://DESKTOP-7QRQQ01:3306/estacionamiento?user=userE&password=afb1f1ac34f!W";
            con = (Connection) DriverManager.getConnection(url);
            if (con != null) {
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexion con el servidor falló" + e.getMessage());
        }
        return con;
    }
    
    public static void cierraConexion() {
        try {
            con.close();
            
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al cerrar conexion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
