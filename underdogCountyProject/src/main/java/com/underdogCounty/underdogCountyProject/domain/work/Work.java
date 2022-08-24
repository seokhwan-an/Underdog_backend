package com.underdogCounty.underdogCountyProject.domain.work;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.underdogCounty.underdogCountyProject.domain.artist.Artist;
import com.underdogCounty.underdogCountyProject.domain.company.Company;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "work")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String originFileName;

    @NotNull
    private String filePath;

    @NotNull
    private Long fileSize;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Category category;

    @ManyToOne(targetEntity = Company.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonBackReference
    private Company company;

    @ManyToOne(targetEntity = Artist.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    @JsonBackReference
    private Artist artist;
}
