package com.samuel.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.samuel.crudspring.Repository.CourseRepository;
import com.samuel.crudspring.enums.Categoria;
import com.samuel.crudspring.model.Course;
import com.samuel.crudspring.model.Lesson;

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
			
			Lesson l = new Lesson();
			l.setName("Introdução");
			l.setYoutubeUrl("www.youtube.com.br");
			l.setCourse(c);
			c.getLessons().add(l);

			Lesson l1 = new Lesson();
			l1.setName("Angular");
			l1.setYoutubeUrl("www.youtube.com.br");
			l1.setCourse(c);
			c.getLessons().add(l1);
			

			courseRepository.save(c);
		};
	}
}
