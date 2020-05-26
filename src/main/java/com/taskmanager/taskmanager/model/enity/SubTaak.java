package com.taskmanager.taskmanager.model.enity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class SubTaak {
    @NotEmpty
    private String taak,beschrijving;

    @Id
    @GeneratedValue
    private int id;

    private int taakId;


    public SubTaak(){

    }

    public SubTaak(String taak, String beschrijving, int id,int TaakId){
        setTaak(taak);
        setBeschrijving(beschrijving);
        setId(id);
        setTaakId(id);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTaakId(int taakId){this.taakId = taakId;}

    public int getTaakId(){return  taakId;}
}
