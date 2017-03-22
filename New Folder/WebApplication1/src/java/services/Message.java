package services;


import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c0121833
 */


//@Entity
//@NamedQueries({
//    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
//    @NamedQuery(name = "Message.findById", query = "SELECT m FROM Message m WHERE m.id = :id"),
//    @NamedQuery(name = "Message.findByTime", query = "SELECT m FROM Message m WHERE m.senttime = :senttime")
//})
public class Message implements Serializable{
    
    @Id
    private int id;
    private String title;
    private String contents;
    private String author;
    private String senttime;
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
    public Message() {
        
    }

    public Message(int id, String title, String contents, String author, String senttime) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.senttime = senttime;
    }
    
    public Message(JsonObject json) {
        id = json.getInt("id", 0);
        title = json.getString("title", "");
        contents = json.getString("contents", "");
        author = json.getString("author", "");
        senttime = json.getString("senttime", "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getSenttime() throws ParseException {
        
        Date senttime = df.parse(this.senttime);
        return senttime;
    }

    public void setSenttime(String senttime) {
        
        this.senttime = senttime;
    }
    
    
    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("id", id)
                .add("title", title)
                .add("contents", contents)
                .add("author", author)
                .add("senttime", senttime)
                .build();
    }
    
    
}
