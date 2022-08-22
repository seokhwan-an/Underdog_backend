package com.underdogCounty.underdogCountyProject.domain.application.request;

import lombok.Data;

@Data
public class ApplicationCreationRequest {
    private String name;
    private String email;
    private String phonenumber;
    private String contents;
}
