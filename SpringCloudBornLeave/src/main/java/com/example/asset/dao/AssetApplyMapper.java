package com.example.asset.dao;


import com.example.asset.po.AssetApply;

public interface AssetApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AssetApply record);

    int insertSelective(AssetApply record);

    AssetApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetApply record);

    int updateByPrimaryKey(AssetApply record);
}