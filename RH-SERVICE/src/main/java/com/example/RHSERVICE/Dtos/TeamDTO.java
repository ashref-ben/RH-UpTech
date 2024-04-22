package com.example.RHSERVICE.Dtos;

import java.util.List;

public class TeamDTO {

    private Integer teamId;
    private String titleTeam;
    private EmployeeDTO leadTeam;
    private List<EmployeeDTO> employees;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTitleTeam() {
        return titleTeam;
    }

    public void setTitleTeam(String titleTeam) {
        this.titleTeam = titleTeam;
    }

    public EmployeeDTO getLeadTeam() {
        return leadTeam;
    }

    public void setLeadTeam(EmployeeDTO leadTeam) {
        this.leadTeam = leadTeam;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

}
