package com.example.riskinfo.po;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class RiskCheckMainLog {
	
	private Integer logId;
	/**归属机构*/
	private String comCode;
	/** 投保单号码 */
	private String proposalNo;
	/** 保单号 */
	private String policyNo;
	/** 险种代码 */
	private String riskCode;
	private String insuredType;
    private String insuredCode;
    private String insuredName;
    /**巡检人代码*/
    private String checker;
    
    private String checkModel;
    
    /** 业务状态 */
   	private String checkerStatus;
   	private String addressDetail;
	private BigDecimal pointx2000;
    private BigDecimal pointy2000;
    private BigDecimal pointx02;
    private BigDecimal pointy02;
    private Timestamp insertTimeForHis;
    private Timestamp operateTimeForHis;
    
    private String riskCheckNo;
    
    private Date checkDate;
}
