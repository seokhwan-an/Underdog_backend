package com.underdogCounty.underdogCountyProject.domain.application.service;

import com.underdogCounty.underdogCountyProject.domain.application.entity.Application;
import com.underdogCounty.underdogCountyProject.domain.application.repository.ApplicationRepository;
import com.underdogCounty.underdogCountyProject.domain.application.request.ApplicationCreationRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application createApplication(ApplicationCreationRequest request){
        Application application = request.toEntity();
        BeanUtils.copyProperties(request,application);
        return applicationRepository.save(application);
    }

    public ApplicationCreationRequest readApplication(Long id){
        Optional<Application> application = applicationRepository.findById(id);
        if (application.isPresent()){
            Application applicationget= application.get();
            ApplicationCreationRequest creationRequest = ApplicationCreationRequest.builder()
                    .id(applicationget.getId())
                    .name(applicationget.getName())
                    .email(applicationget.getEmail())
                    .phonenumber(applicationget.getPhonenumber())
                    .contents(applicationget.getContents())
                    .build();
            return creationRequest;
        }
        throw new EntityNotFoundException(
                "신청서가 없습니다");
    }

    public List<ApplicationCreationRequest> readApplicationList(){
        List<Application> applications = applicationRepository.findAll();
        List<ApplicationCreationRequest> applicationCreationRequestList = new ArrayList<>();
        for (Application application : applications){
            ApplicationCreationRequest applicationCreationRequest = ApplicationCreationRequest.builder()
                    .id(application.getId())
                    .name(application.getName())
                    .email(application.getEmail())
                    .phonenumber(application.getPhonenumber())
                    .contents(application.getContents())
                    .build();
            applicationCreationRequestList.add(applicationCreationRequest);
        }
        return applicationCreationRequestList;
    }
}
