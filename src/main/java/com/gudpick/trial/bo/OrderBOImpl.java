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


public class OrderBOImpl implements OrderBO {

    private OrderDAO orderDAO;
    
    @Override
    public boolean placeOrder(Order1 order1) throws BOException {
        try{
            int result = orderDAO.create(order1);
            if(result==0)
                return false;            
        }
        catch(SQLException e){
            throw new BOException(e);
        }
        return true;
    }

    @Override
    public boolean cancelOrder(int id) throws BOException {
        try{
            Order1 order1 = orderDAO.read(id);
            order1.setStatus("Cancelled");
            int result = orderDAO.update(order1);
            if(result==0)
                return false;
        }
        catch(SQLException e){
            throw new BOException(e);
        }
        return true;
    }

    @Override
    public boolean deleteOrder(int id) throws BOException {
        try{
            int result = orderDAO.delete(id);
            if(result==0)
                return false;
        }
        catch(SQLException e){
            throw new BOException(e);
        }
        return true;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
    
}
