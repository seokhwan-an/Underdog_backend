package com.underdogCounty.underdogCountyProject.domain.company.service;

import com.underdogCounty.underdogCountyProject.domain.company.dto.CompanyDto;
import com.underdogCounty.underdogCountyProject.domain.company.entity.Company;
import com.underdogCounty.underdogCountyProject.domain.company.repository.CompanyRepository;
import com.underdogCounty.underdogCountyProject.domain.util.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CompanyService {

  private final CompanyRepository companyRepository;

  //생성
  @Transactional
  public ResponseEntity<CompanyDto> create(CompanyDto companyDto) {
    Company company = dtoToEntity(companyDto);
    companyRepository.save(company);
    return new ResponseEntity<>(HttpStatus.CREATED, companyDto);
  }

  //조회
  public ResponseEntity<List<CompanyDto>> getAll() {
    List<Company> companies = companyRepository.findAll();
    List<CompanyDto> result = companies.stream().map(this::entityToDto)
        .collect(Collectors.toList());
    return new ResponseEntity<>(HttpStatus.OK, result);
  }

  //특정조회
  public ResponseEntity<CompanyDto> getOne(Long id) {
    Optional<Company> company = companyRepository.findById(id);
    if (!company.isPresent()) {
      throw new IllegalArgumentException("없는 협업회사입니다.");
    }
    CompanyDto result = entityToDto(company.get());
    return new ResponseEntity<>(HttpStatus.OK, result);
  }

  //수정
  @Transactional
  public ResponseEntity<CompanyDto> update(Long id, CompanyDto companyDto) {
    Optional<Company> company = companyRepository.findById(id);
    if (!company.isPresent()) {
      throw new IllegalArgumentException("없는 협업회사입니다.");
    }
    Company updateCompany = Company.builder()
        .id(id)
        .name(companyDto.getName())
        .contents(companyDto.getContent())
        .build();
    companyRepository.save(updateCompany);
    return new ResponseEntity<>(HttpStatus.OK, companyDto);
  }

  @Transactional
  public ResponseEntity<Void> delete(Long id) {
    Optional<Company> company = companyRepository.findById(id);
    if (!company.isPresent()) {
      throw new IllegalArgumentException("없는 협업회사입니다.");
    }
    companyRepository.delete(company.get());
    return new ResponseEntity<>(HttpStatus.OK,null);
  }

  private Company dtoToEntity(CompanyDto companyDto) {
    return Company.builder()
        .name(companyDto.getName())
        .contents(companyDto.getContent())
        .build();
  }

  private CompanyDto entityToDto(Company company) {
    return CompanyDto.builder()
        .id(company.getId())
        .name(company.getName())
        .content(company.getContents())
        .build();
  }

}
