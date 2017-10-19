/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gudpick.trial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class GreetingsImplTest {
    
    GreetingsImpl instance;
    
    public GreetingsImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         instance = new GreetingsImpl();
         System.out.println("Inside @before");
    }
    
    @After
    public void tearDown() {
        System.out.println("Inside @after");
    }

    /**
     * Test of sayHello method, of class GreetingsImpl.
     */
    @Test
    public void testSayHello() {
        System.out.println("sayHello");
        String name = "Tom";
       
        String expResult = "Hello Tom";
        String result = instance.sayHello(name);
        assertEquals(expResult, result);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testSayHelloExceptionWhenNull(){
        System.out.println("Inside testSayHelloExceptionWhenNull");
        instance.sayHello(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSayHelloExceptionWhenBlank(){
        System.out.println("Inside testSayHelloExceptionWhenBlank");
        instance.sayHello("");
    }
}
