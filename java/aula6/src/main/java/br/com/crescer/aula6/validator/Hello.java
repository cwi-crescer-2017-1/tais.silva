/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula6.validator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author tais.silva
 */
@ManagedBean
@ViewScoped
public class Hello {

    private String helloWorld = "Hello World!";

    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

}