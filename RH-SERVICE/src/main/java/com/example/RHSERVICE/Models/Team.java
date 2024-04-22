package com.example.RHSERVICE.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="Teams")
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer teamId;

    private String titleTeam;

    @ManyToOne
    @JoinColumn(name = "LeadTeam")
    private Employee LeadTeam;

    @OneToMany(mappedBy = "Team")
    private List<Employee> employees;

}

