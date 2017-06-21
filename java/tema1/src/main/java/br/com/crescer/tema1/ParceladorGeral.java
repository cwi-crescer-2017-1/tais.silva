/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tema1;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Taís
 */

public class ParceladorGeral implements Parcelador {
    /*O método calcular deve retornar um map com a data de vencimento (dd/MM/yyyy) da parcela e o valor (R$ .....).
    // Ex. valor: 1000  juros: 10%, parcelas: 10  data: 30/06/2016
    1. 30/06/2016 - R$ 110,00
    2. 31/07/2016 - R$ 110,00
    3. 30/08/2016 - R$ 110,00 ...
    */
    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento){
        SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
        Map map = new HashMap();        
        Double parcelaComJuros = valorParcelar.doubleValue() + (valorParcelar.doubleValue() * (taxaJuros / 100)) / numeroParcelas;
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataPrimeiroVencimento);
        
        int i = 0;
        while( i < numeroParcelas) {
            i++;      
            map.put(FORMAT.format(calendar.getTime()), parcelaComJuros);
            calendar.add(Calendar.MONTH, 1);
        }
        return map;
    };   
}
