package com.example.scheduleproj.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "schedul")
public class Schedul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "time", length = 50)
    private String time;

    @Column(name = "`group`")
    private Integer group;

    @Column(name = "discipline", length = 50)
    private String discipline;

    @Column(name = "teacher", length = 50)
    private String teacher;

    @ManyToMany(mappedBy = "scheduls")
    private Set<Teacher> teachers = new LinkedHashSet<>();

}