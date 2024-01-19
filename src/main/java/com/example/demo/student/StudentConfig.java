package com.example.demo.student;

import org.springframework.boot.*;
import org.springframework.context.annotation.*;

import static java.time.LocalDate.*;
import java.time.*;
import java.util.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
     Student mariam = new Student(
             LocalDate.of(2000, Month.JANUARY, 5),
             "Mariam",
            "mariam.jamal@gmail.com");

            Student alex = new Student(
                    LocalDate.of(2004, Month.JANUARY, 5),
                    "Alex",
                    "alex@gmail.com");

            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }
}
