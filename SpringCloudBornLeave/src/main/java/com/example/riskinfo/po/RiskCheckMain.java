package com.example.riskinfo.po;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RiskCheckMain {
	
	private String riskCheckNo;
    private String comCode;
    private String checkModel;
    private String insuredType;
    private String insuredCode;
    private String insuredName;
    private String addressProvince;
	private String addressCity;
	private String addressCounty;
    private String addressDetail;
    private String addressCode;
    private String businessSource;
    private String businessClass;
    private String unitNature;
    private String operatorCode;
    private String operatorCodeUni;
    private Date undwrtsubmitDate;
    private String underwriteFlag;
    private Date underwriteDate;
    private String underwriteCode;
    private String underwriteName;
    private String checkComCode;
    private String checker;
    private Date checkDate;
    private Timestamp madeDate;
    private String mobileFlag;
    private String highlightRisk;
    private BigDecimal score;
    private String executionId;
    private String repulseSugggest;
    private BigDecimal pointx2000;
    private BigDecimal pointy2000;
    private BigDecimal pointx02;
    private BigDecimal pointy02;
    private Date insertTimeForHis;
    private Date operateTimeForHis;
    
	private List<RiskCheckAssess> riskCheckAssessList = new ArrayList<RiskCheckAssess>(0);
	private List<RiskCheckImage> riskCheckImageList = new ArrayList<RiskCheckImage>(0);
	private List<RiskCheckVenture> riskCheckVentureList = new ArrayList<RiskCheckVenture>(0);

	
}
