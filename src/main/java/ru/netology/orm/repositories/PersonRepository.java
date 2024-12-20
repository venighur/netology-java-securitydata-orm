package ru.netology.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.orm.entities.Person;
import ru.netology.orm.entities.PersonId;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    List<Person> findByCityOfLivingIgnoreCase(String city);
    List<Person> findByAgeLessThanOrderByAgeAsc(int age);
    List<Person> findByName(String name);
    List<Person> findBySurname(String surname);
    List<Person> findByNameAndSurname(String name, String surname);
}
