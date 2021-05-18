package com.example.asset.po;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AssetApprRuleConfig implements Serializable {
    @ApiModelProperty(value = "审批规则配置表id")
    private Integer id;

    @ApiModelProperty(value = "审核类型")
    private String assetCheckType;

    @ApiModelProperty(value = "审核人员代码")
    private String assetCheckPersonCode;

    @ApiModelProperty(value = "审核人员名称")
    private String assetCheckPersonName;

    @ApiModelProperty(value = "申请对象")
    private String assetApplyObject;

    @ApiModelProperty(value = "资产性质：消耗品、固定资产")
    private String assetNature;

    @ApiModelProperty(value = "最小金额")
    private BigDecimal assetMinAmount;

    @ApiModelProperty(value = "最大金额")
    private BigDecimal assetMaxAmount;

    @ApiModelProperty(value = "审核规则")
    private String assetCheckRule;

    @ApiModelProperty(value = "维护日期")
    private Date assetDefendDate;

    @ApiModelProperty(value = "维护人员")
    private String assetDefendCode;

    @ApiModelProperty(value = "审核是否有效标志")
    private String isValidateFlag;

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

    public String getAssetCheckType() {
        return assetCheckType;
    }

    public void setAssetCheckType(String assetCheckType) {
        this.assetCheckType = assetCheckType == null ? null : assetCheckType.trim();
    }

    public String getAssetCheckPersonCode() {
        return assetCheckPersonCode;
    }

    public void setAssetCheckPersonCode(String assetCheckPersonCode) {
        this.assetCheckPersonCode = assetCheckPersonCode == null ? null : assetCheckPersonCode.trim();
    }

    public String getAssetCheckPersonName() {
        return assetCheckPersonName;
    }

    public void setAssetCheckPersonName(String assetCheckPersonName) {
        this.assetCheckPersonName = assetCheckPersonName == null ? null : assetCheckPersonName.trim();
    }

    public String getAssetApplyObject() {
        return assetApplyObject;
    }

    public void setAssetApplyObject(String assetApplyObject) {
        this.assetApplyObject = assetApplyObject == null ? null : assetApplyObject.trim();
    }

    public String getAssetNature() {
        return assetNature;
    }

    public void setAssetNature(String assetNature) {
        this.assetNature = assetNature == null ? null : assetNature.trim();
    }

    public BigDecimal getAssetMinAmount() {
        return assetMinAmount;
    }

    public void setAssetMinAmount(BigDecimal assetMinAmount) {
        this.assetMinAmount = assetMinAmount;
    }

    public BigDecimal getAssetMaxAmount() {
        return assetMaxAmount;
    }

    public void setAssetMaxAmount(BigDecimal assetMaxAmount) {
        this.assetMaxAmount = assetMaxAmount;
    }

    public String getAssetCheckRule() {
        return assetCheckRule;
    }

    public void setAssetCheckRule(String assetCheckRule) {
        this.assetCheckRule = assetCheckRule == null ? null : assetCheckRule.trim();
    }

    public Date getAssetDefendDate() {
        return assetDefendDate;
    }

    public void setAssetDefendDate(Date assetDefendDate) {
        this.assetDefendDate = assetDefendDate;
    }

    public String getAssetDefendCode() {
        return assetDefendCode;
    }

    public void setAssetDefendCode(String assetDefendCode) {
        this.assetDefendCode = assetDefendCode == null ? null : assetDefendCode.trim();
    }

    public String getIsValidateFlag() {
        return isValidateFlag;
    }

    public void setIsValidateFlag(String isValidateFlag) {
        this.isValidateFlag = isValidateFlag == null ? null : isValidateFlag.trim();
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
        sb.append(", assetCheckType=").append(assetCheckType);
        sb.append(", assetCheckPersonCode=").append(assetCheckPersonCode);
        sb.append(", assetCheckPersonName=").append(assetCheckPersonName);
        sb.append(", assetApplyObject=").append(assetApplyObject);
        sb.append(", assetNature=").append(assetNature);
        sb.append(", assetMinAmount=").append(assetMinAmount);
        sb.append(", assetMaxAmount=").append(assetMaxAmount);
        sb.append(", assetCheckRule=").append(assetCheckRule);
        sb.append(", assetDefendDate=").append(assetDefendDate);
        sb.append(", assetDefendCode=").append(assetDefendCode);
        sb.append(", isValidateFlag=").append(isValidateFlag);
        sb.append(", insertTimeForHis=").append(insertTimeForHis);
        sb.append(", operateTimeForHis=").append(operateTimeForHis);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}