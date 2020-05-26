package com.taskmanager.taskmanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@Entity
public class Taak {
    private String taak, beschrijving;
    private LocalDate datum;
    private LocalTime tijd;
    @Id
    @GeneratedValue
    private String id;

    public Taak() {}
//ressdz
    public Taak(String taak, String beschrijving, LocalDate datum, LocalTime tijd, String id){
        this.taak = taak;
        this.beschrijving = beschrijving;
        this.datum = datum;
        this.tijd = tijd;
        this.id = id;
    }

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

    public void setDatum(LocalDate datum) {
        this.datum = datum;
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

    public void setId(String id){
        this.id = id;
    }

    @Id
    public String getId(){
        return id;
    }
}
