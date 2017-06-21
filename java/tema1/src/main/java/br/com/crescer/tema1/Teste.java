/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema1;

import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author Taís
 */
public class Teste {
    public static void main(String[] args) {
        System.out.println("retorno" + new ParceladorGeral().calcular(new BigDecimal(1000), 10, 10, new Date()));
    }        
}
