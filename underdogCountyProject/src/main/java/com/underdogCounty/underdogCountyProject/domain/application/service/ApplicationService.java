package com.underdogCounty.underdogCountyProject.domain.application.service;

import com.underdogCounty.underdogCountyProject.domain.application.dto.ApplicationRequestDto;
import com.underdogCounty.underdogCountyProject.domain.application.dto.ApplicationResponseDto;
import com.underdogCounty.underdogCountyProject.domain.application.entity.Application;
import com.underdogCounty.underdogCountyProject.domain.application.repository.ApplicationRepository;
import com.underdogCounty.underdogCountyProject.domain.exception.WrongEmail;
import com.underdogCounty.underdogCountyProject.domain.exception.WrongPhoneNumber;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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
    private static final String SUBJECT_SENDME = "[언더독 카운티]외주제작 신청서가 도착했습니다";
    private static final String SUBJECT_SENDCLIENT = "[언더독 카운티]요청하신 신청서 내용입니다";
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PHONENUMBER_PATTERN = "\\d{3}-\\d{4}-\\d{4}";

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application createApplication(ApplicationRequestDto applicationRequestDto) {
        String email = applicationRequestDto.getEmail();
        patternValidation(applicationRequestDto, email);
        sendEmail(applicationRequestDto);
        Application application = ApplicationRequestDto.toEntity(applicationRequestDto);
        return applicationRepository.save(application);
    }

    private static void patternValidation(ApplicationRequestDto applicationRequestDto, String email) {
        if (!Pattern.matches(EMAIL_PATTERN, email)) {
            throw new WrongEmail();
        }
        if (!Pattern.matches(PHONENUMBER_PATTERN, applicationRequestDto.getPhoneNumber())){
            throw new WrongPhoneNumber();
        }
    }

    private void sendEmail(ApplicationRequestDto applicationRequestDto) {
        //이메일설정
        SimpleMailMessage message = new SimpleMailMessage();
        //이메일 내용 설정
        message.setText(
            "이름 : " + applicationRequestDto.getName() +
                "\n연락처 : " + applicationRequestDto.getPhoneNumber() +
                "\n이메일 : " + applicationRequestDto.getEmail() +
                "\n내용 : " + applicationRequestDto.getContents());
        //송신자설정
        message.setFrom(FROM_ADDRESS);
        //업체에서받는메일
        sendEmailToAdmin(applicationRequestDto, message);
        //신청자가 받는 메일
        sendEmailToClient(applicationRequestDto, message);
        javaMailSender.send(message);
    }

    private static void sendEmailToClient(ApplicationRequestDto applicationRequestDto, SimpleMailMessage message) {
        message.setTo(applicationRequestDto.getEmail());
        message.setSubject(SUBJECT_SENDCLIENT);
    }

    private void sendEmailToAdmin(ApplicationRequestDto applicationRequestDto, SimpleMailMessage message) {
        message.setTo(FROM_ADDRESS);
        message.setSubject(SUBJECT_SENDME);
        javaMailSender.send(message);
    }

    public ApplicationResponseDto readApplication(Long id) {
        Application application = applicationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return ApplicationResponseDto.toDto(application);
    }

    public List<ApplicationResponseDto> readApplications(String name) {
        List<Application> applications = findApplicationsByName(name);
        if (applications.isEmpty()) {
            throw new EntityNotFoundException("신청서가 없습니다");
        }
        return applications.stream()
            .map(
                application -> ApplicationResponseDto.toDto(application)
            )
            .collect(Collectors.toList());
    }

    private List<Application> findApplicationsByName(String name) {
        //name 파라미터가 null 이면 전부 가져옴
        if (name == null) {
            return applicationRepository.findAll();
        }
        //name 파라미터가 존재하면 필터링해 가져옴
        return applicationRepository.findAllByName(name);
    }

    public Application updateApplication(Long id, ApplicationRequestDto applicationRequestDto) {
        Application application = applicationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        application.update(applicationRequestDto);
        return applicationRepository.save(application);
    }

    public void deleteApplication(Long id) {
        Application application = applicationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        applicationRepository.delete(application);
    }


}
