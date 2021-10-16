package com.inflearn.inflearnjpabasic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;


@AllArgsConstructor
@Getter

@NoArgsConstructor
@Embeddable
public class Embedable {

    private String shit;

    @Embedded
    private Embedable2 embedable2;
}
