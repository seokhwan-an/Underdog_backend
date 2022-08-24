package com.underdogCounty.underdogCountyProject.domain.company;

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
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String contents;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Work> workList = new ArrayList<>();

}
