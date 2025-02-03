package dev.wayron.nobsv2_exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Nobsv2ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(Nobsv2ExamApplication.class, args);
	}

}
