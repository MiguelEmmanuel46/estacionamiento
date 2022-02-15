/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.TimerTask;
/**
 *
 * @author Soporte
 */
public class Temporizador extends TimerTask{
Metodos metodos = new Metodos();    
    LocalDate todaysDate = LocalDate.now();
    String fechaTO2 = todaysDate.toString();
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
    String horaTO2 = formateador.format(LocalDateTime.now());

    @Override
    public void run() {
        Calendar diaActual = Calendar.getInstance();
        
        switch (diaActual.get(Calendar.DAY_OF_WEEK)) {
            case 1: // Es domingo puedes seguir durmiendo y se apaga el despertador
                String[] popo1 = metodos.calcularTiempoRestanteParaPlanUpdateTable(fechaTO2,horaTO2);
                break;
            case 2: // Durante los dias de diario suena el despertador
                String[] popo2 = metodos.calcularTiempoRestanteParaPlanUpdateTable(fechaTO2,horaTO2);
                break;
            case 3:
                String[] popo3 = metodos.calcularTiempoRestanteParaPlanUpdateTable(fechaTO2,horaTO2);
                break;
            case 4:
                String[] popo4 = metodos.calcularTiempoRestanteParaPlanUpdateTable(fechaTO2,horaTO2);
                break;
            case 5:
                String[] popo5 = metodos.calcularTiempoRestanteParaPlanUpdateTable(fechaTO2,horaTO2);
                break;
            case 6:
                String[] popo6 = metodos.calcularTiempoRestanteParaPlanUpdateTable(fechaTO2,horaTO2);
                break;
            case 7: // Es sabado puedes seguir durmiendo
                String[] popo7 = metodos.calcularTiempoRestanteParaPlanUpdateTable(fechaTO2,horaTO2);
                break;
        }
    }
    
}
