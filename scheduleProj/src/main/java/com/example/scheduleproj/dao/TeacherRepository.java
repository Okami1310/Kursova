package com.example.scheduleproj.dao;

import com.example.scheduleproj.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}