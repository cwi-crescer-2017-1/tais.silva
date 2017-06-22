/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taís
 */
public class WriterUtilsImpl implements WriterUtils {
    /* O método write recebe o nome do arquivo e o conteúdo que deve ser gravado.
    O arquivo deve ser apenas do tipo .txt, caso contrário exibir lançar um exception.
    Caso não localize-o, então deve lançar um exception.*/

    @Override
    public void write(String file, String conteudo){
        try (final FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);){
            if(file.contains(".txt")){  
                bufferedWriter.append(conteudo);
                bufferedWriter.newLine();
                bufferedWriter.flush();
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
        }   catch (IOException ex) {
            Logger.getLogger(WriterUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
