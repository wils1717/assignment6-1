package messages;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c0121833
 */
@Path("/message")
@ApplicationScoped
public class MessageService {
    @Inject
    private MessageController messageList;
    

    
    
    @GET
    @Produces("application/json")
    public JsonArray getAll() {
        JsonArrayBuilder json = Json.createArrayBuilder();
        
        for (Message m : messageList.getMessageList()) {
            json.add(m.toJSON());
        }
                return json.build();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") int id) {
        Message m = (Message) getSingleResult();
        return Response.ok(m.toJSON().toString()).build();
    }
    
}
