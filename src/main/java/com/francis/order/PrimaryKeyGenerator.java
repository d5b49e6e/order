/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francis.order;

import javax.ejb.Singleton;

/**
 *
 * @author Francis Marti
 */
@Singleton
public class PrimaryKeyGenerator {
    private long id=0;
    
    public long generateNextKey(){
        return ++id;
    }
}
