package com.taskmanager.taskmanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SubTaak {
    private String taak,beschrijving;

    @Id
    @GeneratedValue
    private String id;


    public SubTaak(){

    }

    public SubTaak(String taak, String beschrijving, String id){
        setTaak(taak);
        setBeschrijving(beschrijving);
        setId(id);
    }

    public String getTaak() {
        return taak;
    }

    public void setTaak(String taak) {
        this.taak = taak;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
