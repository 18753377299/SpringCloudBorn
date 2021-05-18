package com.example.asset.po;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class AssetTrack implements Serializable {
    @ApiModelProperty(value = "资产轨迹表id")
    private Integer id;

    @ApiModelProperty(value = "资产信息表ID")
    private Integer assetId;

    @ApiModelProperty(value = "操作员工工号")
    private String assetOperateCode;

    @ApiModelProperty(value = "资产使用员工工号")
    private String assetStaffCode;

    @ApiModelProperty(value = "资产状态")
    private String assetStatus;

    @ApiModelProperty(value = "操作时间")
    private Date operateDate;

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

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getAssetOperateCode() {
        return assetOperateCode;
    }

    public void setAssetOperateCode(String assetOperateCode) {
        this.assetOperateCode = assetOperateCode == null ? null : assetOperateCode.trim();
    }

    public String getAssetStaffCode() {
        return assetStaffCode;
    }

    public void setAssetStaffCode(String assetStaffCode) {
        this.assetStaffCode = assetStaffCode == null ? null : assetStaffCode.trim();
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus == null ? null : assetStatus.trim();
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
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
        sb.append(", assetId=").append(assetId);
        sb.append(", assetOperateCode=").append(assetOperateCode);
        sb.append(", assetStaffCode=").append(assetStaffCode);
        sb.append(", assetStatus=").append(assetStatus);
        sb.append(", operateDate=").append(operateDate);
        sb.append(", insertTimeForHis=").append(insertTimeForHis);
        sb.append(", operateTimeForHis=").append(operateTimeForHis);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}