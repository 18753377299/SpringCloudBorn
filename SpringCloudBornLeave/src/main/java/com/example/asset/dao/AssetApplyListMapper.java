package com.example.asset.dao;


import com.example.asset.po.AssetApplyList;

public interface AssetApplyListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AssetApplyList record);

    int insertSelective(AssetApplyList record);

    AssetApplyList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetApplyList record);

    int updateByPrimaryKey(AssetApplyList record);
}