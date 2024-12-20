package ru.netology.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.orm.entities.Person;
import ru.netology.orm.entities.PersonId;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    @Query("""
            select p from persons p
            where lower(cityOfLiving) = lower(:city)
            """)
    List<Person> findByCityQuery(@Param("city") String city);

    @Query("""
            select p from persons p
            where p.age < :age
            order by p.age asc
            """)
    List<Person> findByAgeQuery(@Param("age") int age);

    @Query("""
            select p from persons p
            where (:name is null or p.name = :name) and (:surname is null or p.surname = :surname)
            """)
    List<Person> findByNameAndSurnameQuery(@Param("name") String name, @Param("surname") String surname);
}
