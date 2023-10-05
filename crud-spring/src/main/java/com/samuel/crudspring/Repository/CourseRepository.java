package com.samuel.crudspring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samuel.crudspring.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {}
