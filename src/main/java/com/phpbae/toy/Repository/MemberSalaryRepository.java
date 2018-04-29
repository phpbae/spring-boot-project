package com.phpbae.toy.Repository;


import com.phpbae.toy.domain.MemberSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberSalaryRepository extends JpaRepository<MemberSalary, Integer> {
}
