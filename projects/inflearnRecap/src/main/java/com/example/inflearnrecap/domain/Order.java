package com.example.inflearnrecap.domain;

import com.example.inflearnrecap.domain.enumerated.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "memberId",referencedColumnName = "id")
    private Member member;

    private LocalDateTime orderDate;

    @Enumerated(value = EnumType.STRING)
    private Status orderStatus;

    public Order(OrderDto orderDto) {
        this.orderDate = orderDto.getOrderDate();
        this.orderStatus = orderDto.getOrderStatus();
    }

    public void setMember(Member member) {
        this.member = member;
        member.addOrder(this);
    }
}
