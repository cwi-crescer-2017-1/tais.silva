/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema1;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Taís
 */
public class Teste {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            Calendar hoje = Calendar.getInstance();
            hoje.setTime(new Date());
            
            Calendar dataFornecida = Calendar.getInstance();
            
            dataFornecida.setTime(hoje.getTime()); 
            dataFornecida.add(Calendar.MONTH, -5);
            
            Date hoj = hoje.getTime();
            Date dataF = dataFornecida.getTime();
            
            Calendar calendar = Calendar.getInstance();
            Date dataAtual = new Date(); 
            long diferenca = dataAtual.getTime() - dataF.getTime();
            calendar.setTime(new Date(diferenca));
            
            int a = calendar.get(Calendar.YEAR) - 1970;
            int m = calendar.get(Calendar.MONTH);
            int d = calendar.get(Calendar.DAY_OF_MONTH);
            
            System.out.println("return" + a + "m" + m +"d"+ d);
        } catch (Exception e) {
            //...
        }
    }    
    
}
