package com.example.RHSERVICE.Services;

import com.example.RHSERVICE.Dtos.FormationDTO;

import java.util.List;

public interface IFormationService {

    FormationDTO createFormation(FormationDTO formationDTO);

    List<FormationDTO> getAllFormations();

    FormationDTO getFormationById(Integer id);

    FormationDTO updateFormation(FormationDTO formationDTO);

    boolean deleteFormation(Integer id);

}
