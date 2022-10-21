package com.underdogCounty.underdogCountyProject.domain.artist.controller;

import com.underdogCounty.underdogCountyProject.domain.artist.dto.ArtistRequestDto;
import com.underdogCounty.underdogCountyProject.domain.artist.dto.ArtistResponseDto;
import com.underdogCounty.underdogCountyProject.domain.artist.service.ArtistService;
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
@RequestMapping("api/artist")
@RestController
public class ArtistController {

  private final ArtistService artistService;

  @PostMapping()
  public ResponseEntity<ArtistRequestDto> create(@RequestBody ArtistRequestDto artistRequestDto) {
    return artistService.create(artistRequestDto);
  }

  @GetMapping()
  public ResponseEntity<List<ArtistResponseDto>> getAll() {
    return artistService.getAll();
  }

  @GetMapping("{id}")
  public ResponseEntity<ArtistResponseDto> getOne(@PathVariable Long id) {
    return artistService.getOne(id);
  }

  @PutMapping("{id}")
  public ResponseEntity<ArtistRequestDto> update(@PathVariable Long id,
      @RequestBody ArtistRequestDto artistRequestDto) {
    return artistService.update(id, artistRequestDto);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    return artistService.delete(id);
  }
}
