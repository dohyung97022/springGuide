package com.example.inflearnrecap.controller;

import com.example.inflearnrecap.domain.Member;
import com.example.inflearnrecap.domain.MemberDto;
import com.example.inflearnrecap.domain.Order;
import com.example.inflearnrecap.domain.OrderDto;
import com.example.inflearnrecap.domain.enumerated.Status;
import com.example.inflearnrecap.repository.MemberRepository;
import com.example.inflearnrecap.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class ItemControllerTest {

    @Autowired MemberRepository memberRepository;
    @Autowired OrderRepository orderRepository;

    @Test
    void createMember() {
        MemberDto memberDto = new MemberDto("김도형", "서울시", "영동대로", "201621");
        Member member = new Member(memberDto);
        Member testItem = memberRepository.save(member);

        Assertions.assertEquals(memberDto.getName(),testItem.getName());
        Assertions.assertEquals(memberDto.getCity(),testItem.getCity());
        Assertions.assertEquals(memberDto.getStreet(),testItem.getStreet());
        Assertions.assertEquals(memberDto.getZipcode(),testItem.getZipcode());
    }

    @Test
    @Transactional
    void createOrder(){
        // get
        MemberDto memberDto = new MemberDto("김도형", "서울시", "영동대로", "201621");
        OrderDto orderDto = new OrderDto(1L, LocalDateTime.now(), Status.PROCESSING);

        // set
        Member member = new Member(memberDto);
        Order order = new Order(orderDto);

        order.setMember(member);
        Order savedOrder = orderRepository.save(order);
        // check
        Member savedMember = orderRepository.getById(savedOrder.getId()).getMember();
        Assertions.assertEquals(order.getOrderDate(), savedOrder.getOrderDate());
        Assertions.assertEquals(order.getOrderStatus(),savedOrder.getOrderStatus());
        Assertions.assertEquals(order.getMember(),savedOrder.getMember());
    }
}