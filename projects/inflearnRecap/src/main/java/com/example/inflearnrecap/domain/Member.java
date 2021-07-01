package com.example.inflearnrecap.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipcode;

    @OneToMany(mappedBy = "member")
    private final List<Order> orders = new ArrayList<>();

    public Member(String name, String city, String street, String zipcode) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public Member(MemberDto itemDto){
        this.name = itemDto.getName();
        this.city = itemDto.getCity();
        this.street = itemDto.getStreet();
        this.zipcode = itemDto.getZipcode();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
