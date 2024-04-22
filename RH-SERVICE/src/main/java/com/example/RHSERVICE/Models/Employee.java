package com.example.RHSERVICE.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Setter
@Getter
@Table(name="Employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long employeeId;
    private String name;
    private String familyName;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String sex;
    private String address;
    private String phoneNumber;
    private String position;
    @Temporal(TemporalType.DATE)
    private Date dateOfStart;
    @Temporal(TemporalType.DATE)
    private Date dateOfEnd;
    @ManyToOne
    @JoinColumn(name = "Team")
    private Team Team;
}
