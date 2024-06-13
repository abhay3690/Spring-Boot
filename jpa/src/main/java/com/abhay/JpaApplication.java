package com.abhay;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.abhay.models.Author;
import com.abhay.models.Video;
import com.abhay.repositories.AuthorRepository;
import com.abhay.repositories.VideoRepository;


@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository, VideoRepository videoRepository){
		return args -> {
			var author = Author.builder().firstname("abhay").lastname("suthar").age(22).email("abhaysuthar7777@gmail.com").build();
			repository.save(author);
//			var video = Video.builder().name("sabhi").length(5).build();
//			Video.builder().name("java").length(5).build();
//			videoRepository.save(video);
		};
	}
}
