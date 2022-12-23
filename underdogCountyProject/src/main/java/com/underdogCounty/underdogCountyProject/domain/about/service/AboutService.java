package com.underdogCounty.underdogCountyProject.domain.about.service;

import com.underdogCounty.underdogCountyProject.domain.about.dto.AboutRequestDto;
import com.underdogCounty.underdogCountyProject.domain.about.dto.AboutResponseDto;
import com.underdogCounty.underdogCountyProject.domain.about.entity.About;
import com.underdogCounty.underdogCountyProject.domain.about.repository.AboutRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AboutService {

    private final AboutRepository aboutRepository;

    public About createAbout(AboutRequestDto aboutRequestDto) {
        About about = aboutRequestDto.toEntity(aboutRequestDto);
        return aboutRepository.save(about);
    }

    public About updateAbout(Long id, AboutRequestDto aboutRequestDto) {
        About about = aboutRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        about.update(aboutRequestDto);
        return aboutRepository.save(about);
    }

    public List<AboutResponseDto> readAbout() {
        List<About> abouts = aboutRepository.findAll();
        return abouts.stream()
            .map(
                about -> AboutResponseDto.toDto(about)
            )
            .collect(Collectors.toList());
    }

    public void deleteAbout(){
        List<About> abouts = aboutRepository.findAll();
        abouts.stream().forEach(
            about -> aboutRepository.delete(about)
        );
    }

}
