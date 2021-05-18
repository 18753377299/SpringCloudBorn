package com.example.asset.po;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AssetApply implements Serializable {
    @ApiModelProperty(value = "资产申请表id")
    private Integer id;

    @ApiModelProperty(value = "申请类型")
    private String assetApplyType;

    @ApiModelProperty(value = "申请原因")
    private String assetApplyReason;

    @ApiModelProperty(value = "申请人员工号")
    private String assetApplyStaffCode;

    @ApiModelProperty(value = "申请人员姓名")
    private String assetApplyStaffName;

    @ApiModelProperty(value = "资产总金额")
    private BigDecimal assetTotalAmount;

    @ApiModelProperty(value = "审核状态")
    private String assetUnderwriteStatus;

    @ApiModelProperty(value = "申请日期")
    private Date assetSubmitDate;

    @ApiModelProperty(value = "办结日期")
    private Date assetDealDate;

    @ApiModelProperty(value = "审核流程id")
    private String assetExecuteId;

    @ApiModelProperty(value = "操作人员工号")
    private String assetStaffCode;

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

    public String getAssetApplyType() {
        return assetApplyType;
    }

    public void setAssetApplyType(String assetApplyType) {
        this.assetApplyType = assetApplyType == null ? null : assetApplyType.trim();
    }

    public String getAssetApplyReason() {
        return assetApplyReason;
    }

    public void setAssetApplyReason(String assetApplyReason) {
        this.assetApplyReason = assetApplyReason == null ? null : assetApplyReason.trim();
    }

    public String getAssetApplyStaffCode() {
        return assetApplyStaffCode;
    }

    public void setAssetApplyStaffCode(String assetApplyStaffCode) {
        this.assetApplyStaffCode = assetApplyStaffCode == null ? null : assetApplyStaffCode.trim();
    }

    public String getAssetApplyStaffName() {
        return assetApplyStaffName;
    }

    public void setAssetApplyStaffName(String assetApplyStaffName) {
        this.assetApplyStaffName = assetApplyStaffName == null ? null : assetApplyStaffName.trim();
    }

    public BigDecimal getAssetTotalAmount() {
        return assetTotalAmount;
    }

    public void setAssetTotalAmount(BigDecimal assetTotalAmount) {
        this.assetTotalAmount = assetTotalAmount;
    }

    public String getAssetUnderwriteStatus() {
        return assetUnderwriteStatus;
    }

    public void setAssetUnderwriteStatus(String assetUnderwriteStatus) {
        this.assetUnderwriteStatus = assetUnderwriteStatus == null ? null : assetUnderwriteStatus.trim();
    }

    public Date getAssetSubmitDate() {
        return assetSubmitDate;
    }

    public void setAssetSubmitDate(Date assetSubmitDate) {
        this.assetSubmitDate = assetSubmitDate;
    }

    public Date getAssetDealDate() {
        return assetDealDate;
    }

    public void setAssetDealDate(Date assetDealDate) {
        this.assetDealDate = assetDealDate;
    }

    public String getAssetExecuteId() {
        return assetExecuteId;
    }

    public void setAssetExecuteId(String assetExecuteId) {
        this.assetExecuteId = assetExecuteId == null ? null : assetExecuteId.trim();
    }

    public String getAssetStaffCode() {
        return assetStaffCode;
    }

    public void setAssetStaffCode(String assetStaffCode) {
        this.assetStaffCode = assetStaffCode == null ? null : assetStaffCode.trim();
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
        sb.append(", assetApplyType=").append(assetApplyType);
        sb.append(", assetApplyReason=").append(assetApplyReason);
        sb.append(", assetApplyStaffCode=").append(assetApplyStaffCode);
        sb.append(", assetApplyStaffName=").append(assetApplyStaffName);
        sb.append(", assetTotalAmount=").append(assetTotalAmount);
        sb.append(", assetUnderwriteStatus=").append(assetUnderwriteStatus);
        sb.append(", assetSubmitDate=").append(assetSubmitDate);
        sb.append(", assetDealDate=").append(assetDealDate);
        sb.append(", assetExecuteId=").append(assetExecuteId);
        sb.append(", assetStaffCode=").append(assetStaffCode);
        sb.append(", insertTimeForHis=").append(insertTimeForHis);
        sb.append(", operateTimeForHis=").append(operateTimeForHis);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}