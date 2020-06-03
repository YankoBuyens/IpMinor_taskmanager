package com.taskmanager.taskmanager.domain;

import com.taskmanager.taskmanager.model.enity.SubTaak;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubTaakTest {

    @Test
    public void testSubTaak(){
        SubTaak subTaak = new SubTaak();
        assertNotNull(subTaak);
    }

    @Test
    public void testMaakSubTask(){
        SubTaak subTaak = new SubTaak();
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
