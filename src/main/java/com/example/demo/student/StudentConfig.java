package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.time.LocalDate;
import java.util.List;


import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
           Student mariam =  new Student(
                    1L,
                    "Alpha Issagha",
                    "alpha.jamal@gmail.com",
                    LocalDate.of(2000, JANUARY,5)
           );
            Student alpha = new Student(
                    "Fatoumata b",
                    "mamadou@gmail.com",
                    LocalDate.of(1997, JANUARY,18)
            );
            Student alphaa = new Student(
                    "Souleymane  ",
                    "soul@gmail.com",
                    LocalDate.of(1995, JANUARY,18)
            );
            repository.saveAll(
                    List.of (mariam,alpha,alphaa)
            );
        };
   }
}

