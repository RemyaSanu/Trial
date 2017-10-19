/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gudpick.trial;


public class GreetingsImpl implements Greetings {

    @Override
    public String sayHello(String name) {
        if(name==null || name.length()==0)
            throw new IllegalArgumentException();
        return "Hello "+name;
    }
    
}
