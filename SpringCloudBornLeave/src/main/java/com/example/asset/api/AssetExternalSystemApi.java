package com.example.asset.api;

import com.example.common.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="资产管理调用外系统模块")
public class AssetExternalSystemApi {

    @ApiOperation(value="根据员工编号或者员工姓名调用员工系统进行分页查询,外系统:员工系统",
            notes = "staffCodeName: 员工工号或姓名;queryType:查询类型（1：个人，2：权限所属下）")
    public ResultResponse queryStaffInfoById(String staffCodeName, String queryType){
        return null;
    }
    @ApiOperation(value="根据编码类型调用数据字典查询信息,外系统: 数据字典",
            notes = "codeType: 使用类型编码类型")
    public ResultResponse queryRiskDcodeByCodeType(String codeType){
        return null;
    }

}
