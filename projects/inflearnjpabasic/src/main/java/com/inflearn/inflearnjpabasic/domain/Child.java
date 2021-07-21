package com.inflearn.inflearnjpabasic.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@NoArgsConstructor
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToOne
    Parent parent;

    public Child(String name) {
        this.name = name;
    }
}
