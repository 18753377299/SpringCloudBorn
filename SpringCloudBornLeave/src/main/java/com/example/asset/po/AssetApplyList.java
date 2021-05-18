package com.example.asset.po;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AssetApplyList implements Serializable {
    @ApiModelProperty(value = "资产申请清单表id")
    private Integer id;

    @ApiModelProperty(value = "资产申请表ID")
    private Integer assetApplyId;

    @ApiModelProperty(value = "资产使用员工工号")
    private String assetApplyStaffCode;

    @ApiModelProperty(value = "资产性质")
    private String assetNature;

    @ApiModelProperty(value = "资产种类")
    private String assetSort;

    @ApiModelProperty(value = "使用类型")
    private String assetAttributeLevel;

    @ApiModelProperty(value = "资产数量")
    private Short assetQuantity;

    @ApiModelProperty(value = "资产配置")
    private String assetConfig;

    @ApiModelProperty(value = "资产采买途径")
    private String assetBuyWay;

    @ApiModelProperty(value = "价格参考")
    private BigDecimal assetPriceReference;

    @ApiModelProperty(value = "资产备注")
    private String assetRemark;

    @ApiModelProperty(value = "订单信息")
    private String assetOrderInfo;

    @ApiModelProperty(value = "订单截图存储地址")
    private String assetOrderCutInfo;

    @ApiModelProperty(value = "资产出厂编号")
    private String assetNo;

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

    public Integer getAssetApplyId() {
        return assetApplyId;
    }

    public void setAssetApplyId(Integer assetApplyId) {
        this.assetApplyId = assetApplyId;
    }

    public String getAssetApplyStaffCode() {
        return assetApplyStaffCode;
    }

    public void setAssetApplyStaffCode(String assetApplyStaffCode) {
        this.assetApplyStaffCode = assetApplyStaffCode == null ? null : assetApplyStaffCode.trim();
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

    public String getAssetAttributeLevel() {
        return assetAttributeLevel;
    }

    public void setAssetAttributeLevel(String assetAttributeLevel) {
        this.assetAttributeLevel = assetAttributeLevel == null ? null : assetAttributeLevel.trim();
    }

    public Short getAssetQuantity() {
        return assetQuantity;
    }

    public void setAssetQuantity(Short assetQuantity) {
        this.assetQuantity = assetQuantity;
    }

    public String getAssetConfig() {
        return assetConfig;
    }

    public void setAssetConfig(String assetConfig) {
        this.assetConfig = assetConfig == null ? null : assetConfig.trim();
    }

    public String getAssetBuyWay() {
        return assetBuyWay;
    }

    public void setAssetBuyWay(String assetBuyWay) {
        this.assetBuyWay = assetBuyWay == null ? null : assetBuyWay.trim();
    }

    public BigDecimal getAssetPriceReference() {
        return assetPriceReference;
    }

    public void setAssetPriceReference(BigDecimal assetPriceReference) {
        this.assetPriceReference = assetPriceReference;
    }

    public String getAssetRemark() {
        return assetRemark;
    }

    public void setAssetRemark(String assetRemark) {
        this.assetRemark = assetRemark == null ? null : assetRemark.trim();
    }

    public String getAssetOrderInfo() {
        return assetOrderInfo;
    }

    public void setAssetOrderInfo(String assetOrderInfo) {
        this.assetOrderInfo = assetOrderInfo == null ? null : assetOrderInfo.trim();
    }

    public String getAssetOrderCutInfo() {
        return assetOrderCutInfo;
    }

    public void setAssetOrderCutInfo(String assetOrderCutInfo) {
        this.assetOrderCutInfo = assetOrderCutInfo == null ? null : assetOrderCutInfo.trim();
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo == null ? null : assetNo.trim();
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
        sb.append(", assetApplyId=").append(assetApplyId);
        sb.append(", assetApplyStaffCode=").append(assetApplyStaffCode);
        sb.append(", assetNature=").append(assetNature);
        sb.append(", assetSort=").append(assetSort);
        sb.append(", assetAttributeLevel=").append(assetAttributeLevel);
        sb.append(", assetQuantity=").append(assetQuantity);
        sb.append(", assetConfig=").append(assetConfig);
        sb.append(", assetBuyWay=").append(assetBuyWay);
        sb.append(", assetPriceReference=").append(assetPriceReference);
        sb.append(", assetRemark=").append(assetRemark);
        sb.append(", assetOrderInfo=").append(assetOrderInfo);
        sb.append(", assetOrderCutInfo=").append(assetOrderCutInfo);
        sb.append(", assetNo=").append(assetNo);
        sb.append(", insertTimeForHis=").append(insertTimeForHis);
        sb.append(", operateTimeForHis=").append(operateTimeForHis);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}