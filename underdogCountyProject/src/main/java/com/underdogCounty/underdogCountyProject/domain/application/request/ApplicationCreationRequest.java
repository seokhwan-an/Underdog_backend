package com.underdogCounty.underdogCountyProject.domain.application.request;

import com.underdogCounty.underdogCountyProject.domain.application.entity.Application;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ApplicationCreationRequest {
    private Long id;
    private String name;
    private String email;
    private String phonenumber;
    private String contents;

    public Application toEntity(){
        Application build = Application.builder()
                .id(id)
                .name(name)
                .email(email)
                .phonenumber(phonenumber)
                .build();
        return build;
    }
    @Builder
    public ApplicationCreationRequest(Long id, String name, String email, String phonenumber, String contents){
        this.id=id;
        this.name=name;
        this.email=email;
        this.phonenumber=phonenumber;
        this.contents=contents;
    }
}
