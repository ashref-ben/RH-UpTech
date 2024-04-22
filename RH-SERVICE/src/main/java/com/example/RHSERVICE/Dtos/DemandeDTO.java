package com.example.RHSERVICE.Dtos;

import java.time.LocalDate;

public class DemandeDTO {

    private Long demandeId;
    private String employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private boolean urgance;

    public DemandeDTO() {
    }


    public DemandeDTO(Long demandeId, String employeeId, LocalDate startDate, LocalDate endDate, String reason, boolean urgance) {
        this.demandeId = demandeId;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.urgance = urgance;
    }


    public Long getDemandeId() {
        return demandeId;
    }

    public void setDemandeId(Long demandeId) {
        this.demandeId = demandeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isUrgance() {
        return urgance;
    }

    public void setUrgance(boolean urgance) {
        this.urgance = urgance;
    }
}
