/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author tais.silva
 */
public class Inicial {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println("Informe a data:");
            
            SimpleDateFormat dataFornecida;
            dataFornecida = new SimpleDateFormat("dd/MM/yyyy");
            Date data = dataFornecida.parse(scanner.nextLine());
            
            System.out.println("Informe os dias:");
            int extra = scanner.nextInt();
            
            Calendar calendar = Calendar.getInstance();            
            calendar.setTime(data);
            calendar.add(Calendar.DAY_OF_YEAR, extra);       
            
            System.out.println("Data com dias extras:" + calendar);
        } catch (Exception e) {
            //...
        }
    }    
}
