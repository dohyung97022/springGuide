package com.example.inflearnrecap.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberDto {
    private String name;
    private String city;
    private String street;
    private String zipcode;
}
