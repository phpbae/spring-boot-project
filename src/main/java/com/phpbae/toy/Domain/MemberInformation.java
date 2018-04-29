package com.phpbae.toy.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class MemberInformation implements Serializable {

    @Column
    private String name;
    @Column
    private int age;
    @Column
    private LocalDate recentAccessDate;
    @Column
    private LocalDate registrationDate;
    @Column
    private Boolean administratorRights;

}
