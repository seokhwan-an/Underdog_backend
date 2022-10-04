package com.underdogCounty.underdogCountyProject.domain.image.entity;

import com.underdogCounty.underdogCountyProject.domain.image.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Image {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotEmpty
    private String originalFileName;

    @NotEmpty
    private String storedFilePath;

    @Enumerated
    private Type type;
}
