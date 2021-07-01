package com.example.inflearnrecap.domain;

import com.example.inflearnrecap.domain.enumerated.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class OrderDto {
    private Long memberId;
    private LocalDateTime orderDate;
    private Status orderStatus;
}
