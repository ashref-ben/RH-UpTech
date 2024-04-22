package com.example.RHSERVICE.Controller;

import com.example.RHSERVICE.Dtos.FormationDTO;
import com.example.RHSERVICE.Services.FormationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("/formations")
@CrossOrigin("*")
public class FormationController {
    @Autowired
    FormationService formationService;

    @PostMapping
    public ResponseEntity<FormationDTO> createFormation(@RequestBody FormationDTO formationDTO) {
        FormationDTO createdFormation = formationService.createFormation(formationDTO);
        return new ResponseEntity<>(createdFormation, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FormationDTO> getFormationById(@PathVariable Integer id) {
        FormationDTO formationDTO = formationService.getFormationById(id);
        if (formationDTO != null) {
            return new ResponseEntity<>(formationDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<FormationDTO>> getAllFormations() {
        List<FormationDTO> formationDTOList = formationService.getAllFormations();
        return new ResponseEntity<>(formationDTOList, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FormationDTO> updateFormation(@PathVariable Integer id, @RequestBody FormationDTO formationDTO) {
        formationDTO.setFormationId(id);
        FormationDTO updatedFormation = formationService.updateFormation(formationDTO);
        if (updatedFormation != null) {
            return new ResponseEntity<>(updatedFormation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Integer id) {
        boolean deleted = formationService.deleteFormation(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
