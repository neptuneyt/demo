package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: zoud
 * @Date: 2018/12/5
 **/

@Entity
@Data
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 128)
    private String speciesCommonName;

    @Column(length = 128)
    private String speciesLatinName;

    @Column(length = 128)
    private String speciesChineseName;

    @Column(length = 45)
    /*
    Plant, Animal, Bacteria, Fungi, Virus
     */
    private String speciesType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "species_id", referencedColumnName = "id")
    private List<Gene> geneList;

}
