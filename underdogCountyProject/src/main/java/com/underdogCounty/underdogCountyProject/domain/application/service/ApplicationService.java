package com.underdogCounty.underdogCountyProject.domain.application.service;

import com.underdogCounty.underdogCountyProject.domain.application.entity.Application;
import com.underdogCounty.underdogCountyProject.domain.application.repository.ApplicationRepository;
import com.underdogCounty.underdogCountyProject.domain.application.request.ApplicationCreationRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    private JavaMailSender javaMailSender;
    private static final String FROM_ADDRESS = "rg970604@naver.com"; //여기에 대표자 이메일

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application createApplication(ApplicationCreationRequest request){
        Application application = request.toEntity();
        BeanUtils.copyProperties(request,application);
        //이메일설정
        SimpleMailMessage message = new SimpleMailMessage();
        //업체에서받는메일
        message.setFrom(FROM_ADDRESS);
        message.setTo(FROM_ADDRESS);
        message.setSubject("[언더독 카운티]외주제작 신청서가 도착했습니다");
        message.setText(
                "이름: "+application.getName()+
                "\n연락처: "+application.getPhonenumber()+
                "\n이메일: "+application.getEmail()+
                "\n내용: "+application.getContents());
        javaMailSender.send(message);
        //신청자가 받는 메일
        message.setTo(application.getEmail());
        message.setSubject("[언더독 카운티]요청하신 신청서 내용입니다");
        javaMailSender.send(message);
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
