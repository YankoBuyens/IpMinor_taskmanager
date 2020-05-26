package com.taskmanager.taskmanager.model.repo;

import com.taskmanager.taskmanager.model.enity.Taak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaakRepository extends JpaRepository<Taak, Integer> {

}
