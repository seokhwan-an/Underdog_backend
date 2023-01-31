package com.underdogCounty.underdogCountyProject.domain.work.repository;

import com.underdogCounty.underdogCountyProject.domain.work.Category;
import com.underdogCounty.underdogCountyProject.domain.work.Work;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Long> {

    // 작업물 사진을 카테고리별로 필터링 해주는 메소드
    List<Work> findByCategory(Category category);
}
