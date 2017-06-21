/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Taís
 */
public class CalendarGeral implements CalendarUtils {
    /*O método diaSemana recebe uma data e devolve o dia da semana conforme enum.*/
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
        Calendar calendar = Calendar.getInstance();
        Date dataAtual = new Date(); 
        long diferenca = dataAtual.getTime() - date.getTime();
        calendar.setTime(new Date(diferenca));
            
        int anos = calendar.get(Calendar.YEAR) - 1970;
        int meses = calendar.get(Calendar.MONTH);
        int dias = calendar.get(Calendar.DAY_OF_MONTH);

        return (anos + "anos(s), " + meses + " mes(es) e " + dias + " dia(s)");
    };
}
    