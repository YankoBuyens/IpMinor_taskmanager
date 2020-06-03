package com.taskmanager.taskmanager.dto;

import com.taskmanager.taskmanager.model.dto.SubTaakDTO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubTaakDTOTest {


    @Test
    public void testSubTaakDTO(){
        SubTaakDTO subTaak = new SubTaakDTO();
        assertNotNull(subTaak);
    }

    @Test
    public void testMaakSubTaskDTO(){
        SubTaakDTO subTaak = new SubTaakDTO();
        subTaak.setId(1);
        subTaak.setTaakId(1);
        subTaak.setTaak("SubTaak1");
        subTaak.setBeschrijving("SubTaak1");

        assertNotNull(subTaak);
        assertEquals(1,subTaak.getId());
        assertEquals(1,subTaak.getTaakId());
        assertEquals("SubTaak1", subTaak.getTaak());
        assertEquals("SubTaak1", subTaak.getBeschrijving());
    }
}
