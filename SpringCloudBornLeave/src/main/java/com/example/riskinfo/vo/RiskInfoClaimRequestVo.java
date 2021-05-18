package com.example.riskinfo.vo;

import lombok.Data;

@Data
public class RiskInfoClaimRequestVo {
	// 查询的实体类
	private RiskClaimVo riskInfoClaimVo;
	
	private Integer pageNo;
	
	private Integer pageSize;
	
}
