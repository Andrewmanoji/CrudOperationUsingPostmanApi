package com.restAPI.crudoperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restAPI.crudoperations.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
