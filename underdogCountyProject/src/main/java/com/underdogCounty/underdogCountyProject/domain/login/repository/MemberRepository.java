package com.underdogCounty.underdogCountyProject.domain.login.repository;

import com.underdogCounty.underdogCountyProject.domain.login.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByMemberId(String memberId);

}
