package io.github.kickccat.easynotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
* @SpringBootApplication --> combination: @Configuration + @EnableAutoConfiguration + @ComponentScan
* @Configuration: source of the other bean definitions
* @EnableAutoConfiguration: tell Spring to automatically configure the dependencies wrote in the
* pom.xml file
* @ComponentScan: tell Spring to scan and bootstrap the other components under the current
* package and all the sub-packages
* @EnableJpaAuditing: adds Spring Data JPA's Auditing
* */
@SpringBootApplication
@EnableJpaAuditing
public class EasyNotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyNotesApplication.class, args);
    }
}
