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
import java.awt.Component;
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
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.print.PrintException;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Metodos 
{
    //public static  DefaultTableModel modeloF = new DefaultTableModel();
   // FTPClient ftp = new FTPClient();
    Conexion o = new Conexion();
    public int datoSeleccionado;
    DefaultTableModel modelo;
    public static String fileNameToBase;
    public static String consultaFiltrarToExcel;
    public static String correoEmpleado="";
    public static String nombreEmpleado="";
    public static String tipoEmpleado="";
    
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
                    //System.out.println("Correo matched CorreoDB=" + correoDB + " " + " CorreoUSer=" + correouser2);
                } else {
                    usuarioExistente = false;
                    //System.out.println("Cooreo no matched CorreoDB=" + correoDB + " " + " CorreoUSer=" + correouser2);
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
                //System.out.println("IDMOVIMIRNETO REGIS "+id_mov);
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
        //System.out.println("" + day1 + "dias  " + hour1 +  " hora " + minute1 + " minuto " + second1 + " segundo ");
        }catch(ParseException ex){}        
        v.add(day1);
        v.add(hour1);
        v.add(minute1);
        v.add(second1);
        return v;
    }
    
    public Double getRateByIdMov(int id_movimiento){
        //select movimientos.id_movimiento,tarifas.tarifa FROM movimientos NATURAL JOIN tarifas WHERE movimientos.id_movimiento=3 AND movimientos.id_tarifa=tarifas.id_tarifa;
        PreparedStatement stmnt = null;
        ResultSet rs = null;

        double tarifa = 0;
        try {
            stmnt = Conexion.conectar().prepareStatement("select tarifas.tarifa as tarifa FROM movimientos NATURAL JOIN tarifas WHERE movimientos.id_movimiento="+id_movimiento+" AND movimientos.id_tarifa=tarifas.id_tarifa");
            rs = stmnt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        try {
            while (rs.next()) {
                tarifa = rs.getDouble("tarifa");

            }
        } catch (SQLException ex) {
        }
        Conexion.cierraConexion();
        return tarifa;
    }
    
    public Double changeRateByDays(String placas){
        //select * from tarifas WHERE id_tarifa
          int id_movimiento = obtenerId(placas);
           int  id_tarifa;
        String tipo_vehiculo = null;
        String tipo_tarifa;
        Double tarifa = null;
        PreparedStatement stmnt = null,stmnt2=null;
        ResultSet rs = null,rs2=null;

        //double tarifa = 0;
        try {
            //stmnt = Conexion.conectar().prepareStatement("SELECT tarifas.id_tarifa,tarifas.tipo_vehiculo,tarifas.tipo_tarifa,tarifas.tarifa FROM movimientos NATURAL JOIN tarifas WHERE movimientos.id_movimiento="+id_movimiento+" AND movimientos.id_tarifa=tarifas.id_tarifa");
            stmnt = Conexion.conectar().prepareStatement("SELECT tarifas.tipo_vehiculo FROM movimientos NATURAL JOIN tarifas WHERE  movimientos.id_tarifa=tarifas.id_tarifa AND movimientos.id_movimiento="+id_movimiento+" ");
            rs = stmnt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        try {
            while (rs.next()) {
                //id_tarifa = rs.getInt("id_tarifa");
                tipo_vehiculo = rs.getString("tipo_vehiculo");
                //tipo_tarifa = rs.getString("tipo_tarifa");
                //tarifa = rs.getDouble("tarifa");

            }
        } catch (SQLException ex) {
        }
       
        
        try {
            stmnt2 = Conexion.conectar().prepareStatement("select tarifa from tarifas WHERE tipo_vehiculo='"+tipo_vehiculo+"' AND tipo_tarifa='Dia'");
            rs2 = stmnt2.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        try {
            while (rs2.next()) {
                //id_tarifa = rs.getInt("id_tarifa");
                //tipo_vehiculo = rs.getString("tipo_vehiculo");
                //tipo_tarifa = rs.getString("tipo_tarifa");
                tarifa = rs2.getDouble("tarifa");

            }
        } catch (SQLException ex) {
        }
        Conexion.cierraConexion();
        return tarifa;
    }
    
    public boolean checkEnrollmentIsNull(String placas){
    boolean checkEnrollment = false;
    int cantidad=0;
    //
        PreparedStatement stmnt = null;
        ResultSet rs = null;

        //double tarifa = 0;
        try {
            
            stmnt = Conexion.conectar().prepareStatement("SELECT count(id_movimiento) as ckecked FROM movimientos WHERE placas='"+placas+"' AND hora_salida IS NULL");
            rs = stmnt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        try {
            while (rs.next()) {
                //id_tarifa = rs.getInt("id_tarifa");
                cantidad = rs.getInt("ckecked");
                //tipo_tarifa = rs.getString("tipo_tarifa");
                //tarifa = rs.getDouble("tarifa");

            }
        } catch (SQLException ex) {
        }
        if (cantidad==0) {
            checkEnrollment = false;
        }else{
        checkEnrollment=true;
        }
    return checkEnrollment;
    }
    
    public String[] calculateRateToPay(String horaF,String placas){
         
         String[] mensajes = new String[5];
          String msg1 = "",msg2 = "",msg3 = "",msg4;
        LocalDate todaysDate = LocalDate.now();
        String fechaF = todaysDate.toString();
        //String horaF = labelVEReloj.getText();
        String fechafinal = fechaF + " " + horaF;
        // String placas = txtPlacaSalida.getText();
        int id_movimiento = obtenerId(placas);
        
        String fechaEntrada = obtenerHoraEntrada(id_movimiento);
        Vector nvec = new Vector();
        nvec = calculateTime(fechaEntrada, fechafinal);
        String dia = nvec.elementAt(0).toString();
        int dias = Integer.valueOf(dia);
        String hora = nvec.elementAt(1).toString();
        int horas = Integer.valueOf(hora);
        String minuto = nvec.elementAt(2).toString();
        int minutos = Integer.valueOf(minuto);
        Double tarifaACobrar = getRateByIdMov(id_movimiento);
        Double tarifaACobrarXDIA = 0.0;
        Double tpd = 0.0;
        Double tph = 0.0;
        Double tpm = 0.0;
        Double tarifaFinal = 0.0;
        if (dias >= 1) {
            tarifaACobrarXDIA = changeRateByDays(placas);
            tpd = dias * tarifaACobrarXDIA;
             //msg1 = dias+" x "+tarifaACobrarXDIA+"= "+tpd+"\n";
             msg1 = dias+"";
             System.out.println(tarifaACobrarXDIA+" tcpd\n");
        }else{tpd=0.0;}
        if (horas >= 1) {
            tph = horas * tarifaACobrar;
            //msg2 = "horas: "+horas+" x "+tarifaACobrar+"= "+tph+"\n";
            msg2 = horas+"";
        }else{tph =0.0;}
        if (minutos >= 0 && minutos <=60) {
            tpm = 1 * tarifaACobrar;
            //msg3 = "mins: "+minutos+" x "+tarifaACobrar+"= "+tpm+"\n";
            msg3 =minutos+"";
        }else{tpm=0.0;}
        
        tarifaFinal=tpd+tph+tpm;
            msg4 = tarifaFinal+"" ;
        String tiempo = "dia: "+dia+" hora: "+hora+" minuto: "+minuto;
        mensajes[0] = msg1;
        mensajes[1] = msg2;
        mensajes[2] = msg3;
        mensajes[3] = tiempo;
        mensajes[4] = msg4;
        
        return mensajes;
    }
    
    
    public void updateMovimientos(int id_movimiento,String placa,String hora_salida ,String tiempo,Double dinero_generado){
        
        try {
            PreparedStatement stmt = Conexion.conectar().prepareStatement("UPDATE movimientos set hora_salida='"+hora_salida+"',tiempo='"+tiempo+"',dinero_generado="+dinero_generado+" WHERE id_movimiento="+id_movimiento+"");
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salida registrada correctamente");

        } catch (SQLException ex) {
            //Logger.getLogger(GuardarDatos2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        Conexion.cierraConexion();
    }  
    
    public void imprimirTicket(String nombreArchivo){
        try {
            PDDocument document = PDDocument.load(new File("C:\\tmp\\"+nombreArchivo+"ticket.pdf"));
            
            PrinterJob job = PrinterJob.getPrinterJob();
            
            //System.out.println("jj");
            if (job.printDialog() == true) {
                job.setPageable(new PDFPageable(document));
                
                //LOGGER.log(Level.INFO, "Imprimiendo documento");
                //System.out.println("imprimiendo");
                try {
                    job.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{JOptionPane.showMessageDialog(null, "no se encontro archivo");}
            document.close();
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        line8 = new Paragraph("Atendio: " + employeeName);
        line9 = new Paragraph("——————————–——————————–——————————–——————————–");
        line10 = new Paragraph(fecha);
        line11 = new Paragraph(hora_entrada);
        line12 = new Paragraph(" Tarifa por hora o fraccion, sin tolerancia:" + tarifa);
        line13 = new Paragraph(" Costo por boleto perdido $100 ");
        line14 = new Paragraph("Estacionamiento Aries no se hace responsable por fallas mecanicas o electricas, así como objetos dejados en su interior que no hayan sido reportados a la administración.");
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
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("C:\\tmp\\" + result2+placa + "ticket.pdf"));
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
        
        //saveMovimientos(fecha, hora_entrada, id_tarifaDB, placa, employeeName);
        //unComentLineToPrint
        imprimirTicket(result2+placa);
        
        
    }
    
    public String getHourT(){
        Calendar calendario = new GregorianCalendar();     
        int hora, minutos, segundos;
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        String horaCompleta = hora + ":" + minutos + ":" + segundos;
        return horaCompleta;
    }
    
    public String getDateT(){
        LocalDate todaysDate = LocalDate.now();        
        String fechaF = todaysDate.toString();
        return fechaF;
    }
    
    public void insertCaja(String fecha,String hora,double monto_inicial){
        //String fecha,String hora,double monto_inicial,double monto_final
        //insertCaja(fecha,hora,monto_inicial,monto_final)
        //double monto_inicial,monto_final;
        PreparedStatement stmnt = null,stmnt2 = null;
        ResultSet rs=null;
        int num_registros = 0 ;
        try {
            stmnt2 = Conexion.conectar().prepareStatement("select count(id) as num_registros from caja WHERE fecha='"+fecha+"'");
            rs = stmnt2.executeQuery();
            while (rs.next()) {
                num_registros = rs.getInt("num_registros");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        if (num_registros == 0) {
            try {
                stmnt = Conexion.conectar().prepareStatement("INSERT INTO caja values(0,'" + fecha + "','" + hora + "'," + monto_inicial + ",0)");
                stmnt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usted establecio $" + monto_inicial + " como monto en la caja.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error:" + ex);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Ya se establecio un monto para la caja con fecha: "+fecha);
        }
        
        
        Conexion.cierraConexion();

        
    }

    public void insertMovimientosCaja(String fecha,String hora,String motivo,double monto,String tipo,String correo){
    //    insertMovimientosCaja(id,fecha,hora,motivo,monto,tipo)
        PreparedStatement stmnt = null;
        try {
                stmnt = Conexion.conectar().prepareStatement("INSERT INTO movimientos_caja values(0,'" + fecha + "','" + hora + "','"+motivo+"',"+monto+",'"+tipo+"','"+correo+"')");
                stmnt.executeUpdate();
                JOptionPane.showMessageDialog(null, tipo+" de $"+monto+" registrado correctamente.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error:" + ex);
            }
    Conexion.cierraConexion();
    }

    public String getNameUser(String correo)
    {//select CONCAT(apellidop,' ',apellidom,' ',nombre) as nc from usuarios
        PreparedStatement stmnt = null;
        ResultSet rs = null;
        String completeName="";
        try {
            stmnt = Conexion.conectar().prepareStatement("select CONCAT(apellidop,' ',apellidom,' ',nombre) as nc from usuarios WHERE correo='"+correo+"'");
            rs = stmnt.executeQuery();
            while (rs.next()) {
               completeName = rs.getString("nc");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        Conexion.cierraConexion();
        return completeName;
    }
    
    public String getTypeUser(String correo) {
    //select CONCAT(apellidop,' ',apellidom,' ',nombre) as nc from usuarios
        PreparedStatement stmnt = null;
        ResultSet rs = null;
        String userType = "";
        try {
            stmnt = Conexion.conectar().prepareStatement("select area from usuarios WHERE correo='" + correo + "'");
            rs = stmnt.executeQuery();
            while (rs.next()) {
                userType = rs.getString("area");
               // System.out.println("flag from metodo"+userType);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        Conexion.cierraConexion();
        return userType;
    }
    
    /*public void setCaja(String fecha,String hora,Double monto_inicial,Double monto_final){
        //  String fecha,String hora,Doble monto_inicial,Double monto_final
        //fecha,hora,monto_inicial,monto_final,correo
        PreparedStatement stmnt = null;
        try {
            stmnt = Conexion.conectar().prepareStatement("INSERT INTO caja values(0,'"+fecha+"','"+hora+"',"+monto_inicial+",0)");
            stmnt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Correo: " + correo + " registrado correctamente en la base de datos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        Conexion.cierraConexion();
    }
    */
    
    public Double selectDataCaja(String fecha){
        PreparedStatement stmnt = null;
        ResultSet rs = null;
        Double monto_inicial = 0.0;
        try {
            stmnt = Conexion.conectar().prepareStatement("select monto_inicial from caja WHERE fecha='"+fecha+"'");
            rs = stmnt.executeQuery();
            while (rs.next()) {
                monto_inicial = rs.getDouble("monto_inicial");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        Conexion.cierraConexion();
     return monto_inicial;
    }
    
    public Double getIngresosCaja(String fecha){
        PreparedStatement stmnt = null;
        ResultSet rs = null;
        Double monto_ingresos=0.0;
        //SELECT SUM(monto) as monto_ingresos from movimientos_caja WHERE tipo='Ingreso'
        try {
            stmnt = Conexion.conectar().prepareStatement("SELECT SUM(monto) as monto_ingresos from movimientos_caja WHERE tipo='Ingreso' AND fecha='"+fecha+"'");
            rs = stmnt.executeQuery();
            while (rs.next()) {
                monto_ingresos = rs.getDouble("monto_ingresos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        Conexion.cierraConexion();
    return monto_ingresos;
    }
    
    public Double getEgresosCaja(String fecha) {
        PreparedStatement stmnt = null;
        ResultSet rs = null;
        Double monto_egresos = 0.0;
        //SELECT SUM(monto) as monto_egresos from movimientos_caja WHERE tipo='Ingreso'
        try {
            stmnt = Conexion.conectar().prepareStatement("SELECT SUM(monto) as monto_egresos from movimientos_caja WHERE tipo='Egreso' AND fecha='" + fecha + "'");
            rs = stmnt.executeQuery();
            while (rs.next()) {
                monto_egresos = rs.getDouble("monto_egresos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        Conexion.cierraConexion();
        return monto_egresos;
    }

    public void reporteCaja(String fechaParam) {
            
            /************************************************************************************/
           
        
        
                   
                   
            /*************************************************************************************/
        Date fecha = new Date();
        String nombreArchivoCreado = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String Fecha55 = sdf.format(fecha);

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Reporte");

        try {
            InputStream is = new FileInputStream("C:\\Multimedia\\iconoApp.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            is.close();

            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();

            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(0);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(2, 4);

            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);

            Row filaTitulo = sheet.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte caja");

            sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));
            String[] cabecera = {"No.","Fecha","Hora","Motivo","Monto","Tipo","Registró"};

            CellStyle headerStyle = book.createCellStyle();
            /**
             * ***************************************************************
             */
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFPalette palette = hwb.getCustomPalette();
            // get the color which most closely matches the color you want to use
            HSSFColor myColor = palette.findSimilarColor(155, 0, 0);
            // get the palette index of that color 
            short palIndex = myColor.getIndex();
            /**
             * ****************************************************************
             */
            headerStyle.setFillForegroundColor(palIndex);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(4);

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            
            //Connection conn = (Connection) con.conectar();

            int numFilaDatos = 5;

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);

            ps = Conexion.conectar().prepareStatement("SELECT * FROM movimientos_caja WHERE fecha='"+fechaParam+"' ORDER BY tipo");
            rs = ps.executeQuery();
            
            int numCol = rs.getMetaData().getColumnCount();
            

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);
                    CeldaDatos.setCellValue(rs.getString(a + 1));
                }

                //Cell celdaImporte = filaDatos.createCell(4);
                //celdaImporte.setCellStyle(datosEstilo);
                //celdaImporte.setCellFormula(String.format("C%d+D%d", numFilaDatos + 1, numFilaDatos + 1));
                numFilaDatos++;

            }
            
            /*************************************************************************************************/
            double ingresos = getIngresosCaja(fechaParam);
            double egresos = getEgresosCaja(fechaParam);
            double caja = selectDataCaja(fechaParam);
            
            double res3t;
            
            res3t = caja + ingresos - egresos;
            /****************************************************************************************************/
            Row filaDatos2 = sheet.createRow(numFilaDatos+1);
            Cell CeldaDatos2 = filaDatos2.createCell(5);
            Cell CeldaDatos3 = filaDatos2.createCell(6);
            CeldaDatos2.setCellValue("Caja");
            CeldaDatos3.setCellValue(caja);
            
            
            Row filaDatos3 = sheet.createRow(numFilaDatos+2);
            Cell CeldaDatos4 = filaDatos3.createCell(5);
            Cell CeldaDatos5 = filaDatos3.createCell(6);
            CeldaDatos4.setCellValue("Total Ingresos:");
            CeldaDatos5.setCellValue(getIngresosCaja(fechaParam));
       
            
            Row filaDatos4 = sheet.createRow(numFilaDatos+3);
            Cell CeldaDatos6 = filaDatos4.createCell(5);
            Cell CeldaDatos7 = filaDatos4.createCell(6);
            CeldaDatos6.setCellValue("Total Egresos");
            CeldaDatos7.setCellValue(getEgresosCaja(fechaParam));
            
            Row filaDatos5 = sheet.createRow(numFilaDatos + 4);
            Cell CeldaDatos8 = filaDatos5.createCell(5);
            Cell CeldaDatos9 = filaDatos5.createCell(6);
            CeldaDatos8.setCellValue("Caja despues de movimientos");
            CeldaDatos9.setCellValue(res3t);
            
            
            /*Row filaDatos3 = sheet.createRow(numFilaDatos+2);
            Cell CeldaDatos3 = filaDatos3.createCell(6);
            CeldaDatos3.setCellValue("popo2");
            
            Row filaDatos4 = sheet.createRow(numFilaDatos+3);
            Cell CeldaDatos4 = filaDatos4.createCell(6);
            CeldaDatos4.setCellValue("popo3");*/
            
            

            for (int i = 0; i < numCol; i++) {
                sheet.autoSizeColumn(i);
            }
            /*sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);*/

            sheet.setZoom(100);

            FileOutputStream fileOut = new FileOutputStream("C:\\FilesExportExcel\\" + Fecha55 + "ReporteFoliosFiltrados.xlsx");
            nombreArchivoCreado = "C:\\FilesExportExcel\\" + Fecha55 + "ReporteFoliosFiltrados.xlsx";
            book.write(fileOut);
            fileOut.close();
            JOptionPane.showMessageDialog(null, "Exportado");

        } catch (FileNotFoundException ex) {
            System.out.println("" + ex);
        } catch (IOException ex) {
            System.out.println("" + ex);
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
        //Vistas.Filtrar.jButton2.setText(nombreArchivoCreado);
    }
    
    public Map<Integer, String> getPlan() {
        PreparedStatement stmnt = null;
        ResultSet rs = null;

        Map<Integer, String> rateArray = new HashMap<Integer, String>();
        try {
            stmnt = Conexion.conectar().prepareStatement("SELECT id_plan,tipo_plan from plan");
            rs = stmnt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        try {
            while (rs.next()) {
                rateArray.put(rs.getInt("id_plan"), rs.getString("tipo_plan"));

            }
        } catch (SQLException ex) {
        }
        Conexion.cierraConexion();
        return rateArray;

    }
    
    public void createTicketPension(String telefono,String employeeName){
        //Double tarifa = getVehicleType(id_tarifaDB);
        //SELECT CONCAT(pension.nombre,' ',pension.apellidop,' ',pension.apellidom)as nombre_completo,pension.dia_inicio,pension.hora_inicio,pension.dia_vencimiento,pension.hora_vencimiento,plan.tipo_plan,plan.precio,pension.cantidad_plan,pension.importe_pagado FROM pension  JOIN plan WHERE pension.id_plan=plan.id_plan AND telefono='2225790342';
        String nombre_completo = null, dia_inicio = null, hora_inicio = null, dia_vencimiento = null, hora_vencimiento = null, tipo_plan = null;
        Double precio=0.0, importe_pagado=0.0;
        int cantidad_plan=0;
        PreparedStatement stmnt = null;
        ResultSet rs = null;

        //Map<Integer, String> rateArray = new HashMap<Integer, String>();
        try {
            stmnt = Conexion.conectar().prepareStatement("SELECT CONCAT(pension.nombre,' ',pension.apellidop,' ',pension.apellidom)as nombre_completo,pension.dia_inicio,pension.hora_inicio,pension.dia_vencimiento,pension.hora_vencimiento,plan.tipo_plan,plan.precio,pension.cantidad_plan,pension.importe_pagado FROM pension  JOIN plan WHERE pension.id_plan=plan.id_plan AND telefono='"+telefono+"'");
            rs = stmnt.executeQuery();
            while (rs.next()) {
                nombre_completo = rs.getString("nombre_completo");
                dia_inicio = rs.getString("pension.dia_inicio");
                hora_inicio = rs.getString("pension.hora_inicio");
                dia_vencimiento = rs.getString("pension.dia_vencimiento");
                hora_vencimiento = rs.getString("pension.hora_vencimiento");
                tipo_plan = rs.getString("plan.tipo_plan");
                precio = rs.getDouble("plan.precio");
                cantidad_plan = rs.getInt("pension.cantidad_plan");
                importe_pagado = rs.getDouble("pension.importe_pagado");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }

        Conexion.cierraConexion();

         Timestamp timestamp = new Timestamp(System.currentTimeMillis());
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
        line7 = new Paragraph("Atendio");
        line8 = new Paragraph(employeeName);
        line9 = new Paragraph("Cliente: "+nombre_completo);
        line10 = new Paragraph("——————————–——————————–——————————–——————————–");
        line11 = new Paragraph("Dia inicio: "+dia_inicio+" "+"Hora inicio: "+hora_inicio );
        line12 = new Paragraph("Dia vencimiento: "+dia_vencimiento+" "+"Hora vencimiento: "+hora_vencimiento );
        line13 = new Paragraph("Tipo plan: " +tipo_plan+" Precio: $"+precio+" cantidad contratada: "+cantidad_plan+" importe pagado: $"+importe_pagado );
        line14 = new Paragraph(" Costo por carnet perdido $100 ");
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
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("C:\\tmp\\" + result2+telefono + "ticket.pdf"));
            doc.open();
            Barcode128 code = new Barcode128();
            code.setCode(telefono);
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

        //saveMovimientos(fecha, hora_entrada, id_tarifaDB, placa, employeeName);
        //unComentLineToPrint
        imprimirTicket(result2+telefono);
    
    }
    
    public int getDurecionPlan(int id_plan){
        int duracion=0;
        
        PreparedStatement stmnt = null;
        ResultSet rs = null;
        
        //SELECT SUM(monto) as monto_egresos from movimientos_caja WHERE tipo='Ingreso'
        try {
            stmnt = Conexion.conectar().prepareStatement("SELECT duracion from plan WHERE id_plan="+id_plan+"");
            rs = stmnt.executeQuery();
            while (rs.next()) {
                duracion = rs.getInt("duracion");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        Conexion.cierraConexion();
    
    return duracion;
    }
    
    public String calcularfechaV(int id_plan,String dia_inicio,int cantidad_plan){
    String dia_vencimiento="";
        int duracion = 0;
        duracion = getDurecionPlan(id_plan);
        LocalDate fechaInicio = LocalDate.parse(dia_inicio);
        LocalDate fechaVencimiento = fechaInicio.plusDays(duracion * cantidad_plan);
        dia_vencimiento = fechaVencimiento.toString();
    return dia_vencimiento;
    }
    
    
    public Double getPrecioPlan(int id_plan) {
        double precio = 0.0;

        PreparedStatement stmnt = null;
        ResultSet rs = null;

        //SELECT SUM(monto) as monto_egresos from movimientos_caja WHERE tipo='Ingreso'
        try {
            stmnt = Conexion.conectar().prepareStatement("SELECT precio from plan WHERE id_plan=" + id_plan + "");
            rs = stmnt.executeQuery();
            while (rs.next()) {
                precio = rs.getDouble("precio");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        Conexion.cierraConexion();

        return precio;
    }
    
    public void insertPension(String telefono,String nombre,String apellidop,String apellidom,String direccion,String identificacion,int id_plan,String dia_inicio,String hora_inicio,int cantidad_plan,boolean pagado,Double importe_pagado){
        //telefono,nombre,apellidop,apellidom,direccion,identificacion id_plan,dia_inicio,dia_vencimiento,cantidad_plan,pagado
        PreparedStatement stmnt = null;
        String dia_vencimiento = calcularfechaV(id_plan,dia_inicio,cantidad_plan);
        int activo=1;
        if (pagado==true) {
            activo=1;
        }else{activo=0;}
        
        try {
            stmnt = Conexion.conectar().prepareStatement("INSERT INTO pension values ('" + telefono + "','" + nombre + "','" + apellidop + "','" + apellidom + "','" + direccion + "','" + identificacion + "'," + id_plan + ",'" + dia_inicio + "','"+hora_inicio+"','" + dia_vencimiento + "','"+hora_inicio+"'," + cantidad_plan + "," + activo + ","+importe_pagado+")");
            stmnt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente para plan " + nombre + " " + apellidop + " " + apellidom + "ingresado correctamente a la base de datos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        Conexion.cierraConexion();
    
    }
    
    public boolean verificarSalidaNoRegistradaPension(String telefono){
    //select hora_salida from movimientos_pension WHERE telefono='2225790336' AND fecha='2022-02-06'
        boolean snr = false;
        PreparedStatement stmnt = null;
        ResultSet rs = null;
        String hsdb="";
        try {
            stmnt = Conexion.conectar().prepareStatement("select hora_salida from movimientos_pension WHERE telefono='"+telefono+"'");
            rs = stmnt.executeQuery();
            while (rs.next()) {
                hsdb = rs.getString("hora_salida");
                //System.out.println("FLAG FROM verificarSalidaNoRegistradaPension: "+hsdb);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        Conexion.cierraConexion();
        if (hsdb.equals("00:00:00")) {
            snr=true;
        }else{snr=false;}
    
    return snr;
    }
    
    public String obtenerHoraEntradaPension(String telefono) {
        String hora_entrada = "";
        PreparedStatement stmnt = null;
        ResultSet rs = null;
        try {
            stmnt = Conexion.conectar().prepareStatement("SELECT CONCAT(fecha,' ',hora_entrada) as fecha from movimientos_pension WHERE telefono=" + telefono);
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
    
    public int obtenerIdMovPension(String telefono) {
        int id_mov = 0;
        PreparedStatement stmnt = null;
        ResultSet rs = null;
        try {
            stmnt = Conexion.conectar().prepareStatement("SELECT id_movimiento from movimientos_pension WHERE telefono='" + telefono + "' AND hora_salida='00:00:00'");
            rs = stmnt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        try {
            while (rs.next()) {
                id_mov = rs.getInt("id_movimiento");
                //System.out.println("IDMOVIMIRNETO REGIS "+id_mov);
            }
        } catch (SQLException ex) {
        }
        Conexion.cierraConexion();

        return id_mov;
    }
    
    public Vector calculateTimeRestante(String entrada, String salida) {
        long between;
        long day1 = 0;
        long hour1 = 0;
        long minute1 = 0;
        long second1 = 0;
        Vector v = new Vector();

        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            java.util.Date begin = dfs.parse(entrada);
            java.util.Date end = dfs.parse(salida);
            between = (end.getTime() - begin.getTime()) / 1000; // División por 1000 es convertir a segundos
            day1 = between / (24 * 3600);
            hour1 = between % (24 * 3600) / 3600;
            minute1 = between % 3600 / 60;
            second1 = between % 60 / 60;
            //System.out.println("" + day1 + "dias  " + hour1 +  " hora " + minute1 + " minuto " + second1 + " segundo ");
        } catch (ParseException ex) {
        }
        v.add(day1);
        v.add(hour1);
        v.add(minute1);
        v.add(second1);
        return v;
    }

    public int verificarPlanActivo(String telefono) {
        int activo = 0;

        PreparedStatement stmnt = null;
        ResultSet rs = null;

        //SELECT SUM(monto) as monto_egresos from movimientos_caja WHERE tipo='Ingreso'
        try {
            stmnt = Conexion.conectar().prepareStatement("select pagado from pension WHERE telefono='"+telefono+"'");
            rs = stmnt.executeQuery();
            while (rs.next()) {
                activo= rs.getInt("activo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        Conexion.cierraConexion();

        return activo;
    }
    
    public String selectFechaVencimientoPlan(String telefono){
        String fechaV="";
        PreparedStatement stmnt = null;
        ResultSet rs = null;

        //SELECT SUM(monto) as monto_egresos from movimientos_caja WHERE tipo='Ingreso'
        try {
            stmnt = Conexion.conectar().prepareStatement("select CONCAT(dia_vencimiento,' ',hora_vencimiento) as fecha_v from pension WHERE telefono='"+telefono+"'");
            rs = stmnt.executeQuery();
            while (rs.next()) {
                fechaV = rs.getString("fecha_v");
               // System.out.println("FLAG FROM selectFechaVencimientoPlan "+fechaV);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        Conexion.cierraConexion();
        
        
    return fechaV;
    }
    
    public String calcularTiempoRestanteParaPlan(String telefono,String fecha, String hora_entrada){
        String tiempoV="";
        String fechaHoy = fecha+" "+hora_entrada;
        String fechaVencimiento = selectFechaVencimientoPlan(telefono);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
                java.util.Date now = df.parse(fechaVencimiento);//--Vencimiento
                java.util.Date date = df.parse(fechaHoy);//--hoy
                long l = now.getTime() - date.getTime();
                long day = l / (24 * 60 * 60 * 1000);
                long hour = (l / (60 * 60 * 1000) - day * 24);
                long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
                long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
                tiempoV ="Tiempo restante plan: " + day + " día " + hour + " hora " + min + " minuto ";
            
            
        } catch (ParseException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    return tiempoV;
    }
    
    public void saveMovimientosEntradaSalidaPension(String fecha,String hora_entrada,String telefono,String correo){
    //id_movimiento,fecha,hora_entrada,hora_salida,tiempo,telefono,correo
        PreparedStatement stmnt = null;
        try {
            stmnt = Conexion.conectar().prepareStatement("insert into movimientos_pension values(0,'"+fecha+"','"+hora_entrada+"','0000-00-00','00:00:00','sc','"+telefono+"','"+correo+"')");
            stmnt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente en la base de datos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        Conexion.cierraConexion();
    
    }
    
    public void registrarSalidaPension(String fecha,String horaF,String telefono){
       String fechaSalida = fecha + " " + horaF;
       String fechasDB ="0000-00-00";
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       PreparedStatement stmnt = null,stmnt2 = null;
       ResultSet rs = null;
       String tiempoTDB ="";

       //SELECT SUM(monto) as monto_egresos from movimientos_caja WHERE tipo='Ingreso'
       try {
           stmnt = Conexion.conectar().prepareStatement("SELECT CONCAT(fecha,' ',hora_entrada) as fhe FROM movimientos_pension WHERE telefono='"+telefono+"' AND hora_salida='00:00:00'");
           rs = stmnt.executeQuery();
           while (rs.next()) {
               fechasDB = rs.getString("fhe");
           }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Error:" + e);
       }
       
       
       try {
            //UPDATE movimientos_pension set hora_salida='11:59:00',tiempo='dia: 0 hora: 12 minuto 0' WHERE telefono='2225790336' AND hora_salida='00:00:00'            
            java.util.Date now = df.parse(fechaSalida);//--HORADESalida
            java.util.Date date = df.parse(fechasDB);//--FECHADB
            long l = now.getTime() - date.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            tiempoTDB= day + " día " + hour + " hora " + min + " minuto " + s + " segundo ";
        } catch (ParseException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       try {
           stmnt2 = Conexion.conectar().prepareStatement("UPDATE movimientos_pension set fecha_salida='"+fecha+"',hora_salida='"+horaF+"',tiempo='"+tiempoTDB+"' WHERE telefono='"+telefono+"' AND hora_salida='00:00:00'");
           stmnt2.executeUpdate();
           JOptionPane.showMessageDialog(null, "Salida registrada correctamente en la base de datos");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error:" + ex);
       }
       
       
       
    Conexion.cierraConexion();
   }

    public DefaultTableModel ediTarifas(JTable tabla){
       PreparedStatement stmnt = null,stmnt2 = null;
       ResultSet rs = null,rs2=null;
       DefaultTableModel model = new DefaultTableModel();
/*
       model.addColumn("Tipo plan");
       model.addColumn("Duracion en dias");
       model.addColumn("Precio");
       model.addColumn("Precio");
*/       
       
       try {
           stmnt = Conexion.conectar().prepareStatement("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME = 'tarifas'");
           rs = stmnt.executeQuery();
           while (rs.next()) {
               //model.addRow(new Object[]{rs.getString("tipo_plan"), rs.getInt("duracion"), rs.getDouble("precio")});
               model.addColumn(rs.getString("COLUMN_NAME"));
           }
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error:" + ex);
       }
       
       
       try {           
           stmnt2 = Conexion.conectar().prepareStatement("SELECT * FROM tarifas");
           rs2 = stmnt2.executeQuery();
           while (rs2.next()) {
               //model.addRow(new Object[]{rs.getString("tipo_plan"), rs.getInt("duracion"), rs.getDouble("precio")});
               
               //model.addRow(new Object[]{rs2.getInt("id_tarifa"), rs2.getString("tipoVehiculo"), rs2.getString("tipo_tarifa"), rs2.getDouble("precio")});
               model.addRow(new Object[]{rs2.getInt("id_tarifa"),rs2.getString("tipo_vehiculo"),rs2.getString("tipo_tarifa"),rs2.getDouble("tarifa")});
           }
       } catch (SQLException ex) {
       }
       Conexion.cierraConexion();

       return model;
   }
   
    public DefaultTableModel ediTarifasPlan(JTable tabla) {
        PreparedStatement stmnt = null, stmnt2 = null;
        ResultSet rs = null, rs2 = null;
        DefaultTableModel model = new DefaultTableModel();
        /*
       model.addColumn("Tipo plan");
       model.addColumn("Duracion en dias");
       model.addColumn("Precio");
       model.addColumn("Precio");
         */

        try {
            stmnt = Conexion.conectar().prepareStatement("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME = 'plan'");
            rs = stmnt.executeQuery();
            while (rs.next()) {
                //model.addRow(new Object[]{rs.getString("tipo_plan"), rs.getInt("duracion"), rs.getDouble("precio")});
                model.addColumn(rs.getString("COLUMN_NAME"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }

        try {
            stmnt2 = Conexion.conectar().prepareStatement("SELECT * FROM plan");
            rs2 = stmnt2.executeQuery();
            while (rs2.next()) {
                //model.addRow(new Object[]{rs.getString("tipo_plan"), rs.getInt("duracion"), rs.getDouble("precio")});

                //model.addRow(new Object[]{rs2.getInt("id_tarifa"), rs2.getString("tipoVehiculo"), rs2.getString("tipo_tarifa"), rs2.getDouble("precio")});
                model.addRow(new Object[]{rs2.getInt("id_plan"), rs2.getString("tipo_plan"), rs2.getInt("duracion"), rs2.getDouble("precio")});
            }
        } catch (SQLException ex) {
        }
        Conexion.cierraConexion();

        return model;
    }
       
    public DefaultTableModel entradasSalidas(JTable tabla,String fecha1,String fecha2) {
        PreparedStatement stmnt = null, stmnt2 = null;
        ResultSet rs = null, rs2 = null;
        DefaultTableModel model = new DefaultTableModel();
        
       model.addColumn("Id");
       model.addColumn("Placas");
       model.addColumn("Tipo");
       model.addColumn("Fecha");
       model.addColumn("Hora de entrada");
       model.addColumn("Hora de salida");
       model.addColumn("Tiempo transcurrido");
       model.addColumn("Tarifa");
       model.addColumn("Monto generado");
       model.addColumn("Atendio");
         

        /*try {
            stmnt = Conexion.conectar().prepareStatement("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME = 'plan'");
            rs = stmnt.executeQuery();
            while (rs.next()) {
                //model.addRow(new Object[]{rs.getString("tipo_plan"), rs.getInt("duracion"), rs.getDouble("precio")});
                model.addColumn(rs.getString("COLUMN_NAME"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }*/

        try {
            stmnt2 = Conexion.conectar().prepareStatement("SELECT movimientos.id_movimiento,movimientos.placas,tarifas.tipo_vehiculo,movimientos.fecha,movimientos.hora_entrada,movimientos.hora_salida,movimientos.tiempo,tarifas.tarifa,movimientos.dinero_generado,movimientos.correo from movimientos LEFT JOIN tarifas ON movimientos.id_tarifa=tarifas.id_tarifa WHERE movimientos.fecha between '"+fecha1+"' AND '"+fecha2+"'");
            rs2 = stmnt2.executeQuery();
            while (rs2.next()) {
                //model.addRow(new Object[]{rs.getString("tipo_plan"), rs.getInt("duracion"), rs.getDouble("precio")});

                //model.addRow(new Object[]{rs2.getInt("id_tarifa"), rs2.getString("tipoVehiculo"), rs2.getString("tipo_tarifa"), rs2.getDouble("precio")});
                model.addRow(new Object[]{rs2.getInt("movimientos.id_movimiento"), rs2.getString("movimientos.placas"),rs2.getString("tarifas.tipo_vehiculo"),rs2.getString("movimientos.fecha"),rs2.getString("movimientos.hora_entrada"),rs2.getString("movimientos.hora_salida"),rs2.getString("movimientos.tiempo"),rs2.getDouble("tarifas.tarifa"),rs2.getDouble("movimientos.dinero_generado"),rs2.getString("movimientos.correo")});
            }
        } catch (SQLException ex) {
        }
        Conexion.cierraConexion();

        return model;
    }

    
     public String reporteEntradaSalida(String fecha1,String fecha2) {
        Date fecha = new Date();
        String nombreArchivoCreado = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String Fecha55 = sdf.format(fecha);

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Reporte");

        try {
            InputStream is = new FileInputStream("C:\\Multimedia\\iconoApp.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            is.close();

            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();

            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(0);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(2, 4);

            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);

            Row filaTitulo = sheet.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte entradas y salidas");

            sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));
            String[] cabecera = {"Id","Placas","Tipo","Fecha","Hora de entrada","Hora de salida","Tiempo transcurrido","Tarifa","Monto generado","Atendio"};

            CellStyle headerStyle = book.createCellStyle();
            /**
             * ***************************************************************
             */
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFPalette palette = hwb.getCustomPalette();
            // get the color which most closely matches the color you want to use
            HSSFColor myColor = palette.findSimilarColor(155, 0, 0);
            // get the palette index of that color 
            short palIndex = myColor.getIndex();
            /**
             * ****************************************************************
             */
            headerStyle.setFillForegroundColor(palIndex);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(4);

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            
            //Connection conn = (Connection) con.conectar();

            int numFilaDatos = 5;

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);

            ps = Conexion.conectar().prepareStatement("SELECT movimientos.id_movimiento,movimientos.placas,tarifas.tipo_vehiculo,movimientos.fecha,movimientos.hora_entrada,movimientos.hora_salida,movimientos.tiempo,tarifas.tarifa,movimientos.dinero_generado,movimientos.correo from movimientos LEFT JOIN tarifas ON movimientos.id_tarifa=tarifas.id_tarifa WHERE movimientos.fecha between '"+fecha1+"' AND '"+fecha2+"'");
            rs = ps.executeQuery();
            
            int numCol = rs.getMetaData().getColumnCount();
            

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);
                    CeldaDatos.setCellValue(rs.getString(a + 1));
                }

                //Cell celdaImporte = filaDatos.createCell(4);
                //celdaImporte.setCellStyle(datosEstilo);
                //celdaImporte.setCellFormula(String.format("C%d+D%d", numFilaDatos + 1, numFilaDatos + 1));
                numFilaDatos++;

            }
      
            for (int i = 0; i < numCol; i++) {
                sheet.autoSizeColumn(i);
            }
            sheet.setZoom(100);

            FileOutputStream fileOut = new FileOutputStream("C:\\FilesExportExcel\\" + Fecha55 + "ReporteEntradasYSalidas.xlsx");
            nombreArchivoCreado = "C:\\FilesExportExcel\\" + Fecha55 + "ReporteEntradasYSalidas.xlsx";
            book.write(fileOut);
            fileOut.close();
            JOptionPane.showMessageDialog(null, "Exportado");

        } catch (FileNotFoundException ex) {
            System.out.println("" + ex);
        } catch (IOException ex) {
            System.out.println("" + ex);
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
        //Vistas.Filtrar.jButton2.setText(nombreArchivoCreado);
      return nombreArchivoCreado;
    }
     
     
     public static void adjustColumnPreferredWidths(JTable table) {
        TableColumnModel columnModel = table.getColumnModel();
        for (int col = 0; col < table.getColumnCount(); col++) {
            int maxwidth = 0;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer rend = table.getCellRenderer(row, col);
                Object value = table.getValueAt(row, col);
                Component comp = rend.getTableCellRendererComponent(table, value, false, false, row, col);
                maxwidth = Math.max(comp.getPreferredSize().width, maxwidth);
            }
            TableColumn column = columnModel.getColumn(col);
            column.setPreferredWidth(maxwidth);
        }
    }
    

     
     
     public DefaultTableModel entradasSalidasPension(JTable tabla, String fecha1, String fecha2) {
        PreparedStatement stmnt = null, stmnt2 = null;
        ResultSet rs = null, rs2 = null;
        DefaultTableModel model = new DefaultTableModel();
         

        model.addColumn("Telefono");
        model.addColumn("Nombre completo");
        model.addColumn("Direccion");
        model.addColumn("Identificacion");
        model.addColumn("Tipo de plan");
        model.addColumn("Precio");
        model.addColumn("Cantidad");
        model.addColumn("Dia de inicio");
        model.addColumn("Dia de vencimiento");
        model.addColumn("Importe pagado");
        model.addColumn("Activo");


        /*try {
         stmnt = Conexion.conectar().prepareStatement("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME = 'plan'");
         rs = stmnt.executeQuery();
         while (rs.next()) {
         //model.addRow(new Object[]{rs.getString("tipo_plan"), rs.getInt("duracion"), rs.getDouble("precio")});
         model.addColumn(rs.getString("COLUMN_NAME"));
         }
         } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error:" + ex);
         }*/
        try {
            stmnt2 = Conexion.conectar().prepareStatement("SELECT pension.telefono,CONCAT(pension.nombre,' ',pension.apellidop,' ',pension.apellidom) as nombre_completo,pension.direccion,pension.identificacion,plan.tipo_plan,plan.precio,pension.cantidad_plan,CONCAT(pension.dia_inicio,' ',pension.hora_inicio) as di,CONCAT(pension.dia_vencimiento,' ',pension.hora_vencimiento) as df,pension.importe_pagado,pension.pagado FROM pension JOIN plan ON pension.id_plan=plan.id_plan WHERE pension.dia_inicio BETWEEN '"+fecha1+"' AND '"+fecha2+"'");
            rs2 = stmnt2.executeQuery();
            while (rs2.next()) {
                //model.addRow(new Object[]{rs.getString("tipo_plan"), rs.getInt("duracion"), rs.getDouble("precio")});

                model.addRow(new Object[]{rs2.getString("pension.telefono"), rs2.getString("nombre_completo"),rs2.getString("pension.direccion"),rs2.getString("pension.identificacion"),rs2.getString("plan.tipo_plan"),rs2.getString("plan.precio"),rs2.getString("pension.cantidad_plan"),rs2.getString("di"),rs2.getString("df"),rs2.getDouble("pension.importe_pagado"),rs2.getInt("pension.pagado")});
                //model.addRow(new Object[]{"e","s","t","a","e","s","u","n","a","tr","y"});
            }
        } catch (SQLException ex) {
        }
        Conexion.cierraConexion();

        return model;
    }

    public String reporteEntradaSalidaPension(String fecha1, String fecha2) {
        Date fecha = new Date();
        String nombreArchivoCreado = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String Fecha55 = sdf.format(fecha);

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Reporte");

        try {
            InputStream is = new FileInputStream("C:\\Multimedia\\iconoApp.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            is.close();

            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();

            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(0);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(2, 4);

            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);

            Row filaTitulo = sheet.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte entradas y salidas");

            sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));
            String[] cabecera = {"Telefono","Nombre completo","Direccion","Identificacion","Tipo de plan","Precio","Cantidad","Dia de inicio","Dia de vencimiento","Importe pagado","Activo"};

            CellStyle headerStyle = book.createCellStyle();
            /**
             * ***************************************************************
             */
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFPalette palette = hwb.getCustomPalette();
            // get the color which most closely matches the color you want to use
            HSSFColor myColor = palette.findSimilarColor(155, 0, 0);
            // get the palette index of that color 
            short palIndex = myColor.getIndex();
            /**
             * ****************************************************************
             */
            headerStyle.setFillForegroundColor(palIndex);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(4);

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs;

            //Connection conn = (Connection) con.conectar();
            int numFilaDatos = 5;

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);

            ps = Conexion.conectar().prepareStatement("SELECT pension.telefono,CONCAT(pension.nombre,' ',pension.apellidop,' ',pension.apellidom) as nombre_completo,pension.direccion,pension.identificacion,plan.tipo_plan,plan.precio,pension.cantidad_plan,CONCAT(pension.dia_inicio,' ',pension.hora_inicio) as di,CONCAT(pension.dia_vencimiento,' ',pension.hora_vencimiento) as df,pension.importe_pagado,pension.pagado FROM pension JOIN plan ON pension.id_plan=plan.id_plan WHERE pension.dia_inicio BETWEEN '"+fecha1+"' AND '"+fecha2+"'");
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);
                    CeldaDatos.setCellValue(rs.getString(a + 1));
                }

                //Cell celdaImporte = filaDatos.createCell(4);
                //celdaImporte.setCellStyle(datosEstilo);
                //celdaImporte.setCellFormula(String.format("C%d+D%d", numFilaDatos + 1, numFilaDatos + 1));
                numFilaDatos++;

            }

            for (int i = 0; i < numCol; i++) {
                sheet.autoSizeColumn(i);
            }
            sheet.setZoom(100);

            FileOutputStream fileOut = new FileOutputStream("C:\\FilesExportExcel\\" + Fecha55 + "ReporteEntradasYSalidasUCP.xlsx");
            nombreArchivoCreado = "C:\\FilesExportExcel\\" + Fecha55 + "ReporteEntradasYSalidasUCP.xlsx";
            book.write(fileOut);
            fileOut.close();
            JOptionPane.showMessageDialog(null, "Exportado");

        } catch (FileNotFoundException ex) {
            System.out.println("" + ex);
        } catch (IOException ex) {
            System.out.println("" + ex);
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
        //Vistas.Filtrar.jButton2.setText(nombreArchivoCreado);
        return nombreArchivoCreado;
    }

    
    public DefaultTableModel entradasSalidasPlan(JTable tabla, String fecha1, String fecha2) {
        PreparedStatement stmnt = null, stmnt2 = null;
        ResultSet rs = null, rs2 = null;
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("id");
        model.addColumn("Fecha");
        model.addColumn("Hora entrada");
        model.addColumn("Fechasalida");
        model.addColumn("Hora salida");
        model.addColumn("Tiempo");
        model.addColumn("Telefono");
        model.addColumn("Atendio");


        /*try {
            stmnt = Conexion.conectar().prepareStatement("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME = 'plan'");
            rs = stmnt.executeQuery();
            while (rs.next()) {
                //model.addRow(new Object[]{rs.getString("tipo_plan"), rs.getInt("duracion"), rs.getDouble("precio")});
                model.addColumn(rs.getString("COLUMN_NAME"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }*/
        try {
            stmnt2 = Conexion.conectar().prepareStatement("SELECT * from movimientos_pension WHERE fecha between '" + fecha1 + "' AND '" + fecha2 + "'");
            rs2 = stmnt2.executeQuery();
            while (rs2.next()) {
                //model.addRow(new Object[]{rs.getString("tipo_plan"), rs.getInt("duracion"), rs.getDouble("precio")});

                //model.addRow(new Object[]{rs2.getInt("id_tarifa"), rs2.getString("tipoVehiculo"), rs2.getString("tipo_tarifa"), rs2.getDouble("precio")});
                model.addRow(new Object[]{rs2.getInt("id_movimiento"),rs2.getString("fecha"),rs2.getString("hora_entrada"),rs2.getString("fecha_salida"),rs2.getString("hora_salida"),rs2.getString("tiempo"),rs2.getString("telefono"),rs2.getString("correo")});
            }
        } catch (SQLException ex) {
        }
        Conexion.cierraConexion();

        return model;
    }

    public String reporteEntradaSalidaPlan(String fecha1, String fecha2) {
        Date fecha = new Date();
        String nombreArchivoCreado = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String Fecha55 = sdf.format(fecha);

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Reporte");

        try {
            InputStream is = new FileInputStream("C:\\Multimedia\\iconoApp.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            is.close();

            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();

            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(0);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(2, 4);

            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);

            Row filaTitulo = sheet.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte entradas y salidas de usuarios con plan");

            sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));
            String[] cabecera = {"id","Fecha","Hora entrada","Fechasalida","Hora salida","Tiempo","Telefono","Atendio"};

            CellStyle headerStyle = book.createCellStyle();
            /**
             * ***************************************************************
             */
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFPalette palette = hwb.getCustomPalette();
            // get the color which most closely matches the color you want to use
            HSSFColor myColor = palette.findSimilarColor(155, 0, 0);
            // get the palette index of that color 
            short palIndex = myColor.getIndex();
            /**
             * ****************************************************************
             */
            headerStyle.setFillForegroundColor(palIndex);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(4);

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs;

            //Connection conn = (Connection) con.conectar();
            int numFilaDatos = 5;

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);

            ps = Conexion.conectar().prepareStatement("SELECT * from movimientos_pension WHERE fecha between '" + fecha1 + "' AND '" + fecha2 + "'");
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);
                    CeldaDatos.setCellValue(rs.getString(a + 1));
                }

                //Cell celdaImporte = filaDatos.createCell(4);
                //celdaImporte.setCellStyle(datosEstilo);
                //celdaImporte.setCellFormula(String.format("C%d+D%d", numFilaDatos + 1, numFilaDatos + 1));
                numFilaDatos++;

            }

            for (int i = 0; i < numCol; i++) {
                sheet.autoSizeColumn(i);
            }
            sheet.setZoom(100);

            FileOutputStream fileOut = new FileOutputStream("C:\\FilesExportExcel\\" + Fecha55 + "ReporteEntradasYSalidasUsuariosPlan.xlsx");
            nombreArchivoCreado = "C:\\FilesExportExcel\\" + Fecha55 + "ReporteEntradasYSalidasUsuariosPlan.xlsx";
            book.write(fileOut);
            fileOut.close();
            JOptionPane.showMessageDialog(null, "Exportado");

        } catch (FileNotFoundException ex) {
            System.out.println("" + ex);
        } catch (IOException ex) {
            System.out.println("" + ex);
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
        //Vistas.Filtrar.jButton2.setText(nombreArchivoCreado);
        return nombreArchivoCreado;
    }


    public void generarTicketSalida(String employeeName, String placa,String hora_salida,String tiempo_transcurrido,String din_gen) {

        //Double tarifa = getVehicleType(id_tarifaDB);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
         LocalDate todaysDate = LocalDate.now(); 
        String fechaHoy2 = todaysDate.toString();
        String fechaEntrada0 = null;
        String horaSalida0 = null;
        PreparedStatement stmnt = null;
        ResultSet rs = null;

        
        try {
            stmnt = Conexion.conectar().prepareStatement("SELECT fecha,hora_entrada from movimientos WHERE placas='"+placa+"' AND hora_salida IS NULL");
            rs = stmnt.executeQuery();
            while(rs.next()){
                fechaEntrada0 = rs.getString("fecha");
                horaSalida0 = rs.getString("hora_entrada");
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }
        
               
      
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
        line8 = new Paragraph("Ticket Salida");
        line9 = new Paragraph("Atendio: "+employeeName);
        line10 = new Paragraph("——————————–——————————–——————————–——————————–");
        line11 = new Paragraph("Entrada: "+fechaEntrada0+" "+horaSalida0);
        line12 = new Paragraph("Salida: "+fechaHoy2+" "+hora_salida);
        line13 = new Paragraph(tiempo_transcurrido+" importe pagado: $"+din_gen);
        line14 = new Paragraph(" Este ticket no es un comprobante fiscal ");
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
        try {
            Document doc = new Document();
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("C:\\tmp\\" + result2 + placa + "ticket.pdf"));
            doc.open();
            Barcode128 code = new Barcode128();
            code.setCode(placa);
            Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
            img.scalePercent(400);
            img.setAlignment(Element.ALIGN_CENTER);
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
        imprimirTicket(result2 + placa);

    }

}
