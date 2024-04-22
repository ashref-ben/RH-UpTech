package com.example.RHSERVICE.Services;

import com.example.RHSERVICE.Dtos.EmployeeDTO;
import com.example.RHSERVICE.Dtos.TeamDTO;
import com.example.RHSERVICE.Models.Employee;
import com.example.RHSERVICE.Models.Team;
import com.example.RHSERVICE.Repositories.EmployeeRepository;
import com.example.RHSERVICE.Repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService implements ITeamService {

    private final IEmployeeService employeeService;
    private final TeamRepository teamRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public TeamService(IEmployeeService employeeService, TeamRepository teamRepository, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.teamRepository = teamRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public TeamDTO createTeam(TeamDTO teamDTO) {
        Team team = convertToTeam(teamDTO);
        return convertToTeamDTO(teamRepository.save(team));
    }

    @Override
    public TeamDTO getTeamById(Integer teamId) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        return teamOptional.map(this::convertToTeamDTO).orElse(null);
    }

    @Override
    public List<TeamDTO> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(this::convertToTeamDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteTeam(Integer teamId) {
        teamRepository.deleteById(teamId);
    }

    @Override
    public void assignLeadToTeam(Integer teamId, Integer leadId) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        Optional<Employee> leadOptional = employeeRepository.findById(Long.valueOf(leadId));

        if (teamOptional.isPresent() && leadOptional.isPresent()) {
            Team team = teamOptional.get();
            Employee lead = leadOptional.get();
            team.setLeadTeam(lead);
            teamRepository.save(team);
        }
    }

    @Override
    public void addEmployeeToTeam(Integer teamId, Integer employeeId) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        Optional<Employee> employeeOptional = employeeRepository.findById(Long.valueOf(employeeId));

        if (teamOptional.isPresent() && employeeOptional.isPresent()) {
            Team team = teamOptional.get();
            Employee employee = employeeOptional.get();
            team.getEmployees().add(employee);
            teamRepository.save(team);
            System.out.println(team);
        }
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return null;
    }

    @Override
    public EmployeeDTO getEmployeeById(String employeeId) {
        return null;
    }

    @Override
    public EmployeeDTO updateEmployee(String employeeId, EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public boolean deleteEmployee(String employeeId) {
        return false;
    }


    private TeamDTO convertToTeamDTO(Team team) {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(team.getTeamId());
        teamDTO.setTitleTeam(team.getTitleTeam());

        // Populate leadTeam if it exists
        if (team.getLeadTeam() != null) {
            EmployeeDTO leadTeamDTO = mapToEmployeeDTO(team.getLeadTeam());
            teamDTO.setLeadTeam(leadTeamDTO);
        }

        // Populate employees list
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (Employee employee : team.getEmployees()) {
            EmployeeDTO employeeDTO = mapToEmployeeDTO(employee);
            employeeDTOs.add(employeeDTO);
        }
        teamDTO.setEmployees(employeeDTOs);

        return teamDTO;
    }


    private Team convertToTeam(TeamDTO teamDTO) {
        Team team = new Team();
        team.setTitleTeam(teamDTO.getTitleTeam());
        return team;
    }
    private EmployeeDTO mapToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setFamilyName(employee.getFamilyName());
        employeeDTO.setDateOfBirth(employee.getDateOfBirth());
        employeeDTO.setSex(employee.getSex());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setPosition(employee.getPosition());
        employeeDTO.setDateOfStart(employee.getDateOfStart());
        employeeDTO.setDateOfEnd(employee.getDateOfEnd());
        return employeeDTO;
    }
}
