package com.phpbae.toy.repository;

import com.phpbae.toy.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Modifying
    @Query(value = "DELETE FROM member WHERE member_idx = ?1", nativeQuery = true)
    public void deleteMemberByIdx(int idx);


    @Query(value = "SELECT m FROM Member m left join fetch m.salary")
    public List<Member> getAllMembers();

}
