package com.phpbae.toy.domain.VO;

import com.phpbae.toy.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberVO {
    private int memberIdx;
    private String email;
    private String password;
    private String name;
    private int age;
    private LocalDate recentAccessDate;
    private LocalDate registrationDate;
    private Boolean administratorRights;


    public MemberVO(Member member) {
        this.memberIdx = member.getMemberIdx();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.name = member.getMemberInformation().getName();
        this.age = member.getMemberInformation().getAge();
        this.recentAccessDate = member.getMemberInformation().getRecentAccessDate();
        this.registrationDate = member.getMemberInformation().getRegistrationDate();
        this.administratorRights = member.getMemberInformation().getAdministratorRights();

    }

}
