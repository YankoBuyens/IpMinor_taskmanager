package com.taskmanager.taskmanager.model.service;

import com.taskmanager.taskmanager.model.enity.SubTaak;
import com.taskmanager.taskmanager.model.enity.Taak;
import com.taskmanager.taskmanager.model.dto.SubTaakDTO;
import com.taskmanager.taskmanager.model.dto.TaakDTO;
import com.taskmanager.taskmanager.model.repo.TaakRepository;
import com.taskmanager.taskmanager.model.repo.SubTaakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaakServicelmpl implements TaakService{

    private final TaakRepository taakRepository;
    private final SubTaakRepository subTaakRepository;

    private int id;
    private int subId;

    @Autowired
    public TaakServicelmpl(TaakRepository taakRepository, SubTaakRepository subTaakRepository){
        this.taakRepository = taakRepository;
        id = 1;
        subId = 1;
       this.subTaakRepository = subTaakRepository;
    }

    @Override
    public List<TaakDTO> getTaken() {
        return taakRepository.findAll().stream().map(h -> {
            TaakDTO dto = new TaakDTO();
            dto.setTaak(h.getTaak());
            dto.setBeschrijving(h.getBeschrijving());
            dto.setDatum(h.getDatum().toString());
            dto.setTijd(h.getTijd());
            dto.setId(h.getId());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void addTaak(TaakDTO taakDTO) {
        Taak taak = new Taak();
        taak.setTaak(taakDTO.getTaak());
        taak.setBeschrijving(taakDTO.getBeschrijving());
        taak.setDatum(taakDTO.getDatum());
        taak.setTijd(taakDTO.getTijd());
        taak.setId(id++);
        taakRepository.save(taak);
    }

    @Override
    public TaakDTO geefTaak(int id) {
        for(TaakDTO taak : this.getTaken()){
            if(taak.getId() == id){
                return taak;
            }
        }
        return null;
    }

    @Override
    public void updateTaak(TaakDTO taakDTO) {
            Taak taak = this.taakRepository.getOne(taakDTO.getId());
            taak.setTaak(taakDTO.getTaak());
            taak.setBeschrijving(taakDTO.getBeschrijving());
            taak.setDatum(taakDTO.getDatum());
            taak.setTijd(taakDTO.getTijd());
            taak.setId(taakDTO.getId());
            this.taakRepository.save(taak);
    }


     @Override
    public void addSubTaak(SubTaakDTO subTaakDTO) {
        SubTaak subTaak = new SubTaak();
        subTaak.setTaak(subTaakDTO.getTaak());
        subTaak.setBeschrijving(subTaakDTO.getBeschrijving());
        subTaak.setId(subId++);
        subTaak.setTaakId(subTaakDTO.getId());
        this.subTaakRepository.save(subTaak);

    }

    @Override
    public SubTaakDTO geefSubTaak(int taakId) {
        for(SubTaakDTO taak : this.getSubTaken()){
            if(taak.getTaakId() == taakId){
                return taak;
            }
        }
        return null;
    }

    @Override
    public List<SubTaakDTO> getSubTaken() {
        return subTaakRepository.findAll().stream().map(h -> {
            SubTaakDTO subdto = new SubTaakDTO();
            subdto.setTaak(h.getTaak());
            subdto.setBeschrijving(h.getBeschrijving());
            subdto.setId(h.getId());
            subdto.setTaakId(h.getTaakId());
            return subdto;
        }).collect(Collectors.toList());
    }


    
}
