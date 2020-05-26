package com.taskmanager.taskmanager.model.enity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.validation.constraints.NotEmpty;

@Entity
public class Taak {
    private LocalDate datum;
    private LocalTime tijd;
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    private String taak, beschrijving;

    public Taak() {}
    public Taak(String taak, String beschrijving, LocalDate datum, LocalTime tijd, int id){
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

    public void setId(int id){
        this.id = id;
    }

    @Id
    public int getId(){
        return id;
    }
}
