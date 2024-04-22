package com.example.RHSERVICE.Services;
import com.example.RHSERVICE.Dtos.FormationDTO;
import com.example.RHSERVICE.Models.Formation;
import com.example.RHSERVICE.Repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FormationService implements IFormationService{

    @Autowired
    private FormationRepository formationRepository;


    public FormationDTO createFormation(FormationDTO formationDTO) {
        Formation formation = mapToFormationEntity(formationDTO);
        Formation savedFormation = formationRepository.save(formation);
        return mapToFormationDTO(savedFormation);
    }



    public List<FormationDTO> getAllFormations() {
        List<Formation> formations = formationRepository.findAll();
        return formations.stream()
                .map(this::mapToFormationDTO)
                .collect(Collectors.toList());
    }
    public FormationDTO getFormationById(Integer id) {
        Formation formation = formationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Formation not found with id: " + id));
        return mapToFormationDTO(formation);
    }

    public FormationDTO updateFormation(FormationDTO formationDTO) {
        Formation existingFormation = formationRepository.findById(formationDTO.getFormationId())
                .orElseThrow(() -> new NoSuchElementException("Formation not found with id: " + formationDTO.getFormationId()));
        existingFormation.setTitle(formationDTO.getTitle());
        existingFormation.setDuree(formationDTO.getDuree());
        existingFormation.setArchived(formationDTO.getArchived());
        Formation updatedFormation = formationRepository.save(existingFormation);
        return mapToFormationDTO(updatedFormation);
    }

    public boolean deleteFormation(Integer id) {
        formationRepository.deleteById(id);
        return false;
    }
    private FormationDTO mapToFormationDTO(Formation formation) {
        FormationDTO formationDTO = new FormationDTO();
        formationDTO.setFormationId(formation.getFormationId());
        formationDTO.setTitle(formation.getTitle());
        formationDTO.setDetails(formation.getDetails());
        formationDTO.setDuree(formation.getDuree());
        formationDTO.setArchived(formation.getArchived());
        return formationDTO;
    }
    private Formation mapToFormationEntity(FormationDTO formationDTO) {
        Formation formation = new Formation();
        formation.setFormationId(formationDTO.getFormationId());
        formation.setTitle(formationDTO.getTitle());
        formation.setDetails(formationDTO.getDetails());
        formation.setArchived(formationDTO.getArchived());
        formation.setDuree(formationDTO.getDuree());
        return formation;
    }
}
