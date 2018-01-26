/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francis.order;


import com.francis.order.boundry.Order;
import com.francis.order.boundry.OrderBuilder;
import com.francis.order.boundry.OrderFacade;
import com.francis.order.boundry.TicketType;
import com.github.javafaker.Faker;
import java.util.Random;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Francis Marti
 */
@Singleton
@Startup
public class PopulateDatabase {

    private static final Logger LOG = Logger.getLogger(PopulateDatabase.class.getName());
        
    @Inject
    OrderFacade orderSB;

    
    private Random rnd = new Random();
    
    @PostConstruct
    public void init(){        
        rnd.setSeed(System.currentTimeMillis());        
        if(orderSB.findAll().size()==0){
            LOG.info("Populating in memory database/map with orders");
            
            for(int i=0;i<10;i++){
                Order order = buildOrder();
                orderSB.create(order);
                LOG.info("Order.id = "+order.getId() +" created");
            }            
        }                
    }
        
    
    private OrderBuilder builder = new OrderBuilder();
    
    private Order buildOrder(){
        Faker faker = Faker.instance();

        String rndTicketType = rndTicketType();
       return builder
            .setFirstname(faker.name().firstName())
            .setLastname(faker.name().lastName())
            .setEmail(faker.internet().emailAddress())            
            .setAddress(faker.address().streetAddress())
            .setCity(faker.address().city())
            .setState(faker.address().stateAbbr())
            .setZip(faker.address().zipCode())               
            .setTicketType(rndTicketType)
            .setCard(faker.finance().creditCard())
            .setExpiration("12/25")
               
            .createOrder();                              
    }
    
    private String rndTicketType()
    {        
        int size = TicketType.values().length;
        int index = rnd.nextInt(size);        
        return TicketType.values()[index].name();
    }

    private void OrderBuilder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
   
    
}
