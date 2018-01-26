/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francis.order.boundry;

import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Francis
 */
@Path("orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
   
    @Inject
    OrderFacade orderSB;
    
    @Inject
    EntityBuilder entityBuilder;
    
    @Context
    UriInfo uriInfo;
            
    @POST
    public Response createOrder( @Valid Order order){
        System.out.println(order);
        orderSB.create(order);
        URI orderUri = uriInfo.getBaseUriBuilder()
                .path(OrderResource.class)
                .path(OrderResource.class,"getOrder")
                .build(order.getId());
        return Response.created(orderUri).build();        
    }
                
    @GET
    public Response getOrders()
    {
        List<Order> orders = orderSB.findAll();
        JsonArray json = entityBuilder.buildOrders(orders,uriInfo);
        
        return Response.ok(json).build(); 
    }
        
    @GET
    @Path("{id}")    
    public Response getOrder(@PathParam("id") Long id){   
        Order order = orderSB.find(id);                
        JsonObject json = entityBuilder.buildOrder(order);                
        return Response.ok(json).build();
    } 
                  
    @GET
    @Path("types")
    public Response getTypes()
    {        
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(TicketType tt:TicketType.values())
            builder.add(tt.name().toLowerCase());
        
        return Response.ok(builder.build(), MediaType.APPLICATION_JSON).build();  
    }
    
    
                        
}
