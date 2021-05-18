package com.example.asset.dao;


import com.example.asset.po.AssetBaseInfo;

public interface AssetBaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AssetBaseInfo record);

    int insertSelective(AssetBaseInfo record);

    AssetBaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetBaseInfo record);

    int updateByPrimaryKey(AssetBaseInfo record);
}