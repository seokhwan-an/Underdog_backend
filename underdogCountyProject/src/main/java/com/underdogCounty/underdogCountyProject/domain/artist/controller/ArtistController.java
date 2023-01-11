package com.underdogCounty.underdogCountyProject.domain.artist.controller;

import com.underdogCounty.underdogCountyProject.domain.artist.dto.ArtistRequestDto;
import com.underdogCounty.underdogCountyProject.domain.artist.dto.ArtistResponseDto;
import com.underdogCounty.underdogCountyProject.domain.artist.entity.Artist;
import com.underdogCounty.underdogCountyProject.domain.artist.service.ArtistService;
import com.underdogCounty.underdogCountyProject.domain.util.ResponseEntity;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("api/artist")
@RestController
public class ArtistController {

    private final ArtistService artistService;

    @PostMapping()
    public Artist create(@RequestBody ArtistRequestDto artistRequestDto) {
        return artistService.create(artistRequestDto);
    }

    @GetMapping()
    public List<ArtistResponseDto> getAll() {
        return artistService.getAll();
    }

    @GetMapping("{id}")
    public ArtistResponseDto getOne(@PathVariable Long id) {
        return artistService.getOne(id);
    }

    @PutMapping("{id}")
    public ArtistRequestDto update(@PathVariable Long id,
        @RequestBody ArtistRequestDto artistRequestDto) {
        return artistService.update(id, artistRequestDto);
    }

    @DeleteMapping("{id}")
    public Long delete(@PathVariable Long id) {
        artistService.delete(id);
        return id;
    }

    @PostMapping(value = "s3/{artistId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Artist saveS3Image(@PathVariable Long artistId,
        @RequestParam(value = "profile") MultipartFile image) throws IOException {
        return artistService.uploadS3Image(artistId, image);
    }

    @DeleteMapping(value = "s3/{artistId}")
    public Artist deleteS3Image(@PathVariable Long artistId) {
        return artistService.deleteS3Image(artistId);
    }

}
