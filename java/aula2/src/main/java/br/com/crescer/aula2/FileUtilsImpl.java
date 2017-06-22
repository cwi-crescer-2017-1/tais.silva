/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taís
 */
public class FileUtilsImpl implements FileUtils {
    /* O método mk deve criar um arquivo ou diretório. */
    @Override
    public boolean mk(String string){     
        try {
            if (string.length() > 3) {
                if (string.substring(string.length() - 4).contains(".")) {
                    return new File(string).createNewFile();                    
                } else {
                    return new File(string).mkdirs();
                }
            }            
        } catch (IOException ex) {
            Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    };
    /* O método rm deve excluir o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido. */
    @Override
    public boolean rm(String string){
        final File file = new File(string);
        if (file.isFile()) {
          return file.delete();
        } 
        if (file.isDirectory()) {
            try {
                throw new Exception("Arquivo é inválido!");
            } catch (Exception ex) {
                Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        return false;
    };
    /* O método ls deve mostra o caminho absoluto, se for um diretório listar o nome dos arquivos internos. */
    @Override
    public String ls(String string){
        final File file = new File(string);
        if(file.isDirectory()){            
            String nomes = "";
            for(File nome : file.listFiles()){
                nomes += nome.getName() + "\n";
            }            
            return nomes;
        }        
        return new File(string).getAbsolutePath();
    };
    /* O método mv deve mover o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido. */
    @Override
    public boolean mv(String in, String out){      
        final File fileIn = new File(in);
        final File fileOut = new File(out);
        
        if (fileIn.isFile()) {
          return fileIn.renameTo(fileOut);
        } 
        if (fileIn.isDirectory()) {
            try {
                throw new Exception("Arquivo é inválido!");
            } catch (Exception ex) {
                Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        return false;       
    };    
}
