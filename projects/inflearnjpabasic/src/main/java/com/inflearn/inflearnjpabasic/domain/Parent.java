package com.inflearn.inflearnjpabasic.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "parent")
    Child child;

    public Parent(String name) {
        this.name = name;
    }
}
