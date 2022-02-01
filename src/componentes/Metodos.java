package componentes;

import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    
    public void imprimirFactura(){

        PrinterMatrix printer = new PrinterMatrix();

        Extenso e = new Extenso();

        e.setNumber(101.85);


        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        printer.setOutSize(60, 80);
        //Imprimir * de la 2da linea a 25 en la columna 1;
       // printer.printCharAtLin(2, 25, 1, "*");
        //Imprimir * 1ra linea de la columa de 1 a 80
       printer.printCharAtCol(1, 1, 80, "=");
        //Imprimir Encabezado nombre del La EMpresa
       printer.printTextWrap(1, 2, 30, 80, "FACTURA DE VENTA");
       //printer.printTextWrap(linI, linE, colI, colE, null);
       printer.printTextWrap(2, 3, 1, 22, "Num. Boleta : " + "2013");
       printer.printTextWrap(2, 3, 25, 55, "Fecha de Emision: " + "2022-31-01");
       printer.printTextWrap(2, 3, 60, 80, "Hora: 12:22:51");
       printer.printTextWrap(3, 3, 1, 80, "Vendedor.  : "+ "100" +" - " + "Bloop");
       printer.printTextWrap(4, 4, 1, 80, "CLIENTE: " + "Sin nonmbre");
       printer.printTextWrap(5, 5, 1, 80, "RUC/CI.: " + "100");
       printer.printTextWrap(6, 6, 1, 80, "DIRECCION: " + "");
       printer.printCharAtCol(7, 1, 80, "=");
       printer.printTextWrap(7, 8, 1, 80, "Codigo          Descripcion                Cant.      P  P.Unit.      P.Total");
       printer.printCharAtCol(9, 1, 80, "-");
       int filas = 1;

        for (int i = 0; i < filas; i++) {
         printer.printTextWrap(9 + i, 10, 1, 80, "20"+"|"+"21"+"| "+"22"+"| "+"23"+"|"+ "24");
         }

        if(filas > 15){
        printer.printCharAtCol(filas + 1, 1, 80, "=");
        printer.printTextWrap(filas + 1, filas + 2, 1, 80, "TOTAL A PAGAR " + "200");
        printer.printCharAtCol(filas + 2, 1, 80, "=");
        printer.printTextWrap(filas + 2, filas + 3, 1, 80, "Esta boleta no tiene valor fiscal, solo para uso interno.: + Descripciones........");
        }else{
        printer.printCharAtCol(25, 1, 80, "=");
        printer.printTextWrap(26, 26, 1, 80, "TOTAL A PAGAR " + "232");
        printer.printCharAtCol(27, 1, 80, "=");
        printer.printTextWrap(27, 28, 1, 80, "Esta boleta no tiene valor fiscal, solo para uso interno.: + Descripciones........");

        }
        printer.toFile("impresion.txt");

      FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("impresion.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        if (inputStream == null) {
            return;
        }

        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);

        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();


        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }

        //inputStream.close();

    }
    
    
    public void imprimirTicket(String subTotal, String total, String dineroR, String devolucion){
        try {
            String placa="TUE4032";
            Long datetime = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(datetime);

            PrinterMatrix printer = new PrinterMatrix();
            Extenso e = new Extenso();

            e.setNumber(20.30);
            //Definir el tamanho del papel para la impresion de dinamico y 32 columnas
            int filas = 2;
            int tamaño = filas+40;
            printer.setOutSize(tamaño, 80);

            //Imprimir = 1ra linea de la columa de 1 a 32
            printer.printTextWrap(0, 1, 5, 80, "===================================================================");
            printer.printTextWrap(1, 1, 31, 80, "Estacionamiento Aries"); //Nombre establecimiento
            printer.printTextWrap(2, 1, 35, 80, "Av 6 Ote 406"); //Barrio
            printer.printTextWrap(3, 1, 28, 80, "Centro histórico de Puebla."); //Direccion
            printer.printTextWrap(4, 1, 35, 80, "72000 Puebla, Pue."); //Codigo Postal
            printer.printTextWrap(6, 1, 10, 41, ""); //Aqui va la fecha de recibo
            printer.printTextWrap(6, 1, 38, 80, ""); //Aqui va la hora de recibo
            //printer.printTextWrap(7, 1, 3, 80, "Numero"); //Numero del recibo - FACTURA O PEDIDO
            printer.printTextWrap(7, 1, 20, 80, "Atendio: Miguel Emmanuel Montiel Martinez"); //Nombre Cajero
            printer.printTextWrap(8, 1, 3, 80, "");//Nombre del Cliente
            printer.printTextWrap(9,1, 5, 80, "——————————–——————————–——————————–——————————–——–———–——–—–———–——–———");
            printer.printTextWrap(10,1, 36, 80, placa);
            printer.printTextWrap(11,1, 34, 80, " 2022-31-01");
            printer.printTextWrap(12,1, 35, 80, " 12:05:00");
            printer.printTextWrap(13,1, 20, 80, " Tarifa por hora o fraccion, sin tolerancia: $15 ");
            printer.printTextWrap(14,1, 26, 80, " Costo por boleto perdido $100 ");
            

           /* for (int i = 0; i < filas; i++) {
                int p = 13+i; //Fila

                printer.printTextWrap(p , 1, 7, 19 , jtbl_venta.getValueAt(i,0).toString());
                printer.printTextWrap(p , 1, 12, 42 , jtbl_venta.getValueAt(i,1).toString());
                printer.printTextWrap(p , 1, 47, 49, jtbl_venta.getValueAt(i,2).toString());

                String pre= printer.alinharADireita(10, jtbl_venta.getValueAt(i,3).toString());
                printer.printTextWrap(p , 1, 57, 80, pre);

                //String inp= printer.alinharADireita(7,punto_Venta.jtbl_venta.getValueAt(i,6).toString());
                //printer.printTextWrap(p , 1, 25, 32, inp);
            
            }*/
            /*************************************************************************************************************************************/
           /* printer.printTextWrap(14, 1, 7, 19, "popo");
            printer.printTextWrap(15, 1,12, 42, "popo2");
            printer.printTextWrap(16, 1, 47, 49, "popo3");

            String pre = printer.alinharADireita(10, "popo4");
            printer.printTextWrap(17, 1, 57, 80, pre);

                //String inp= printer.alinharADireita(7,punto_Venta.jtbl_venta.getValueAt(i,6).toString());
            //printer.printTextWrap(p , 1, 25, 32, inp);
            /**/////////////////////////////////////////////////////////////////////////////////////////////////**********************************/
           /* DecimalFormat formateador = new DecimalFormat("#.###");

            String sub= printer.alinharADireita(10, subTotal);
            printer.printTextWrap(filas+17, 1, 5, 80, "Subtotal: ");
            printer.printTextWrap(filas+17, 1, 20, 80, "$"+sub);

            String tot= printer.alinharADireita(10, total);
            printer.printTextWrap(filas+18, 1, 5, 80, "Total a pagar: ");
            printer.printTextWrap(filas+18, 1, 20, 80, "$"+tot);

            String efe= printer.alinharADireita(10,dineroR);
            printer.printTextWrap(filas+19, 1, 5, 80, "Efectivo : ");
            printer.printTextWrap(filas+19, 1, 20, 80, "$"+efe);

            String cam= printer.alinharADireita(10,devolucion);
            printer.printTextWrap(filas+20, 1, 5, 80, "Cambio : ");
            printer.printTextWrap(filas+20, 1, 20, 80, "$"+ cam);*/

            printer.printTextWrap(filas+14, 1, 5, 80, "——————————–——————————–——————————–——————————–——–———–——–—–———–——–———");
            printer.printTextWrap(filas+15, 1, 26,80, "!Gracias por su preferencia!");
            printer.printTextWrap(filas+16, 1, 30, 80, "WorkIt App - v1.0.0");
            printer.printTextWrap(filas+17, 1, 31, 80, "Sombra DW");
            printer.printTextWrap(filas+18, 1, 25, 80, "Contacto: sombrass46@gmail.com");
            printer.printTextWrap(filas+19, 1, 5,80, "===================================================================");

            String hor = String.valueOf(timestamp);
           
            String result = hor.replaceAll("\\p{Punct}", "");
            
            ///CREAR ARCHIVO EN CARPETA DEL PROYECTO PARA PEDIDOS
            printer.toFile("C:\\tmp\\"+result+"impresion.txt");
            FileInputStream inputStream = null;

            try {
                inputStream = new FileInputStream("C:\\tmp\\impresion.txt");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
            if (inputStream == null) {
                return;
            }

            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc document = new SimpleDoc(inputStream, docFormat, null);
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

            if (defaultPrintService != null) {
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                try {
                    printJob.print(document, attributeSet);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                System.err.println("No existen impresoras instaladas");
            }

            inputStream.close();
            //imprimirFin(subTotal, total, dineroR, devolucion); //ESTE METODO NO SE UTILIZARA

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al imprimir "+e);
            }
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
}
