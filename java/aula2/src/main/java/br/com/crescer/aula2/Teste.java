/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2;

/**
 *
 * @author Taís
 */
public class Teste {
    public static void main(String[] args) {
        String novo = new ReaderUtilsImpl().read("olu.txt");
        System.out.println(novo);
    }
}
