/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.mapeamento;

import br.com.crescer.aula3.ConnectionUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tais.silva
 */
public class SQLUtilsImpl implements SQLUtils {
    
    // Deve possuir um metodo que execute as instruções contidas dentro de um arquivo, o mesmo tem que ser um ".sql".
    @Override
    public void runFile(String filename) { 
        try (final Statement statement = ConnectionUtils.getConnection().createStatement()){
            if(filename.contains(".sql")){
                final Reader reader = new FileReader(filename);
                final BufferedReader bufferReader = new BufferedReader(reader);
                String readLine = bufferReader.readLine();  
                ArrayList<String> lista = new ArrayList<String>();
                int contador = 0;
                
                while (!readLine.isEmpty()) { 
                    if (readLine.contains(";")){
                        readLine = readLine.replaceAll(";", "");
                        lista.add(readLine);
                        contador ++;
                    }            
                    readLine += readLine;
                }
                
                for(int i = 0; i < contador; i++){
                    statement.executeQuery(lista.get(i));
                }
                
                System.out.println("readLine");
            }else {
                try {
                    throw new Exception("Arquivo Inválido!");
                } catch (Exception ex) {
                    Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } catch (FileNotFoundException e) {          
            try {
                throw new Exception("Arquivo não encontrado!");
            } catch (Exception ex) {
                Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
            }               
        } catch (IOException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Deve receber uma instrução sql (query) e retorna um tabela com o nome das colunas e linhas.
    @Override
    public String executeQuery(String query) {
        StringBuilder retorno = new StringBuilder();
        try (final Statement statement = ConnectionUtils.getConnection().createStatement()) {            
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData dadosColuna = resultSet.getMetaData();
            int contadorColunas = dadosColuna.getColumnCount();
            
            while(resultSet.next()){                
                for(int i = 0; i < contadorColunas; i++) {
                    retorno.append(resultSet.getString(i+1)).append(" "); 
                }
                retorno.append("\n");                
            } 
            
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return retorno.toString();
    }
    // Deve possuir um metodo onde possa ser importado um arquivo ".csv".
    @Override
    public void importCSV(File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public File importCSV(String query) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
