package ru.netology.orm.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "persons")
public class Person {
    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private int age;

    @Column(length = 20)
    private String phoneNumber;

    @Column(nullable = false, length = 100)
    private String cityOfLiving;
}
