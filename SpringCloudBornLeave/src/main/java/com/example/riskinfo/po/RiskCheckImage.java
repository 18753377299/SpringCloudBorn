package com.example.riskinfo.po;

import lombok.Data;

import java.util.Date;

@Data
public class RiskCheckImage {
	
	private Integer id;
    private String riskCheckNo;
    private String imagType;
    private String imagTypeCName;
    private String imageId;
    private String imageName;
    private String imageUrl;
    private String remark;
    private Date insertTimeForHis;
    private Date operateTimeForHis;
    
	private RiskCheckMain riskCheckMain;
		
}
