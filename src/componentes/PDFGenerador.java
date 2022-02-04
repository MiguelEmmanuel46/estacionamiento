/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author soporte
 */
public class PDFGenerador {
    
     public static void generarPDF(String pathImagen) {
        Document documento = new Document();
        String escritorio = System.getProperty("user.home") + "/Desktop/miPDF.pdf";
        FileOutputStream fos;
        Image imagen;
        try {
            fos = new FileOutputStream(escritorio);

            PdfWriter pdfW = PdfWriter.getInstance(documento, fos);
            pdfW.setInitialLeading(20);

            documento.open();
            imagen = Image.getInstance(pathImagen);
            documento.add(imagen);

            documento.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
    
}
