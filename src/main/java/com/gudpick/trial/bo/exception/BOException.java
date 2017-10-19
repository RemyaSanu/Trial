/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gudpick.trial.bo.exception;

import java.sql.SQLException;

/**
 *
 * @author User
 */
public class BOException extends Exception{
    
    private static final long serialVersionUID=1L;
    public BOException(SQLException e){
        super(e);
    }
    
}
