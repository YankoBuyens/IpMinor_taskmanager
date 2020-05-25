package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.domain.SubTaak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTaakRepository extends JpaRepository<SubTaak, Long> {
}
