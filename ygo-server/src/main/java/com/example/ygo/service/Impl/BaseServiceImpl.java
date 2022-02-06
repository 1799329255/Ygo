package com.example.ygo.service.Impl;

import com.example.ygo.dao.BaseMapper;
import com.example.ygo.service.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className BaseServiceImpl
 * @description TODO
 * @since 2022/1/25 13:59
 */
public abstract class BaseServiceImpl<Model, PK extends Serializable, E> implements BaseService<Model, PK> {

    public abstract BaseMapper<Model,PK,E> getBaseMapper();

    @Override
    public Model findById(PK id) {
        return getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    public List<Model> findAll() {
        return getBaseMapper().selectByExample(null);
    }

    @Override
    public int add(Model model,Enum... selective) {
        return getBaseMapper().insertSelective(model,selective);
    }

    @Override
    public int update(Model model,Enum... selective) {
        return getBaseMapper().updateByPrimaryKeySelective(model,selective);
    }

    @Override
    public int deleteById(PK id) {
        return getBaseMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int logicalDeleteById(PK id) {
        return getBaseMapper().logicalDeleteByPrimaryKey(id);
    }
}
