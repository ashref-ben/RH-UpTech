package com.example.RHSERVICE.Services;

        import com.example.RHSERVICE.Dtos.EmployeeDTO;
        import com.example.RHSERVICE.Dtos.TeamDTO;

        import java.util.List;

public interface ITeamService {

    TeamDTO createTeam(TeamDTO teamDTO);
    TeamDTO getTeamById(Integer teamId);
    List<TeamDTO> getAllTeams();
    void deleteTeam(Integer teamId);
    void assignLeadToTeam(Integer teamId, Integer leadId);
    void addEmployeeToTeam(Integer teamId, Integer employeeId);
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(String employeeId);

    EmployeeDTO updateEmployee(String employeeId, EmployeeDTO employeeDTO);

    boolean deleteEmployee(String employeeId);
}
