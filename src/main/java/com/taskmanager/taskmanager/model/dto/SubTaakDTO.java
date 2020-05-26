package com.taskmanager.taskmanager.model.dto;

public class SubTaakDTO {
    private String taak,beschrijving;
    private int id, taakId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getTaak() {
        return taak;
    }

    public void setTaak(String taak) {
        this.taak = taak;
    }

    public void setTaakId(int taakId){this.taakId = taakId;}

    public int getTaakId(){return  taakId;}


}
