/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gudpick.trial.dao;

import com.gudpick.trial.entity.Order1;
import java.sql.SQLException;


public class OrderDAOImpl implements OrderDAO {

    @Override
    public int create(Order1 order1) throws SQLException {
        return 0;
    }

    @Override
    public Order1 read(int id) throws SQLException {
        return null;
    }

    @Override
    public int update(Order1 order1) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }
    
}
