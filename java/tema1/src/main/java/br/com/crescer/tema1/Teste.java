/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema1;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Taís
 */
public class Teste {
    public static void main(String[] args) {
//        System.out.println("retorno" + new ParceladorGeral().calcular(new BigDecimal(1000), 10, 10, new Date()));
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        Date dataAtual = new Date(); 
        long diferenca = dataAtual.getTime() - date.getTime();
        calendar.setTime(new Date(diferenca));
//        calendar.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, 0, 0, 0);
            
        int anos = calendar.get(Calendar.YEAR) - 1970;
        int meses = calendar.get(Calendar.MONTH);
        int dias = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println(calendar.getTime()); 
    }        
}
