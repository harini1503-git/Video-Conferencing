package com.harini.Video.Conferencing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.harini.Video.Conferencing.user.User;
import com.harini.Video.Conferencing.user.UserService;

@SpringBootApplication
public class VideoConferencingApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoConferencingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserService service
	) {
		return args -> {
			service.register(User.builder()
							.username("Harini")
							.email("harinimudaliar@gmail.com")
							.password("aaa")
					.build());

			service.register(User.builder()
					.username("Mahisha")
					.email("mahishamudaliar2603@gmail.com")
					.password("msh")
					.build());

			service.register(User.builder()
					.username("Pradhyun")
					.email("pradhyunmudaliar0306@gmail.com")
					.password("nsuj")
					.build());
		};
	}

}
