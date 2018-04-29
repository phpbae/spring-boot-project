package com.phpbae.toy.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
