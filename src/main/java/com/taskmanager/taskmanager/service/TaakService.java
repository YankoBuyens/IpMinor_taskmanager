package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.domain.SubTaak;
import com.taskmanager.taskmanager.domain.Taak;
import com.taskmanager.taskmanager.dto.SubTaakDTO;
import com.taskmanager.taskmanager.dto.TaakDTO;

import java.util.List;

public interface TaakService {
    List<TaakDTO> getTaken();

    void addTaak(TaakDTO taakDTO);

    TaakDTO geefTaak(int id);

    void updateTaak(TaakDTO taakDTO);

    void addSubTaak(SubTaakDTO subTaakDTO);

    SubTaakDTO geefSubTaak(int id);

    List<SubTaakDTO> getSubTaken();
}
