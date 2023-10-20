package com.samuel.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.samuel.crudspring.Repository.CourseRepository;
import com.samuel.crudspring.enums.Categoria;
import com.samuel.crudspring.model.Course;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular Spring boot");
			c.setCategoria(Categoria.FRONT_END);

			courseRepository.save(c);
		};
	}
}
