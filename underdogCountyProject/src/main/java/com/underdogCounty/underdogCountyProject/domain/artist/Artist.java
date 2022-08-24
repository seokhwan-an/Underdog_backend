package com.underdogCounty.underdogCountyProject.domain.artist;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.underdogCounty.underdogCountyProject.domain.work.Work;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String agency;

    @NotNull
    private String contents;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Work> workList = new ArrayList<>();

}
