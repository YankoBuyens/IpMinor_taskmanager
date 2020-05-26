package com.taskmanager.taskmanager.model.service;

import com.taskmanager.taskmanager.model.dto.SubTaakDTO;
import com.taskmanager.taskmanager.model.dto.TaakDTO;

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
