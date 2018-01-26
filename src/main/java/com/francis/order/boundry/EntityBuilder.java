package com.francis.order.boundry;

import java.net.URI;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Francis Marti
 */
public class EntityBuilder {
     
    
    public JsonArray buildOrders(List<Order> orders,UriInfo uriInfo)
    {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Order o:orders){                     
            
             URI orderUri = uriInfo.getBaseUriBuilder()
                .path(OrderResource.class)
                .path(OrderResource.class,"getOrder")
                .build(o.getId());
             
             builder.add(
                     Json.createObjectBuilder()
                        .add("order",buildOrder(o))
                        .add("link",orderUri.toString())
                        .build()                                                                    
             );            
        }                
        return  builder.build();             
    }
    
    
    public JsonObject buildOrder(Order o){                
        return Json.createObjectBuilder()
                .add("id",o.getId())
                .add("firstname",o.getFirstname())
                .add("lastname",o.getLastname())
                .add("email",o.getEmail())
                .add("city",o.getCity())
                .add("state",o.getState())
                .add("zip",o.getZip())
                .add("ticket_type",o.getTicketType().toLowerCase())
                .add("card",maskCard(o.getCard()))
                .add("exp",o.getExpiration())
                .build();
    }
    
                  
    private String maskCard(String card){
        
        StringBuilder sb= new StringBuilder();
        int len = card.length()-4;
        for(int i=0;i<len;i++)
            sb.append('*');
        for(int i=len;i<len+4;i++)
            sb.append(card.charAt(i));
        return sb.toString();
    }
}
