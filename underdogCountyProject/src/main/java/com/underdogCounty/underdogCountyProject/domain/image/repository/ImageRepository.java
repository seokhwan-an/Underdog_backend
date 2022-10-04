package com.underdogCounty.underdogCountyProject.domain.image.repository;

import com.underdogCounty.underdogCountyProject.domain.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
