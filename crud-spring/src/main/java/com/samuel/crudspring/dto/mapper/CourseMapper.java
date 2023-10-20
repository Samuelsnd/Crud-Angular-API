package com.samuel.crudspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.samuel.crudspring.dto.CourseDTO;
import com.samuel.crudspring.enums.Categoria;
import com.samuel.crudspring.model.Course;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }
        return new CourseDTO(course.getId(), course.getName(),course.getCategoria().getValue());
    }

    public Course toEntity(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return null;
        }
        Course course = new Course();
        if (courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        course.setCategoria(convertCategoriaValue(courseDTO.categoria()));
        return course;
        //return new Course(courseDTO.getId(), courseDTO.getName(), courseDTO.getCategoria());
    }

    public Categoria convertCategoriaValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "Front-End" -> Categoria.FRONT_END;
            case "Back-End" -> Categoria.BACK_END;
            default -> throw new IllegalArgumentException("Categoria inválida: " + value);
        };
    }
}
