package com.example.riskinfo.api;

import com.example.common.ResponseResult;
import com.example.riskinfo.service.RiskInfoService;
import com.example.riskinfo.vo.RiskInfoClaimRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/riskinfo-api")
public class RiskInfoApi {
	
	@Autowired
    RiskInfoService riskInfoService;
	
	/**
	 * 查询典型案例
	 * */
	
	@RequestMapping(value="/queryRiskInfoClaim",method={RequestMethod.GET,RequestMethod.POST})
	public ResponseResult queryRiskInfoClaim(@RequestBody RiskInfoClaimRequestVo riskInfoClaimRequestVo) {
		ResponseResult responseResult =new ResponseResult();
		System.out.println("success");
		responseResult =  riskInfoService.queryRiskInfoClaim(riskInfoClaimRequestVo);
		return responseResult;
	}
	
	/**
	 * 查询风控巡检信息
	 * */
	@RequestMapping(value="/queryRiskCheckMain",method={RequestMethod.GET,RequestMethod.POST})
	public ResponseResult queryRiskCheckMain() {
//		@RequestBody RiskInfoClaimRequestVo riskInfoClaimRequestVo
		ResponseResult responseResult =new ResponseResult();
		System.out.println("queryRiskCheckMain");
		responseResult =  riskInfoService.queryRiskCheckMain();
		return responseResult;
	}
	
}
