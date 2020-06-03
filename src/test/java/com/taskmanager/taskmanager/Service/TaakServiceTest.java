package com.taskmanager.taskmanager.Service;

import com.taskmanager.taskmanager.model.dto.SubTaakDTO;
import com.taskmanager.taskmanager.model.dto.TaakDTO;
import com.taskmanager.taskmanager.model.service.TaakService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaakServiceTest {
        @Autowired
        TaakService taakService;

        @Test
        public void testJPA(){
            TaakDTO taak = new TaakDTO();

            taak.setTaak("taak 1");
            taak.setBeschrijving("taak 1");
            taak.setDatum(LocalDate.now().toString());
            taak.setTijd(LocalTime.now());

            SubTaakDTO subTaak = new SubTaakDTO();
            subTaak.setTaakId(taak.getId());
            subTaak.setTaak("subTaak 1");
            subTaak.setBeschrijving("subTaak 1");


            taakService.addTaak(taak);

            assertEquals(1, taakService.getTaken().size());
            assertNotNull(taakService.geefTaak(1));
            taakService.addSubTaak(subTaak);
            assertEquals(1,taakService.getSubTaken().size());
            assertNotNull(taakService.geefSubTaak(subTaak.getTaakId()));
        }

}
