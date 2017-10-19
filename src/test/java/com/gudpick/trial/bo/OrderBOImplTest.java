/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gudpick.trial.bo;

import com.gudpick.trial.bo.exception.BOException;
import com.gudpick.trial.dao.OrderDAO;
import com.gudpick.trial.entity.Order1;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

/**
 *
 * @author User
 */
public class OrderBOImplTest {
    
    @Mock
    OrderDAO orderDAO;        
    
    OrderBOImpl instance;
    
    public OrderBOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        instance = new OrderBOImpl();
        instance.setOrderDAO(orderDAO);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of placeOrder method, of class OrderBOImpl.
     */
    @Test
    public void testPlaceOrderReturnTrue() throws SQLException,BOException {
        System.out.println("placeOrder");
        Order1 order1 = new Order1();
        Mockito.when(orderDAO.create(order1)).thenReturn(new Integer(1));
        boolean expResult = true;
        boolean result = instance.placeOrder(order1);
        assertEquals(expResult, result);
        Mockito.verify(orderDAO).create(order1);

    }
    
    @Test
    public void testPlaceOrderReturnFalse() throws SQLException,BOException {
        System.out.println("testPlaceOrderReturnFalse");
        Order1 order1 = new Order1();
        Mockito.when(orderDAO.create(order1)).thenReturn(new Integer(0));
        boolean expResult = false;
        boolean result = instance.placeOrder(order1);
        assertEquals(expResult, result);
        Mockito.verify(orderDAO).create(order1);

    }
    @Test(expected=BOException.class)
    public void testPlaceOrderThrowBOException() throws SQLException,BOException {
        System.out.println("testPlaceOrderThrowBOException");
        Order1 order1 = new Order1();
        Mockito.when(orderDAO.create(order1)).thenThrow(SQLException.class);
        boolean result = instance.placeOrder(order1);
       
    }
    /**
     * Test of cancelOrder method, of class OrderBOImpl.
     */
    @Test
    public void testCancelOrderReturnTrue() throws SQLException,BOException {
        System.out.println("testCancelOrderReturnTrue");
        int id = 0;
        Order1 order1 = new Order1();
        Mockito.when(orderDAO.read(id)).thenReturn(order1);
        when(orderDAO.update(order1)).thenReturn(new Integer(1));
        boolean expResult = true;
        boolean result = instance.cancelOrder(id);
        assertEquals(expResult, result);
        verify(orderDAO).read(id);
        verify(orderDAO).update(order1);
        
    }
    
    @Test
    public void testCancelOrderReturnFalse() throws SQLException,BOException {
        System.out.println("testCancelOrderReturnFalse");
        int id = 0;
        Order1 order1 = new Order1();
        Mockito.when(orderDAO.read(id)).thenReturn(order1);
        when(orderDAO.update(order1)).thenReturn(new Integer(0));
        boolean expResult = false;
        boolean result = instance.cancelOrder(id);
        assertEquals(expResult, result);
        verify(orderDAO).read(id);
        verify(orderDAO).update(order1);
        
    }
    
   @Test(expected=BOException.class)
    public void testCancelOrderThrowExceptionOnRead() throws SQLException,BOException {
        System.out.println("testCancelOrderThrowExceptionOnRead");
        int id = 0;
        Order1 order1 = new Order1();
        Mockito.when(orderDAO.read(id)).thenThrow(SQLException.class);
        
        boolean result = instance.cancelOrder(id);
    }
    
    @Test(expected=BOException.class)
    public void testCancelOrderThrowExceptionOnUpdate() throws SQLException,BOException {
        System.out.println("testCancelOrderThrowException");
        int id = 0;
        Order1 order1 = new Order1();
        Mockito.when(orderDAO.read(id)).thenReturn(order1);
        when(orderDAO.update(order1)).thenThrow(SQLException.class);
        
        boolean result = instance.cancelOrder(id);
        verify(orderDAO).read(id);
    }

    /**
     * Test of deleteOrder method, of class OrderBOImpl.
     */
    @Test
    public void testDeleteOrderReturnTrue() throws SQLException, BOException {
        System.out.println("deleteOrder");
        int id = 0;
        when(orderDAO.delete(id)).thenReturn(new Integer(1));
        boolean expResult = true;
        boolean result = instance.deleteOrder(id);
        assertEquals(expResult, result);
        verify(orderDAO).delete(id);
    }
    @Test
    public void testDeleteOrderReturnFalse() throws SQLException, BOException {
        System.out.println("testDeleteOrderReturnFalse");
        int id = 0;
        when(orderDAO.delete(id)).thenReturn(new Integer(0));
        boolean expResult = false;
        boolean result = instance.deleteOrder(id);
        assertEquals(expResult, result);
        verify(orderDAO).delete(id);
    }
    @Test(expected=BOException.class)
    public void testDeleteOrderThrowException() throws SQLException, BOException {
        System.out.println("testDeleteOrderThrowException");
        int id = 0;
        when(orderDAO.delete(id)).thenThrow(SQLException.class);
        boolean result = instance.deleteOrder(id);
        
    }
}
