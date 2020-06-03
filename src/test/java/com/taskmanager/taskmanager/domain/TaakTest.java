package com.taskmanager.taskmanager.domain;


import com.taskmanager.taskmanager.model.enity.SubTaak;
import com.taskmanager.taskmanager.model.enity.Taak;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TaakTest {

    @Test
    public void testTaak(){
        Taak taak = new Taak();
        assertNotNull(taak);
    }

    @Test
    public void MaakTaak(){
        Taak taak = new Taak();
        taak.setId(1);
        taak.setTaak("Taak1");
        taak.setBeschrijving("Beschrijving taak 1");
        taak.setDatum(LocalDate.of(2020,06,8));
        taak.setTijd(LocalTime.of(20,20));

        assertNotNull(taak);
        assertEquals(1, taak.getId());
        assertEquals("Taak1", taak.getTaak());
        assertEquals("Beschrijving taak 1", taak.getBeschrijving());
        assertEquals(LocalDate.of(2020, 06, 8), taak.getDatum());
        assertEquals(LocalTime.of(20, 20), taak.getTijd());
    }

    @Test
    public void MaakTaakMetSubTaak(){
        Taak taak = new Taak();
        taak.setId(1);
        taak.setTaak("Taak1");
        taak.setBeschrijving("Beschrijving taak 1");
        taak.setDatum(LocalDate.of(2020,06,8));
        taak.setTijd(LocalTime.of(20,20));

        SubTaak subTaak = new SubTaak();
        subTaak.setId(1);
        subTaak.setTaakId(taak.getId());
        subTaak.setTaak("SubTaak1");
        subTaak.setBeschrijving("SubTaak1");


        assertNotNull(taak);
        assertEquals(subTaak.getTaakId(), taak.getId());
    }

}
