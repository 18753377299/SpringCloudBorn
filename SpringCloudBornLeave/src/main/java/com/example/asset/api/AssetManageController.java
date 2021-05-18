package com.example.asset.api;

import com.example.asset.vo.AssetLaunchPurchaseVo;
import com.example.asset.vo.AssetPurchaseQueryVo;
import com.example.common.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="资产管理采购管理模块")
public class AssetManageController {
   /** 采购申请 begin 20210206*/
    @ApiOperation(value="采购管理保存采购申请接口")
    public ResultResponse savePurchaseApply(AssetLaunchPurchaseVo assetLaunchPurchaseVo){
        return null;
    }
    @ApiOperation(value="采购管理提交采购申请接口，涉及activity审核流，更新executeId审核流标志位")
    public ResultResponse launchPurchaseApply(AssetLaunchPurchaseVo assetLaunchPurchaseVo){
        return null;
    }

    /** 采购申请 end 20210206*/

    /** 采购查询 begin 20210212*/
    @ApiOperation(value="采购管理采购申请分页查询接口")
    public ResultResponse queryPurchaseApplyByPage(AssetPurchaseQueryVo assetPurchaseQueryVo){
        return null;
    }
    @ApiOperation(value="采购管理采购申请根据任务ID查询详细信息")
    public ResultResponse queryPurchaseApplyInfoById(Integer id){
        return null;
    }
    @ApiOperation(value="根据任务ID删除采购管理采购申请")
    public ResultResponse deletePurchaseApplyById(Integer id){
        return null;
    }

//    @ApiOperation(value="根据申请任务ID查询资产采购清单信息",notes="id:采购申请任务的id信息")
//    public ResultResponse queryPurchaseListById(Integer id){
//        return null;
//    }
    @ApiOperation(value="查询资产采购历史流程信息",
            notes="executeId:采购申请任务executeId信息")
    public ResultResponse queryPurchaseProcessInfo(String  executeId){
        return new ResultResponse();
    }
    /** 采购查询 end 20210212*/

}
