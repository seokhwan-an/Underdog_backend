package com.underdogCounty.underdogCountyProject.domain.company.controller;

import com.underdogCounty.underdogCountyProject.domain.company.dto.CompanyDto;
import com.underdogCounty.underdogCountyProject.domain.company.service.CompanyService;
import com.underdogCounty.underdogCountyProject.domain.util.ResponseEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/companies")
@RestController
public class CompanyController {

  private final CompanyService companyService;

  @PostMapping
  public ResponseEntity<CompanyDto> create(CompanyDto companyDto) {
    return companyService.create(companyDto);
  }

  @GetMapping
  public ResponseEntity<List<CompanyDto>> getAll() {
    return companyService.getAll();
  }

  @GetMapping("{id}")
  public ResponseEntity<CompanyDto> getOne(@PathVariable Long id) {
    return companyService.getOne(id);
  }

  @PutMapping("{id}")
  public ResponseEntity<CompanyDto> update(@PathVariable Long id,
      @RequestBody CompanyDto companyDto) {
    return companyService.update(id, companyDto);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    return companyService.delete(id);
  }
}
