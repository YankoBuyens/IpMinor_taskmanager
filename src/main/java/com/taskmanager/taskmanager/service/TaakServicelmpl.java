package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.domain.SubTaak;
import com.taskmanager.taskmanager.domain.Taak;
import com.taskmanager.taskmanager.dto.SubTaakDTO;
import com.taskmanager.taskmanager.dto.TaakDTO;
import com.taskmanager.taskmanager.repository.SubTaakRepository;
import com.taskmanager.taskmanager.repository.TaakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaakServicelmpl implements TaakService{

    private final TaakRepository taakRepository;
    private final SubTaakRepository subTaakRepository;

    private int id;

    @Autowired
    public TaakServicelmpl(TaakRepository taakRepository, SubTaakRepository subTaakRepository){
        this.taakRepository = taakRepository;
        id = 1;
       this.subTaakRepository = subTaakRepository;
    }

    @Override
    public List<TaakDTO> getTaken() {
        return taakRepository.findAll().stream().map(h -> {
            TaakDTO dto = new TaakDTO();
            dto.setTaak(h.getTaak());
            dto.setBeschrijving(h.getBeschrijving());
            dto.setDatum(h.getDatum());
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
        taak.setId(Integer.toString(id++));
        taakRepository.save(taak);
    }

    @Override
    public TaakDTO geefTaak(String id) {
        for(TaakDTO taak : this.getTaken()){
            if(taak.getId().equals(id)){
                return taak;
            }
        }
        return null;
    }

    @Override
    public void updateTaak(TaakDTO taakDTO) {
            Taak taak = taakRepository.getOne(Long.parseLong(taakDTO.getId()));
            taak.setTaak(taakDTO.getTaak());
            taak.setBeschrijving(taakDTO.getBeschrijving());
            taak.setDatum(taakDTO.getDatum());
            taak.setTijd(taakDTO.getTijd());
            this.taakRepository.save(taak);
    }


     @Override
    public void addSubTaak(SubTaakDTO subTaakDTO) {
        SubTaak subTaak = new SubTaak();
        subTaak.setTaak(subTaakDTO.getTaak());
        subTaak.setBeschrijving(subTaakDTO.getBeschrijving());
        subTaak.setId(subTaakDTO.getId());
        this.subTaakRepository.save(subTaak);

    }

    @Override
    public SubTaakDTO geefSubTaak(String id) {
        for(SubTaakDTO subTaakDTO : this.getSubTaken()){
            if(subTaakDTO.getId().equals(id)){
                return subTaakDTO;
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
            return subdto;
        }).collect(Collectors.toList());
    }

  /*  @Override
    public List<Taak> getTaken(){
        return taakRepository.getTakenlijst();
    }

    @Override
    public void addTaak(TaakDTO taakDTO){
        Taak taak = new Taak(taakDTO.getTaak(),taakDTO.getBeschrijving(),taakDTO.getDatum(),taakDTO.getTijd(),Integer.toString(id++));
        taakRepository.voegTaakToe(taak);
    }

    @Override
    public Taak geefTaak(String id){return taakRepository.geefTaak(id);}

    @Override
    public void updateTaak(TaakDTO taakDTO){
        Taak taak = new Taak(taakDTO.getTaak(),taakDTO.getBeschrijving(),taakDTO.getDatum(),taakDTO.getTijd(),taakDTO.getId());
        taakRepository.updateTaak(taak);
    }

    @Override
    public void addSubTaak(SubTaakDTO subTaakDTO){
        SubTaak subTaak = new SubTaak(subTaakDTO.getTaak(),subTaakDTO.getBeschrijving(),subTaakDTO.getId());
        taakRepository.addSubTaak(subTaak);
    }

    @Override
    public SubTaak geefSubTaak(String id){return taakRepository.geefSubTaak(id);}

    */
}
