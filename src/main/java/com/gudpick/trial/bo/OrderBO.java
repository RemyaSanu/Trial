/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gudpick.trial.bo;

import com.gudpick.trial.bo.exception.BOException;
import com.gudpick.trial.entity.Order1;

/**
 *
 * @author User
 */
public interface OrderBO {
    
    boolean placeOrder(Order1 order1) throws BOException;
    boolean cancelOrder(int id) throws BOException;
    boolean deleteOrder(int id) throws BOException;

    
}
