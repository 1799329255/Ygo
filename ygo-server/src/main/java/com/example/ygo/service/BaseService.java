package com.example.ygo.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className BaseService
 * @description TODO
 * @since 2022/1/25 13:57
 */
public interface BaseService<Model, PK extends Serializable> {

    Model findById(PK id);

    List<Model> findAll();

    int add(Model model,Enum... selective);

    int update(Model model,Enum... selective);

    int deleteById(PK id);

    int logicalDeleteById(PK id);
}
