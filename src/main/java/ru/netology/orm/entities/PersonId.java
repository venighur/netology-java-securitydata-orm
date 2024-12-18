package ru.netology.orm.entities;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonId implements Serializable {
    private String name;
    private String surname;
    private int age;
}
