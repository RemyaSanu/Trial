/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gudpick.trial.dao;

import com.gudpick.trial.entity.Order1;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public interface OrderDAO {
        int create(Order1 order1) throws SQLException;
        Order1 read(int id) throws SQLException;
        int update(Order1 order1) throws SQLException;
        int delete(int id) throws SQLException;
    
}
