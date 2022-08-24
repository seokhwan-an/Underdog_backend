package com.underdogCounty.underdogCountyProject.domain.work.repository;

import com.underdogCounty.underdogCountyProject.domain.work.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkRepository extends JpaRepository<Work, Long> {

    // 작업물 사진을 카테고리별로 필터링 해주는 메소드
    Optional<Work> findByCategory(Enum category);
}
