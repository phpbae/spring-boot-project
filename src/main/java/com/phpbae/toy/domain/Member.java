package com.phpbae.toy.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "salary")
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
