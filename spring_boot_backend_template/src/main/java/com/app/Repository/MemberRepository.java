package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	
}
