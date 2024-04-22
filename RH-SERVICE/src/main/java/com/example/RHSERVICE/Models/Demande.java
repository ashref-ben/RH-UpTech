package com.example.RHSERVICE.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="Demandes")
@Data
public class Demande {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long demandeId;
    private String employeeId;
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;
    @Temporal(TemporalType.DATE)
    private  LocalDate endDate;
    private String reason;
    private boolean urgance;
}
