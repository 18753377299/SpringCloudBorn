package com.example.riskinfo.po;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class RiskInfoClaim implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**序号*/
	private Integer serialNo;
	/**机构*/
	private String comCode;
	/**归属机构名称*/
	private String comCodeCName;
	/**维护人代码*/
	private String operatorCode;
	/**维护人名称*/
	private String operatorName;
	/**案例名称*/
	private String claimName;
	/**产品名称*/
	private String riskCname;
	/**出险年度*/
	private String claimYear;
	/**险种*/
	private String riskName;
	/**险种中文翻译*/
	private String  riskNameC;
	/**赔款金额*/
	private  BigDecimal  claimAmount;
	/**行业*/
	private String profession;
	/**案件来源*/
	private String sender;
	/**出险原因*/
	private String claimReason;
	/**案例模板*/
	private String url;
	/**有效标志位*/
	private String validStatus;
	/**有效标志位中文*/
	private String validStatusName;
	/**插入时间*/
	private Date insertTimeForHis;
	/**更新时间*/
	private Date operateTimeForHis;
	/**打回意见*/
	private String remark;
	
}
