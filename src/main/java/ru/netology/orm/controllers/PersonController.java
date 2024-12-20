package ru.netology.orm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.orm.entities.Person;
import ru.netology.orm.repositories.PersonRepository;

import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonByCity(@RequestParam String city) {
        return repository.findByCityQuery(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonByAge(@RequestParam int age) {
        return repository.findByAgeQuery(age);
    }

    @GetMapping("/persons/by-name")
    public List<Person> getPersonByNameAndSurname(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname
    ) {
        return repository.findByNameAndSurnameQuery(name, surname);
    }
}
