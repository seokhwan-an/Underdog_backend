package com.underdogCounty.underdogCountyProject.domain.artist;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.underdogCounty.underdogCountyProject.domain.work.Work;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    private String name;

    private String agency;

    private String contents;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Work> workList = new ArrayList<>();

}
