package com.cognizant.sharecar;

import com.cognizant.sharecar.repository.entity.Person;
import com.cognizant.sharecar.repository.spi.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.cognizant.sharecar"})
public class ShareCarApp implements CommandLineRunner {

    @Autowired
    private PersonRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ShareCarApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        final Person person = new Person("vardenis", "pavardenis");
        repository.save(person);
        final List<Person> people = repository.findAll();

        people.forEach(p -> System.out.println(p));

    }
}
