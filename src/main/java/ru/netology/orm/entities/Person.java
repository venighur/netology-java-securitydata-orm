package ru.netology.orm.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "persons")
@IdClass(PersonId.class)
@Table(name = "persons")
public class Person {
    @Id
    @Column(nullable = false)
    private String name;

    @Id
    @Column(nullable = false)
    private String surname;

    @Id
    @Column(nullable = false)
    private int age;

    @Column(length = 20)
    private String phoneNumber;

    @Column(nullable = false, length = 100)
    private String cityOfLiving;
}
