package com.example.RHSERVICE.Dtos;

import lombok.Data;

import java.util.Date;

@Data
public class FormationDTO {

    private Integer formationId;
    private String title;

    private String Details;
    private Date duree;

    private Integer Archived;

    public Integer getArchived(){
        return Archived;
    }
    public void setArchived(Integer archived){
        this.Archived=archived;
    }
    public Integer getFormationId() {
        return formationId;
    }

    public void setFormationId(Integer formationId) {
        this.formationId = formationId;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return Details;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDetails(String Details) {
        this.Details = Details;
    }

    public Date getDuree() {
        return duree;
    }

    public void setDuree(Date duree) {
        this.duree = duree;
    }
}

