package com.taskmanager.taskmanager.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TaakDTO {
    private String taak, beschrijving;
    private LocalDate datum;
    private LocalTime tijd;
    private int id;

    public void setTaak(String taak) {
        this.taak = taak;
    }

    public String getTaak() {
        return taak;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setDatum(String datum) {
       this.datum = LocalDate.parse(datum);
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setTijd(LocalTime tijd) {
        this.tijd = tijd;
    }

    public LocalTime getTijd() {
        return tijd;
    }

    public void setId(int id){ this.id = id; }

    public int getId(){ return id; }
}
