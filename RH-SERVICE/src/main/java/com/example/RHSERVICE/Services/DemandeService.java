package com.example.RHSERVICE.Services;

import com.example.RHSERVICE.Dtos.DemandeDTO;

import java.util.List;

public interface DemandeService {

    DemandeDTO addDemande(DemandeDTO demandeDTO);

    DemandeDTO updateDemande(DemandeDTO demandeDTO);

    void deleteDemande(Long demandeId);

    List<DemandeDTO> getAllDemandes();


}
