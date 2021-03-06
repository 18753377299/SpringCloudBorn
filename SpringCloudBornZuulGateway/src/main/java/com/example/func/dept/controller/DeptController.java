package com.example.func.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DeptController {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value="/dept/get/{id}",method= {RequestMethod.POST,RequestMethod.GET})
	public String get(@PathVariable("id") Long id) {
		
		System.out.println("=======================================getin_zuul");
		
		return "success";
		
	}
	
//	服务发现：Discovery
	@RequestMapping(value="/dept/discovery", method= {RequestMethod.POST,RequestMethod.GET})
	public Object discovery() {
		//盘点eureka里面有多少微服务
		List<String> list = discoveryClient.getServices();
		System.out.println("======================"+list);
		List<ServiceInstance> serviceInstances =discoveryClient.getInstances("eureka-client");
		for(ServiceInstance sInstance:serviceInstances) {
			System.out.println(sInstance.getServiceId()+":"+
					sInstance.getHost()+":"+sInstance.getPort()+":"+sInstance.getUri());
		}
//		this.discoveryClient
		return this.discoveryClient;
	}
	

	
}
