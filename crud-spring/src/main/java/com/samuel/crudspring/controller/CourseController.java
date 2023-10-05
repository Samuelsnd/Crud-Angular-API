package com.samuel.crudspring.controller;


import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samuel.crudspring.Repository.CourseRepository;
import com.samuel.crudspring.model.Course;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    // Considerado uma boa prática utilizar a injeção do Repository via  construtor
    private final CourseRepository courseRepository;
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
