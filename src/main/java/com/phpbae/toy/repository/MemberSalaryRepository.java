package com.phpbae.toy.repository;


import com.phpbae.toy.domain.MemberSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberSalaryRepository extends JpaRepository<MemberSalary, Integer> {

    @Modifying
    @Query(value = "DELETE FROM member_salary WHERE member_member_idx = ?1", nativeQuery = true)
    public void deleteMemberSalaryByIdx(int idx);
}
