package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: zoud
 * @Date: 2018/12/5
 **/

@Entity
@Data
public class Methylation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 128)
    private String sample;
    private Float mcgLevelUp;
    private Float mcgLevelBody;
    private Float mcgLevelDown;
    private Float mchLevelUp;
    private Float mchLevelBody;
    private Float mchLevelDown;
    private Float mcLevelUp;
    private Float mcLevelDown;
    private Float mcLevelBody;

    @ManyToOne
    @JoinColumn(name="gene_id")
    private Gene gene;
}
