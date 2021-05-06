package com.example.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/*1.请求被路由之前被调用，身份验证*/

public class PreZuulFilter extends  ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(PreZuulFilter.class);

	@Override
	public Object run() {
		System.out.println("================PreZuulFilter");
		RequestContext requestContext =RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		
		System.out.println(request.getMethod()+":"+request.getRemoteHost()+":"+request.getRemotePort()+request.getRequestURI());		
		logger.info(String.format("send %s request to %s",
				request.getMethod(),request.getRequestURL()));
		String  token = request.getHeader("token");
		token="啊我鹅";
		//校验失败
		if(!checkToken(token)) {
			logger.error("校验token失败");
			HttpServletResponse response =requestContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8"); //设置相应格式
			response.setStatus(401);
			//令zuul过滤该请求，不对其进行路由
			requestContext.setSendZuulResponse(false);
			//设置http状态码
//			requestContext.setResponseStatusCode(401);
			requestContext.setResponse(response);
			return null;
		}
		logger.info("token验证成功！");
		return null;
	}
    public boolean checkToken(String token) {
    	if(StringUtils.isBlank(token)||"undefined".equals(token)||
    			"null".equals(token)) {
    		return false;
    	}
    	return true;
    }
    
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		//返回boolean确定filter是否执行
		return true;
	}

}
