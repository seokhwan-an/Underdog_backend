package com.underdogCounty.underdogCountyProject.domain.work.Controller;

import com.underdogCounty.underdogCountyProject.domain.artist.entity.Artist;
import com.underdogCounty.underdogCountyProject.domain.work.Category;
import com.underdogCounty.underdogCountyProject.domain.work.Work;
import com.underdogCounty.underdogCountyProject.domain.work.dto.WorkRequestDto;
import com.underdogCounty.underdogCountyProject.domain.work.dto.WorkResponseDto;
import com.underdogCounty.underdogCountyProject.domain.work.service.WorkService;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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
@RequestMapping("api/work")
@RestController
public class WorkController {

    private final WorkService workService;

    @PostMapping()
    public Work create(@RequestBody WorkRequestDto workRequestDto) {
        return workService.create(workRequestDto);
    }

    @GetMapping()
    public List<WorkResponseDto> getAll() {
        return workService.getAll();
    }

    @GetMapping("{id}")
    public WorkResponseDto getOne(@PathVariable Long id) {
        return workService.getOne(id);
    }

    @GetMapping("/category")
    public List<WorkResponseDto> getCategory(@RequestParam Category name) {
        return workService.getCategory(name);
    }

    @PutMapping("{id}")
    public WorkRequestDto update(@PathVariable Long id,
        @RequestBody WorkRequestDto workRequestDto) {
        return workService.update(id, workRequestDto);
    }

    @DeleteMapping("{id}")
    public Long delete(@PathVariable Long id) {
        return workService.delete(id);
    }

    @PostMapping(value = "s3/{workId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Work saveS3Image(@PathVariable Long workId,
        @RequestParam(value = "profile") MultipartFile image) throws IOException {
        return workService.uploadS3Image(workId, image);
    }

    @DeleteMapping(value = "s3/{workId}")
    public Work deleteS3Image(@PathVariable Long workId) {
        return workService.deleteS3Image(workId);
    }
}
