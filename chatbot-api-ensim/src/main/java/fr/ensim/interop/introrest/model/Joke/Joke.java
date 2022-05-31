package fr.ensim.interop.introrest.model.Joke;

import java.util.ArrayList;

/**
 * Classe ayant 3 paramètres: data, note, id
 */
public class Joke{

    private String data;
    private Integer note;
    private Integer id;

    public static ArrayList<String>[] args;

    public void setData(String data) {
        this.data = data;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public Integer getNote() {
        return note;
    }

    public Integer getId() { return id; }
    
    public Joke(String data, Integer note, Integer id) {
        super();
        this.id=id;
        this.data=data;
        this.note=note;
    }

    

}
