package com.taskmanager.taskmanager.dto;

import com.taskmanager.taskmanager.model.dto.SubTaakDTO;
import com.taskmanager.taskmanager.model.dto.TaakDTO;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class TaakDTOTest {

    @Test
    public void testTaakDTO(){
        TaakDTO taak = new TaakDTO();
        assertNotNull(taak);
    }

    @Test
    public void TestMaakTaakDTO(){
        TaakDTO taak = new TaakDTO();
        taak.setId(1);
        taak.setTaak("Taak1");
        taak.setBeschrijving("Beschrijving taak 1");
        taak.setDatum(LocalDate.of(2020,06,8).toString());
        taak.setTijd(LocalTime.of(20,20));

        assertNotNull(taak);
        assertEquals(1, taak.getId());
        assertEquals("Taak1", taak.getTaak());
        assertEquals("Beschrijving taak 1", taak.getBeschrijving());
        assertEquals(LocalDate.of(2020, 06, 8), taak.getDatum());
        assertEquals(LocalTime.of(20, 20), taak.getTijd());
    }

    @Test
    public void TestMaakTaakDTOMetSubTaak(){
        TaakDTO taak = new TaakDTO();
        taak.setId(1);
        taak.setTaak("Taak1");
        taak.setBeschrijving("Beschrijving taak 1");
        taak.setDatum(LocalDate.of(2020,06,8).toString());
        taak.setTijd(LocalTime.of(20,20));

        SubTaakDTO subTaak = new SubTaakDTO();
        subTaak.setId(1);
        subTaak.setTaakId(taak.getId());
        subTaak.setTaak("SubTaak1");
        subTaak.setBeschrijving("SubTaak1");


        assertNotNull(taak);
        assertEquals(subTaak.getTaakId(), taak.getId());
    }

}

