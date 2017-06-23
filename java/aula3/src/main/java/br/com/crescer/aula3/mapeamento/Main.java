/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.mapeamento;

/**
 *
 * @author tais.silva
 */
public class Main {
    
    public static void main(String[] args) {
        SQLUtilsImpl runFile = new SQLUtilsImpl();
        runFile.runFile("teste.sql"); 
        
        SQLUtilsImpl execute = new SQLUtilsImpl();
        System.out.println(execute.executeQuery("SELECT * FROM CIDADE WHERE ID = 1197 or ID = 1198"));   
    }
    
}
