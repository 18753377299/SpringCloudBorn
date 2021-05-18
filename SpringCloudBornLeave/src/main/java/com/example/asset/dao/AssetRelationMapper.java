package com.example.asset.dao;


import com.example.asset.po.AssetRelation;

public interface AssetRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AssetRelation record);

    int insertSelective(AssetRelation record);

    AssetRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetRelation record);

    int updateByPrimaryKey(AssetRelation record);
}