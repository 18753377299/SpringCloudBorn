package com.example.riskinfo.po;

import lombok.Data;

import java.util.Date;

@Data
public class RiskCheckVenture {
	
	private String riskCheckNo;
    private String characteristics;
    private String rainRecord;
    private String itemDistance;
    private String comparedDegree;
    private String comparedTerrain;
    private String itemEnvironment;
    private String largeProjects;
    private String largeProImpact;
    private String waterSensitivity;
    private String underAssetsFlag;
    private String historicWater;
    private String manSituation;
    private String lowEquipment;
    private String ownership;
    private String constructBuild;
    private String airStorageFlag;
    private String buildYears;
    private String staggeredFlag;
    private String doorFlag;
    private String drainageMethod;
    private String drainageBlock;
    private String dredgeCondition;
    private String connectedFlag;
    private String unobstructedFlag;
    private String haveCanal;
    private String cargoWaterSen;
    private String stoForm;
    private String stoLocation;
    private String emiForm;
    private String conMaterials;
    private String draEquipment;
    private String conPlan;
    private String dutyFlag;
    private String monitorFlag;
    private String transferFlag;
    private Date insertTimeForHis;
    private Date operateTimeForHis;
	private RiskCheckMain riskCheckMain;
}
