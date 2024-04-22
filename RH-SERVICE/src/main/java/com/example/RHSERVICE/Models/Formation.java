package com.example.RHSERVICE.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name="Formation")
@Data
public class Formation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer FormationId;
    private String Title;
    private String Details;
    private Date Duree;
    private Integer Archived;
}
