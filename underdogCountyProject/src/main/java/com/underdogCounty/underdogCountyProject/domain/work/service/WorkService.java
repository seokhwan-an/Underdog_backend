package com.underdogCounty.underdogCountyProject.domain.work.service;

import com.underdogCounty.underdogCountyProject.domain.work.Work;
import com.underdogCounty.underdogCountyProject.domain.work.dto.WorkRequestDto;
import com.underdogCounty.underdogCountyProject.domain.work.dto.WorkResponseDto;
import com.underdogCounty.underdogCountyProject.domain.work.repository.WorkRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Service
public class WorkService {

    private final WorkRepository workRepository;

    public Work create(WorkRequestDto workRequestDto) {
        Work work = new Work();
        work.requestToEntity(workRequestDto);
        workRepository.save(work);
        return work;
    }

    public List<WorkResponseDto> getAll() {
        List<Work> works = workRepository.findAll();
        List<WorkResponseDto> result = works.stream()
            .map(s -> new WorkResponseDto().entityToResponse(s))
            .collect(Collectors.toList());
        return result;
    }
}
