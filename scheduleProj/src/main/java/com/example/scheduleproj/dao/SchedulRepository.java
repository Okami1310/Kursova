package com.example.scheduleproj.dao;

import com.example.scheduleproj.entities.Schedul;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulRepository extends JpaRepository<Schedul, Integer> {
}