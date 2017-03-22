/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

/**
 *
 * @author c0121833
 */
@ApplicationScoped
public class MessageController {

    private List<Message> messageList = new ArrayList<>();
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");

    public void add(Message m) {
        messageList.add(m);
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public MessageController() {
        if (messageList == null) {
            messageList = new ArrayList<>();
        }
    }

    public JsonArray getByDateJson(Date from, Date to) throws ParseException {
        JsonArrayBuilder json = Json.createArrayBuilder();
        for (Message m : messageList) {
            if ((m.getSenttime().after(from) && m.getSenttime().before(to))) {
                json.add (m.toJson());
            }
        }
        return json.build();
    }

    


    
    
    
}
