package ru.netology.orm.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import ru.netology.orm.entities.Person;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private final EntityManager em;

    public PersonRepository(EntityManager em) {
        this.em = em;
    }

    public List<Person> getPersonsByCity(String city) {
        var cb = em.getCriteriaBuilder();
        var cr = cb.createQuery(Person.class);
        Root<Person> root = cr.from(Person.class);
        cr.select(root).where(cb.equal(cb.lower(root.get("cityOfLiving")), city.toLowerCase()));

        TypedQuery<Person> query = em.createQuery(cr);

        return query.getResultList();
    }
}
