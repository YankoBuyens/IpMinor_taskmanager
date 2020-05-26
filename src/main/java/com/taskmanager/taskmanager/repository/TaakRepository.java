package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.domain.Taak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


@Repository
public interface TaakRepository extends JpaRepository<Taak, Integer> {

}
