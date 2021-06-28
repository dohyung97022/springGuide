package com.inflearn.inflearnjpause.domain;

import com.inflearn.inflearnjpause.domain.item.Item;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Table
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column
    private Long orderPrice;

    @Column
    private Long count;
}
