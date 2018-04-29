package com.phpbae.toy.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberIdx;

    @Column
    private String email;

    @Column
    private String password;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "name")),
            @AttributeOverride(name = "age", column = @Column(name = "age"))
    })
    private MemberInformation memberInformation;


    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private MemberSalary salary;


}
