package com.underdogCounty.underdogCountyProject.domain.artist.service;

import com.underdogCounty.underdogCountyProject.domain.artist.dto.ArtistRequestDto;
import com.underdogCounty.underdogCountyProject.domain.artist.dto.ArtistResponseDto;
import com.underdogCounty.underdogCountyProject.domain.artist.entity.Artist;
import com.underdogCounty.underdogCountyProject.domain.artist.repository.ArtistRepository;
import com.underdogCounty.underdogCountyProject.domain.util.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class ArtistService {

  private final ArtistRepository artistRepository;

  public ResponseEntity<ArtistRequestDto> create(ArtistRequestDto artistRequestDto) {
    Artist artist = new Artist();
    artist.requestToEntity(artistRequestDto);
    artistRepository.save(artist);
    return new ResponseEntity<>(HttpStatus.CREATED, artistRequestDto);
  }

  public ResponseEntity<List<ArtistResponseDto>> getAll() {
    List<Artist> artists = artistRepository.findAll();
    List<ArtistResponseDto> result = artists.stream()
        .map(s -> new ArtistResponseDto().entityToResponse(s)).collect(
            Collectors.toList());
    return new ResponseEntity<>(HttpStatus.OK, result);
  }

  public ResponseEntity<ArtistResponseDto> getOne(Long id) {
    Optional<Artist> artist = artistRepository.findById(id);
    if (!artist.isPresent()) {
      throw new IllegalStateException("해당 아티스트가 존재하지 않습니다.");
    }
    ArtistResponseDto result = new ArtistResponseDto().entityToResponse(artist.get());
    return new ResponseEntity<>(HttpStatus.OK, result);
  }

  public ResponseEntity<ArtistRequestDto> update(Long id, ArtistRequestDto artistRequestDto) {
    Optional<Artist> artist = artistRepository.findById(id);
    if (!artist.isPresent()) {
      throw new IllegalStateException("해당 아티스트가 존재하지 않습니다.");
    }
    artist.get().requestToEntity(artistRequestDto);
    return new ResponseEntity<>(HttpStatus.OK, artistRequestDto);
  }

  public ResponseEntity<Void> delete(Long id) {
    Optional<Artist> artist = artistRepository.findById(id);
    if (!artist.isPresent()) {
      throw new IllegalStateException("해당 아티스트가 존재하지 않습니다.");
    }
    artistRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK,null);
  }
}
