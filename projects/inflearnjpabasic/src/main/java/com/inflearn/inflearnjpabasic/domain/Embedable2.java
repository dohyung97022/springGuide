package com.inflearn.inflearnjpabasic.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter

@Embeddable
public class Embedable2 {
    private String jack;

    @OneToOne
    @JoinColumn(name = "entity_child_id")
    private EntityChild entityChild;
}
