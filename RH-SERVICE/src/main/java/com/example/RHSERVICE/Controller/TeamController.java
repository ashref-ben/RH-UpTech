package com.example.RHSERVICE.Controller;

import com.example.RHSERVICE.Dtos.TeamDTO;
import com.example.RHSERVICE.Services.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final ITeamService teamService;

    @Autowired
    public TeamController(ITeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<TeamDTO> createTeam(@RequestBody TeamDTO teamDTO) {
        TeamDTO createdTeam = teamService.createTeam(teamDTO);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Integer teamId) {
        TeamDTO teamDTO = teamService.getTeamById(teamId);
        if (teamDTO != null) {
            return new ResponseEntity<>(teamDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        List<TeamDTO> teams = teamService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @DeleteMapping("/{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Integer teamId) {
        teamService.deleteTeam(teamId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{teamId}/lead/{leadId}")
    public ResponseEntity<Void> assignLeadToTeam(@PathVariable Integer teamId, @PathVariable Integer leadId) {
        teamService.assignLeadToTeam(teamId, leadId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{teamId}/employee/{employeeId}")
    public ResponseEntity<Void> addEmployeeToTeam(@PathVariable Integer teamId, @PathVariable Integer employeeId) {
        teamService.addEmployeeToTeam(teamId, employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
