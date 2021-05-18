package com.example.asset.po;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AssetBaseInfo implements Serializable {
    @ApiModelProperty(value = "资产信息表ID")
    private Integer id;

    @ApiModelProperty(value = "资产出厂编号(消耗品无,长度待定)")
    private String assetNo;

    @ApiModelProperty(value = "资产性质")
    private String assetNature;

    @ApiModelProperty(value = "资产种类")
    private String assetSort;

    @ApiModelProperty(value = "资产金额")
    private BigDecimal assetAmount;

    @ApiModelProperty(value = "资产数量")
    private Short assetQuantity;

    @ApiModelProperty(value = "资产状态")
    private String assetStatus;

    @ApiModelProperty(value = "资产归属机构")
    private String assetComcode;

    @ApiModelProperty(value = "父级资产编号（长度待定）")
    private String assetUpperNo;

    @ApiModelProperty(value = "资产购买日期")
    private Date assetBuyDate;

    @ApiModelProperty(value = "当前状态日期")
    private Date assetCurrentStatusDate;

    @ApiModelProperty(value = "使用类型")
    private String assetAttributeLevel;

    @ApiModelProperty(value = "资产保修期")
    private Short assetWarrantyPeriod;

    @ApiModelProperty(value = "使用次数")
    private Short assetUseNum;

    @ApiModelProperty(value = "信息备注")
    private String assetBackInfo;

    @ApiModelProperty(value = "插入时间")
    private Date insertTimeForHis;

    @ApiModelProperty(value = "更新时间")
    private Date operateTimeForHis;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo == null ? null : assetNo.trim();
    }

    public String getAssetNature() {
        return assetNature;
    }

    public void setAssetNature(String assetNature) {
        this.assetNature = assetNature == null ? null : assetNature.trim();
    }

    public String getAssetSort() {
        return assetSort;
    }

    public void setAssetSort(String assetSort) {
        this.assetSort = assetSort == null ? null : assetSort.trim();
    }

    public BigDecimal getAssetAmount() {
        return assetAmount;
    }

    public void setAssetAmount(BigDecimal assetAmount) {
        this.assetAmount = assetAmount;
    }

    public Short getAssetQuantity() {
        return assetQuantity;
    }

    public void setAssetQuantity(Short assetQuantity) {
        this.assetQuantity = assetQuantity;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus == null ? null : assetStatus.trim();
    }

    public String getAssetComcode() {
        return assetComcode;
    }

    public void setAssetComcode(String assetComcode) {
        this.assetComcode = assetComcode == null ? null : assetComcode.trim();
    }

    public String getAssetUpperNo() {
        return assetUpperNo;
    }

    public void setAssetUpperNo(String assetUpperNo) {
        this.assetUpperNo = assetUpperNo == null ? null : assetUpperNo.trim();
    }

    public Date getAssetBuyDate() {
        return assetBuyDate;
    }

    public void setAssetBuyDate(Date assetBuyDate) {
        this.assetBuyDate = assetBuyDate;
    }

    public Date getAssetCurrentStatusDate() {
        return assetCurrentStatusDate;
    }

    public void setAssetCurrentStatusDate(Date assetCurrentStatusDate) {
        this.assetCurrentStatusDate = assetCurrentStatusDate;
    }

    public String getAssetAttributeLevel() {
        return assetAttributeLevel;
    }

    public void setAssetAttributeLevel(String assetAttributeLevel) {
        this.assetAttributeLevel = assetAttributeLevel == null ? null : assetAttributeLevel.trim();
    }

    public Short getAssetWarrantyPeriod() {
        return assetWarrantyPeriod;
    }

    public void setAssetWarrantyPeriod(Short assetWarrantyPeriod) {
        this.assetWarrantyPeriod = assetWarrantyPeriod;
    }

    public Short getAssetUseNum() {
        return assetUseNum;
    }

    public void setAssetUseNum(Short assetUseNum) {
        this.assetUseNum = assetUseNum;
    }

    public String getAssetBackInfo() {
        return assetBackInfo;
    }

    public void setAssetBackInfo(String assetBackInfo) {
        this.assetBackInfo = assetBackInfo == null ? null : assetBackInfo.trim();
    }

    public Date getInsertTimeForHis() {
        return insertTimeForHis;
    }

    public void setInsertTimeForHis(Date insertTimeForHis) {
        this.insertTimeForHis = insertTimeForHis;
    }

    public Date getOperateTimeForHis() {
        return operateTimeForHis;
    }

    public void setOperateTimeForHis(Date operateTimeForHis) {
        this.operateTimeForHis = operateTimeForHis;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", assetNo=").append(assetNo);
        sb.append(", assetNature=").append(assetNature);
        sb.append(", assetSort=").append(assetSort);
        sb.append(", assetAmount=").append(assetAmount);
        sb.append(", assetQuantity=").append(assetQuantity);
        sb.append(", assetStatus=").append(assetStatus);
        sb.append(", assetComcode=").append(assetComcode);
        sb.append(", assetUpperNo=").append(assetUpperNo);
        sb.append(", assetBuyDate=").append(assetBuyDate);
        sb.append(", assetCurrentStatusDate=").append(assetCurrentStatusDate);
        sb.append(", assetAttributeLevel=").append(assetAttributeLevel);
        sb.append(", assetWarrantyPeriod=").append(assetWarrantyPeriod);
        sb.append(", assetUseNum=").append(assetUseNum);
        sb.append(", assetBackInfo=").append(assetBackInfo);
        sb.append(", insertTimeForHis=").append(insertTimeForHis);
        sb.append(", operateTimeForHis=").append(operateTimeForHis);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}