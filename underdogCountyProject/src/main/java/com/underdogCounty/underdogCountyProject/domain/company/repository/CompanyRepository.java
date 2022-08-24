package com.underdogCounty.underdogCountyProject.domain.company.repository;

import com.underdogCounty.underdogCountyProject.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
