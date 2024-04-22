package com.example.RHSERVICE.Repositories;

import com.example.RHSERVICE.Models.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepo extends JpaRepository<Demande,Long> {
}
