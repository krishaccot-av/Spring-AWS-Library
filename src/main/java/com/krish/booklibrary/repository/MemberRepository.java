package com.krish.booklibrary.repository;

import com.krish.booklibrary.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
