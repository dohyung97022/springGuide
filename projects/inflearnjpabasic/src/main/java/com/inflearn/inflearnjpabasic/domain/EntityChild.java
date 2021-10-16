package com.inflearn.inflearnjpabasic.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor

@Entity
@Table(name = "ENTITY_CHILD")
public class EntityChild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
