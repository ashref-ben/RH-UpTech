package com.example.RHSERVICE.Services;

import com.example.RHSERVICE.Dtos.DemandeDTO;
import com.example.RHSERVICE.Models.Demande;
import com.example.RHSERVICE.Repositories.DemandeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemandeServiceImpl implements DemandeService {

    private final DemandeRepo demandeRepository;
    private final ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Autowired
    public DemandeServiceImpl(DemandeRepo demandeRepository, ModelMapper modelMapper) {
        this.demandeRepository = demandeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DemandeDTO addDemande(DemandeDTO demandeDTO) {
        Demande demande = modelMapper.map(demandeDTO, Demande.class);
        Demande savedDemande = demandeRepository.save(demande);
        return modelMapper.map(savedDemande, DemandeDTO.class);
    }

    @Override
    public DemandeDTO updateDemande(DemandeDTO demandeDTO) {
        Demande demande = modelMapper.map(demandeDTO, Demande.class);
        Demande updatedDemande = demandeRepository.save(demande);
        return modelMapper.map(updatedDemande, DemandeDTO.class);
    }



    @Override
    public void deleteDemande(Long demandeId) {
        demandeRepository.deleteById(demandeId);
    }

    @Override
    public List<DemandeDTO> getAllDemandes() {
        List<Demande> demandes = demandeRepository.findAll();
        return demandes.stream()
                .map(demande -> modelMapper.map(demande, DemandeDTO.class))
                .collect(Collectors.toList());
    }


}

