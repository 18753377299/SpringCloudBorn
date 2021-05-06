package com.example.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.common.filter.ErrorZuulFilter;
import com.example.common.filter.PostZuulFilter;
import com.example.common.filter.PreZuulFilter;
import com.example.common.filter.RouteZuulFilter;

/*进行zuul过滤器的配置*/
@Configuration
public class ZuulConfig {

	
	/*将PreZuulFilter加入到请求拦截队列*/
	@Bean
	public PreZuulFilter preZuulFilter() {  
	    return new PreZuulFilter();  
	} 
	@Bean
	public ErrorZuulFilter errorZuulFilter() {  
	    return new ErrorZuulFilter();  
	}  
	@Bean
	public PostZuulFilter postZuulFilter() {  
	    return new PostZuulFilter();  
	} 
	@Bean
	public RouteZuulFilter routeZuulFilter() {  
	    return new RouteZuulFilter();  
	}  

}
