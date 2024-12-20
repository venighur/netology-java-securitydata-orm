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
        return repository.findByCityOfLivingIgnoreCase(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonByAge(@RequestParam int age) {
        return repository.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/persons/by-name")
    public List<Person> getPersonByNameAndSurname(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname
    ) {
        if (name == null) {
            return repository.findBySurname(surname);
        } else if (surname == null) {
            return repository.findByName(name);
        }

        return repository.findByNameAndSurname(name, surname);
    }
}
