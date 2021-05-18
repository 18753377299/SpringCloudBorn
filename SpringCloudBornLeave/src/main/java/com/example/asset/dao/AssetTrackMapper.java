package com.example.asset.dao;


import com.example.asset.po.AssetTrack;

public interface AssetTrackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AssetTrack record);

    int insertSelective(AssetTrack record);

    AssetTrack selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetTrack record);

    int updateByPrimaryKey(AssetTrack record);
}