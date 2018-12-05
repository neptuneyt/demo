package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: zoud
 * @Date: 2018/12/4
 **/

@Entity
@Data
public class Gene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30)
    private String geneAccession;

    @Column(length = 30)
    private String geneSymbol;

    @Column(length = 3)
    private String chrom;

    private long startPosition;

    private long endPosition;

    @Column(length = 2)
    private String strand;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "gene_id", referencedColumnName = "id")
    private List<Methylation> methylationList;

    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;
}
