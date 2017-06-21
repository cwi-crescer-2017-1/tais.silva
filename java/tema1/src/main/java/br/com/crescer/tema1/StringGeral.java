/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema1;

import java.text.Normalizer;

/**
 *
 * @author Taís
 */
public class StringGeral implements StringUtils {
    /*O método isEmpty deve validar se a string está nula e vazia.*/
    @Override
    public boolean isEmpty(String string){ 
        return string == null || string.trim().isEmpty();
    };
    /*O método inverter deve inverter uma string caso a mesma não estiver vazia, exemplo - carlos > solrac*/
    @Override
    public String inverter(String string){
        if(!isEmpty(string)){  
            StringBuffer stringInvertida = new StringBuffer(string.trim());
            stringInvertida.reverse();
            return stringInvertida.toString();
        }       
        return null;
    };
    /*O método contarVogais que conte o nº de vogais da String (a,e,i,o,u), exemplo - carlos > 2*/
    @Override
    public int contaVogais(String string){
        if(!string.isEmpty()){ 
            string = normalizarString(string);
            return string.length() - string.replaceAll("[aeiouAEIOU]", "").length();
        }                       
        return 0;
    };
    /* O método isPalindromo deve identificar se a string é um palíndromo, 
    ou seja se quando invertida ela tem os mesmos caracteres sem os espaços, 
    acentuação e case sensitive, exemplo - "ovo", "Ame a ema", "A sogra má e amargosa")*/
    @Override
    public boolean isPalindromo(String string){
        String stringLimpa = normalizarString(string);       
        return stringLimpa.equalsIgnoreCase(inverter(stringLimpa));
    };
    
    public static String normalizarString(String entrada) 
    {
        return Normalizer
                .normalize(entrada, Normalizer.Form.NFD)
		.replaceAll("[\\p{InCombiningDiacriticalMarks}\\W]", "");
    }
}
