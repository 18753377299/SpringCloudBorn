package com.example.asset.dao;


import com.example.asset.po.AssetApprRuleConfig;

public interface AssetApprRuleConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AssetApprRuleConfig record);

    int insertSelective(AssetApprRuleConfig record);

    AssetApprRuleConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetApprRuleConfig record);

    int updateByPrimaryKey(AssetApprRuleConfig record);
}