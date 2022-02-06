package com.example.ygo.dao;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * DAO公共基类，由MybatisGenerator自动生成请勿修改
 * @param <Model> The Model Class 这里是泛型不是Model类
 * @param <PK> The Primary Key Class 如果是无主键，则可以用Model来跳过，如果是多主键则是Key类
 * @param <E> The Example Class
 */
public interface BaseMapper<Model, PK extends Serializable, E> {
    long countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(PK id);

    int insert(Model record);

    int insertSelective(@Param("record") Model record,  @Param("selective") Enum ... selective);

    Model selectOneByExample(E example);

    Model selectOneByExampleSelective(@Param("example") E example, @Param("selective") Enum ... selective);

    List<Model> selectByExampleSelective(@Param("example") E example, @Param("selective") Enum ... selective);

    List<Model> selectByExample(E example);

    Model selectByPrimaryKeySelective(@Param("id") PK id, @Param("selective") Enum ... selective);

    Model selectByPrimaryKey(PK id);

    Model selectByPrimaryKeyWithLogicalDelete(@Param("id") PK id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Model record, @Param("example") E example ,@Param("selective") Enum ... selective);

    int updateByExample(@Param("record") Model record, @Param("example") E example);

    int updateByPrimaryKeySelective(Model record, @Param("selective") Enum ... selective);

    int updateByPrimaryKey(Model record);

    int batchInsert(@Param("list") List<Model> list);

    int batchInsertSelective(@Param("list") List<Model> list, @Param("selective") Enum ... selective);

    int logicalDeleteByExample(@Param("example") E example);

    int logicalDeleteByPrimaryKey(PK id);
}