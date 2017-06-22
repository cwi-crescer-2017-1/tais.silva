/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema1;

import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;

/**
 *
 * @author Taís
 */
public class CalendarGeral implements CalendarUtils {
    /*O método diaSemana recebe uma data e devolve o dia da semana conforme enum.*/
    private static final Calendar CALENDAR = Calendar.getInstance();
    
    @Override
    public DiaSemana diaSemana(Date date){        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);        
        return DiaSemana.values()[diaSemana-1];
    };
    /*O método tempoDecorrido recebe uma data e devolve o tempo decorrido até a data atual no formato 30 ano(s), 3 mes(es) e 12 dia(s)*/
    @Override
    public String tempoDecorrido(Date date){
        CALENDAR.setTime(new Date(this.getHoraZero(new Date()).getTime() - this.getHoraZero(date).getTime()));    
            
        int anos = CALENDAR.get(Calendar.YEAR) - 1970;
        int meses = CALENDAR.get(Calendar.MONTH);
        int dias = CALENDAR.get(Calendar.DAY_OF_MONTH);

        return (anos + " ano(s), " + meses + " mes(es) e " + dias + " dia(s)");
    };
    
    private Date getHoraZero(Date date) {
        CALENDAR.setTime(date);
        CALENDAR.set(CALENDAR.get(YEAR), CALENDAR.get(MONTH), CALENDAR.get(DAY_OF_MONTH), 0, 0, 0);
        return CALENDAR.getTime();
    }
}
    