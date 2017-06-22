/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taís
 */
public class ReaderUtilsImpl implements ReaderUtils {
    /* O método read receba o nome do arquivo e exiba seu conteúdo.
    O arquivo deve ser apenas do tipo .txt, caso contrário exibir lançar um exception.
    Caso não localize-o, então deve lançar um exception.*/
    
    @Override
    public String read(String string){        
        try {
            if(string.contains(".txt")){
                final Reader reader = new FileReader(string);
                final BufferedReader bufferReader = new BufferedReader(reader);
                String readLine = bufferReader.readLine();
                while (!readLine.isEmpty()) {                    
                    readLine += readLine;                
                }
                return readLine;
            }else {
                try {
                    throw new Exception("Arquivo Inválido!");
                } catch (Exception ex) {
                    Logger.getLogger(ReaderUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException e) {
                try {
                    throw new Exception("Arquivo não encontrado!");
                } catch (Exception ex) {
                    Logger.getLogger(ReaderUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (IOException ex) {
            Logger.getLogger(ReaderUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    };
}
