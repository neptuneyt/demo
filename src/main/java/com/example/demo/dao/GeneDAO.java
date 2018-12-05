package com.example.demo.dao;

import com.example.demo.model.Gene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: zoud
 * @Date: 2018/12/4
 **/

@Repository /* 指定这个接口是用来进行数据操作 */
public interface GeneDAO extends JpaRepository<Gene, Integer> {

}
