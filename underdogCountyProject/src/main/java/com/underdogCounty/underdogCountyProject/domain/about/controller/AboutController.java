package com.underdogCounty.underdogCountyProject.domain.about.controller;

import com.underdogCounty.underdogCountyProject.domain.about.dto.AboutRequestDto;
import com.underdogCounty.underdogCountyProject.domain.about.dto.AboutResponseDto;
import com.underdogCounty.underdogCountyProject.domain.about.entity.About;
import com.underdogCounty.underdogCountyProject.domain.about.service.AboutService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${app-about}")
@RequiredArgsConstructor
public class AboutController {

    private final AboutService aboutService;

    @PostMapping
    public ResponseEntity<About> createAbout(@RequestBody AboutRequestDto aboutRequestDto) {
        return ResponseEntity.ok(aboutService.createAbout(aboutRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<AboutResponseDto>> readAbout() {
        return ResponseEntity.ok(aboutService.readAbout());
    }

    @PutMapping("/{id}")
    public ResponseEntity<About> updateAbout(@PathVariable Long id,
        @RequestBody AboutRequestDto aboutRequestDto) {
        return ResponseEntity.ok(aboutService.updateAbout(id, aboutRequestDto));
    }

    @DeleteMapping
    public void deleteAbout() {
        aboutService.deleteAbout();
    }

}
