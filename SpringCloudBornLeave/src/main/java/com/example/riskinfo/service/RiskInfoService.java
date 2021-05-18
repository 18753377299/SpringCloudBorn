package com.example.riskinfo.service;

import com.example.common.ResponseResult;
import com.example.riskinfo.dao.RiskCheckMainDao;
import com.example.riskinfo.dao.RiskInfoClaimDao;
import com.example.riskinfo.po.RiskCheckMain;
import com.example.riskinfo.po.RiskInfoClaim;
import com.example.riskinfo.vo.RiskInfoClaimRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskInfoService {
	
	@Autowired
	RiskInfoClaimDao riskInfoClaimDao;
	
	@Autowired
	RiskCheckMainDao riskCheckMainDao;
	
	public ResponseResult queryRiskInfoClaim(RiskInfoClaimRequestVo riskInfoClaimRequestVo) {
		ResponseResult responseResult =new ResponseResult();
		
		try {
//			RiskInfoClaim riskInfoClaimNew =new RiskInfoClaim();
//			RiskClaimVo riskClaimVo = riskInfoClaimRequestVo.getRiskInfoClaimVo();
			//进行字段的复制
//			BeanUtils.copyProperties(riskInfoClaimNew, riskClaimVo);
			//通过分页查询出典型案例信息
			List<RiskInfoClaim> riskInfoClaimList = riskInfoClaimDao.queryRiskInfoClaim(riskInfoClaimRequestVo);
			// 查询出典型案例信息的总数
			Integer totalCount = riskInfoClaimDao.queryCountRiskInfoClaim(riskInfoClaimRequestVo);
			responseResult.setTotalCount(totalCount);
			responseResult.setResult(riskInfoClaimList);
			responseResult.setStatusCode("1");
			responseResult.setMessage("查询典型案例成功！");
		} catch (Exception e) {
			e.printStackTrace();
			responseResult.setStatusCode("2");
			responseResult.setMessage("查询典型案例失败！");
		}
		return responseResult;
	}
	
	/**
	 * 风控巡检信息查询
	 * */
	public ResponseResult queryRiskCheckMain() {
		ResponseResult responseResult =new ResponseResult();
		List<RiskCheckMain> riskCheckMains = riskCheckMainDao.queryRiskCheckMain();
		for(RiskCheckMain main:riskCheckMains) {
			System.out.println(main.getRiskCheckNo()+":"+main.getAddressDetail());
		}
		responseResult.setResult(riskCheckMains);
		return responseResult;
	}
	
	
	
}
