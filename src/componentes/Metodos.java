package componentes;

import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.table.DefaultTableModel;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
//import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;

public class Metodos 
{
    //public static  DefaultTableModel modeloF = new DefaultTableModel();
   // FTPClient ftp = new FTPClient();
    Conexion o = new Conexion();
    public int datoSeleccionado;
    DefaultTableModel modelo;
    public static String fileNameToBase;
    public static String consultaFiltrarToExcel;
    public static String[] vect2;
    public static String correoEmpleado="";
    
        public boolean login() throws SQLException {
        boolean matched2 = false;
        String correoBD = null, passwordBD = null;
        char[] arrayC = vistas.Login.passwordU.getPassword();
        String originalPassword = String.valueOf(arrayC);
        String correo = vistas.Login.correoU.getText();
        PreparedStatement stmt2 = null;
        ResultSet rs2 = null;
        boolean matched = false;
        if (arrayC.equals(null) || arrayC.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingresa Password");
        }
        if (correo.equals(null) || correo.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingresa Correo");
        }
        stmt2 = Conexion.conectar().prepareStatement("SELECT correo,password "
                + "FROM usuarios WHERE correo='" + correo + "' ");

        try {
            rs2 = stmt2.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errorseleccionar correo passwords:" + ex);
        }
        try {
            while (rs2.next()) {
                correoBD = rs2.getString("correo");
                passwordBD = rs2.getString("password");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }

        try {
            matched = Password.validatePassword(originalPassword, passwordBD);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        } catch (InvalidKeySpecException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        //Panel.usuarioTS=correoBD;
        //Vistas.Consulta.usuarioTS = correoBD;
        matched2 = matched;
        Conexion.cierraConexion();
        return matched2;
    } 

    public void registro() {
        String correoBD = null, passwordBD = null, passRoot = null, nombre = vistas.Register.campoNombre.getText(), apellidop = vistas.Register.campoApellidoP.getText(), apellidom = vistas.Register.campoApellidoM.getText(), area = (String) vistas.Register.campoArea.getSelectedItem();
        char[] arrayC = vistas.Register.passwordR.getPassword();
        //char[] arr = { 'p', 'q', 'r', 's' };
        String originalPassword = String.valueOf(arrayC);
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        String correo = vistas.Register.correoR.getText();
        Matcher mather = pattern.matcher(correo);
        String generatedSecuredPasswordHash = null;
        ResultSet rs1 = null;
        ResultSet rs3 = null;
        Vector<String> v = new Vector<String>();
        boolean usuarioExistente = false;
        char[] passURoot = vistas.Register.passwordRRoot.getPassword();
        //char[] arr = { 'p', 'q', 'r', 's' };
        String originalPasswordRoot = String.valueOf(passURoot);
        boolean matched = false;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        try {
            PreparedStatement smt3 = Conexion.conectar().prepareStatement("SELECT pass from super_user");
            rs3 = smt3.executeQuery();
            while (rs3.next()) {
                passRoot = rs3.getString("pass");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        try {
            matched = Password.validatePassword(originalPasswordRoot, passRoot);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        } catch (InvalidKeySpecException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }

        if (mather.find() == true) {
            if (matched == true) {
                try {
                    generatedSecuredPasswordHash = Password.generateStorngPasswordHash(originalPassword);
                } catch (NoSuchAlgorithmException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex);
                } catch (InvalidKeySpecException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex);
                }

                try {
                    PreparedStatement smt1 = Conexion.conectar().prepareStatement("SELECT correo from usuarios");
                    rs1 = smt1.executeQuery();
                    while (rs1.next()) {
                        v.add(rs1.getString("correo"));

                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error:" + e);
                }

                for (int i = 0; i < v.size(); i++) {
                    if (v.elementAt(i).equals(correo)) {
                        usuarioExistente = true;
                    } else {
                        usuarioExistente = false;
                    }
                }

                try {
                    matched = Password.validatePassword(originalPasswordRoot, passRoot);
                } catch (NoSuchAlgorithmException ex) {
                    JOptionPane.showMessageDialog(null, "Error:" + ex);
                } catch (InvalidKeySpecException ex) {
                    JOptionPane.showMessageDialog(null, "Error:" + ex);
                }

                if (usuarioExistente == false) {
                    try {

                        PreparedStatement stmt = Conexion.conectar().prepareStatement("insert into usuarios values('" + correo + "','" + nombre + "','" + apellidop + "','" + apellidom + "','" + generatedSecuredPasswordHash + "','" + area + "',NOW(),NOW())");
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Correo: " + correo + " registrado correctamente en la base de datos");

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error:" + ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario registrado previamente");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password root equivocada");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error formato de correo invalido");
        }
        Conexion.cierraConexion();
    }
    
    public void changePassword(String correouser, char[] passUser, char[] PassAdmin) {
        String str = correouser;
        String correouser2 = str.trim();
        String originalPasswordAdmin = String.valueOf(PassAdmin);
        String originalPasswordUser = String.valueOf(passUser);
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correouser2);
        String generatedSecuredPasswordHash = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        String correoDB = "";
        boolean matched = false;
        boolean usuarioExistente = false;
        String passRoot="";
        
        try {
            PreparedStatement smt1 = Conexion.conectar().prepareStatement("SELECT pass from super_user");
            rs1 = smt1.executeQuery();
            while (rs1.next()) {
                passRoot = rs1.getString("pass");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        try {
            matched = Password.validatePassword(originalPasswordAdmin, passRoot);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        } catch (InvalidKeySpecException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        if (mather.find() == true) {
            if (matched == true) {
                try {
                    generatedSecuredPasswordHash = Password.generateStorngPasswordHash(originalPasswordUser);
                } catch (NoSuchAlgorithmException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex);
                } catch (InvalidKeySpecException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex);
                }

                try {
                    PreparedStatement smt22 = Conexion.conectar().prepareStatement("SELECT correo from usuarios WHERE correo='" + correouser2 + "'");
                    rs2 = smt22.executeQuery();
                    while (rs2.next()) {
                        correoDB = rs2.getString("correo");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error:" + e);
                }

                if (correoDB.equals(correouser2)) {
                    usuarioExistente = true;
                    System.out.println("Correo matched CorreoDB=" + correoDB + " " + " CorreoUSer=" + correouser2);
                } else {
                    usuarioExistente = false;
                    System.out.println("Cooreo no matched CorreoDB=" + correoDB + " " + " CorreoUSer=" + correouser2);
                    JOptionPane.showMessageDialog(null, "Correo no registrado");
                }

                if (usuarioExistente == true) {
                    try {
                        PreparedStatement smt33 = Conexion.conectar().prepareStatement("UPDATE usuarios set password='" + generatedSecuredPasswordHash + "' WHERE correo='" + correouser2 + "'");

                        if (smt33.executeUpdate() == 1) {
                            JOptionPane.showMessageDialog(null, "Password actualizada con exito!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar el password!.");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error:" + e);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password root incorrecta");
            }
        }
        Conexion.cierraConexion();
    }

    public Map<Integer, String> getRate(){
        PreparedStatement stmnt = null;
         ResultSet rs = null;
         
         Map<Integer, String> rateArray = new HashMap<Integer, String>();
         try{
         stmnt = Conexion.conectar().prepareStatement("SELECT id_tarifa,tipo_vehiculo from tarifas WHERE tipo_tarifa='Hora' ORDER BY id_tarifa");
          rs = stmnt.executeQuery();
         }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error:"+ex);
        }
         try{
             while (rs.next())
            {
                rateArray.put(rs.getInt("id_tarifa"), rs.getString("tipo_vehiculo"));
                
            }
         }catch(SQLException ex){
         }
         Conexion.cierraConexion();
         return rateArray;
         
    }
    
    public int obtenerId(String placas){
    int id_mov =0;
        PreparedStatement stmnt = null;
        ResultSet rs = null;
        try {
            stmnt = Conexion.conectar().prepareStatement("SELECT id_movimiento from movimientos WHERE placas='"+placas+"' AND hora_salida IS NULL");
            rs = stmnt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        try {
            while (rs.next()) {
                id_mov = rs.getInt("id_movimiento");

            }
        } catch (SQLException ex) {
        }
        Conexion.cierraConexion();
        
    
    return id_mov;
    }
    
    
    public String obtenerHoraEntrada(int id_movimiento) {
        String hora_entrada="";
        PreparedStatement stmnt = null;
        ResultSet rs = null;
        try {
            stmnt = Conexion.conectar().prepareStatement("SELECT CONCAT(fecha,' ',hora_entrada) as fecha from movimientos WHERE id_movimiento=" + id_movimiento);
            rs = stmnt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        try {
            while (rs.next()) {
                hora_entrada = rs.getString("fecha");

            }
        } catch (SQLException ex) {
        }
        Conexion.cierraConexion();

        return hora_entrada;
    }
    
    public double getVehicleType(int idTarifa){
        PreparedStatement stmnt = null;
        ResultSet rs = null;

        double tarifa = 0;
        try {
            stmnt = Conexion.conectar().prepareStatement("SELECT tarifa from tarifas WHERE id_tarifa="+idTarifa+" ORDER BY id_tarifa");
            rs = stmnt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        try {
            while (rs.next()) {
                tarifa= rs.getDouble("tarifa");

            }
        } catch (SQLException ex) {
        }
        Conexion.cierraConexion();
        return tarifa;

    }

    public void saveMovimientos(String fecha,String hora_entrada, int id_tarifa,String placa,String correo){
        
        try {
            PreparedStatement stmt = Conexion.conectar().prepareStatement("INSERT INTO movimientos(id_movimiento,fecha,hora_entrada,id_tarifa,placas,correo) values(0,'"+fecha+"','"+hora_entrada+"',"+id_tarifa+",'"+placa.trim()+"','"+correo+"')");
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Informacion ingresada a la base de datos correctamente");

        } catch (SQLException ex) {
            //Logger.getLogger(GuardarDatos2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        Conexion.cierraConexion();
    }  
    
    public Vector calculateTime(String entrada,String salida) {
        long between ;
        long day1 = 0 ;
        long hour1 = 0 ;
        long minute1 = 0 ;
        long second1 = 0 ;
            Vector v=new Vector();

        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{java.util.Date begin = dfs.parse(entrada);
        java.util.Date end = dfs.parse(salida);
        between = (end.getTime() - begin.getTime()) / 1000; // División por 1000 es convertir a segundos
        day1 = between / (24 * 3600);
        hour1 = between % (24 * 3600) / 3600;
        minute1 = between % 3600 / 60;
        second1 = between % 60 / 60;
        System.out.println("" + day1 + "dias  " + hour1 +  " hora " + minute1 + " minuto " + second1 + " segundo ");
        }catch(ParseException ex){}        
        v.add(day1);
        v.add(hour1);
        v.add(minute1);
        v.add(second1);
        return v;
    }
    
    
    public void updateMovimientos(String fecha,String placa,String hora_salida ,String tiempo,Double dinero_generado){
        
        try {
            PreparedStatement stmt = Conexion.conectar().prepareStatement("UPDATE movimientos set hora_salida='"+hora_salida+"',tiempo='"+tiempo+"',dinero_generado="+dinero_generado+" WHERE placas='"+placa+"' AND fecha='"+fecha+"'");
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salida registrada correctamente");

        } catch (SQLException ex) {
            //Logger.getLogger(GuardarDatos2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        Conexion.cierraConexion();
    }  

    public void generarTicket(String employeeName,String fecha,String hora_entrada,int id_tarifaDB,String placa){
        
        Double tarifa = getVehicleType(id_tarifaDB);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //System.out.println(timestamp);
        String lop = timestamp.toString();
        String result = lop.replaceAll("\\p{Punct}", "");
        String result2 = result.replace(" ", "");
        Paragraph line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11, line12, line13, line14, line15;
        line1 = new Paragraph("\n\n\n\n\n\n\n\n\n\n=====================================================================");
        line2 = new Paragraph("Estacionamiento Aries");
        line3 = new Paragraph("Av 6 Ote 406");
        line4 = new Paragraph("Centro histórico de Puebla.");
        line5 = new Paragraph("72000 Puebla, Pue.");
        line6 = new Paragraph("");
        line7 = new Paragraph("");
        line8 = new Paragraph("Atendio");
        line9 = new Paragraph(employeeName);
        line10 = new Paragraph("——————————–——————————–——————————–——————————–");
        line11 = new Paragraph(fecha);
        line12 = new Paragraph(hora_entrada);
        line13 = new Paragraph(" Tarifa por hora o fraccion, sin tolerancia:"+tarifa);
        line14 = new Paragraph(" Costo por boleto perdido $100 ");
        line15 = new Paragraph("=====================================================================");
        line1.setAlignment(Element.ALIGN_CENTER);
        line2.setAlignment(Element.ALIGN_CENTER);
        line3.setAlignment(Element.ALIGN_CENTER);
        line4.setAlignment(Element.ALIGN_CENTER);
        line5.setAlignment(Element.ALIGN_CENTER);
        line6.setAlignment(Element.ALIGN_CENTER);
        line7.setAlignment(Element.ALIGN_CENTER);
        line8.setAlignment(Element.ALIGN_CENTER);
        line9.setAlignment(Element.ALIGN_CENTER);
        line10.setAlignment(Element.ALIGN_CENTER);
        line11.setAlignment(Element.ALIGN_CENTER);
        line12.setAlignment(Element.ALIGN_CENTER);
        line13.setAlignment(Element.ALIGN_CENTER);
        line14.setAlignment(Element.ALIGN_CENTER);
        line15.setAlignment(Element.ALIGN_CENTER);

        // TODO code application logic here
        try {
            Document doc = new Document();
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("C:\\tmp\\" + result2 + "ticket.pdf"));
            doc.open();
            Barcode128 code = new Barcode128();
            code.setCode(placa);
            Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
            img.scalePercent(400);
            img.setAlignment(Element.ALIGN_CENTER);

            //doc.add(new Paragraph("Estacionamiento Aries")); //Nombre establecimient)o
            doc.add(line1);
            doc.add(line2);
            doc.add(line3);
            doc.add(line4);
            doc.add(line5);
            doc.add(line6);
            doc.add(line7);
            doc.add(line8);
            doc.add(line9);
            doc.add(line10);
            doc.add(img);
            doc.add(line11);
            doc.add(line12);
            doc.add(line13);
            doc.add(line14);
            doc.add(line15);

            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Barras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Barras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        saveMovimientos(fecha, hora_entrada, id_tarifaDB, placa, employeeName);
        
        
    }

}
