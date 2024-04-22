package com.example.RHSERVICE.Repositories;

import com.example.RHSERVICE.Models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Integer> {



}
