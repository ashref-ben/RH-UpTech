package com.example.RHSERVICE.Controller;

import com.example.RHSERVICE.Dtos.DemandeDTO;
import com.example.RHSERVICE.Services.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demandes")
public class DemandeController {

    private final DemandeService demandeService;

    @Autowired
    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @PostMapping
    public ResponseEntity<DemandeDTO> addDemande(@RequestBody DemandeDTO demandeDto) {
        DemandeDTO savedDemande = demandeService.addDemande(demandeDto);
        return new ResponseEntity<>(savedDemande, HttpStatus.CREATED);
    }
}
