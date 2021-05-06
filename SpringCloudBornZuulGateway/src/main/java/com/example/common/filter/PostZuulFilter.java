package com.example.common.filter;


import com.netflix.zuul.ZuulFilter;

/*3.路由到微服务之后执行*/
public class PostZuulFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		System.out.println("PostZuulFilter");
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
