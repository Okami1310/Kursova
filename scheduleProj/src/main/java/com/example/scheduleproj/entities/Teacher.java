package com.example.scheduleproj.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "mail", length = 50)
    private String mail;

    @Column(name = "phone")
    private Integer phone;

    @ManyToMany(mappedBy = "teachers")
    private Set<Discipline> disciplines = new LinkedHashSet<>();


    @ManyToMany
    @JoinTable(name = "teacher_scheduls",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "scheduls_id"))
    private Set<Schedul> scheduls = new LinkedHashSet<>();

}