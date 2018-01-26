/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francis.order.boundry;

import com.francis.order.PrimaryKeyGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 *
 * @author Francis Marti
 */

//@Stateless //normaly this would be stateless and where all the JPA calls are made
@Singleton 
public class OrderFacade {
    
    @Inject 
    PrimaryKeyGenerator primaryKeyGenerator;
    
    private Map<Long,Order> map = new HashMap();
                
    public void create(Order order){                            
        long pk = primaryKeyGenerator.generateNextKey();        
        order.setId(pk);
        map.put(pk, order);
    }
    
    public Order find(Long id){
        return map.get(id);
    }
    
    public List<Order> findAll(){
        return map.values().stream().collect(Collectors.toList());
    }
    
    
}
