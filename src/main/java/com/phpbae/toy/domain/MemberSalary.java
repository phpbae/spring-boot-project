package com.phpbae.toy.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "member")
@Entity
@Table
public class MemberSalary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column
    private BigDecimal yearlySalary;

    @Column
    private BigDecimal EstimatedPaymentAmount;

    @Column
    private LocalDate lastUpdate;

    @OneToOne(fetch = FetchType.LAZY)
    Member member;

}
