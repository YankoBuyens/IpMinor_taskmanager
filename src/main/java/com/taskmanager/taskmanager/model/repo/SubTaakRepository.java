package com.taskmanager.taskmanager.model.repo;

import com.taskmanager.taskmanager.model.enity.SubTaak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTaakRepository extends JpaRepository<SubTaak, Integer> {
}
