package com.example.controller;

import java.util.List;

import org.SpringCloudBorn_api.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.DeptService;

@RestController
//@Controller
public class DeptController{
	
	@Autowired
	private DeptService service;
	/*服务发现接口*/
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}
	/**
	 * @功能： 用于根据id进行查询
	 * */
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id)
	{
		return service.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return service.list();
	}

	/**
	 * @功能： 用于查找注册的所有的服务的名称，已经服务请求的信息
	 * */
//	@Autowired
//	private DiscoveryClient client;
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery(){
		try {
			System.out.println("===========================");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*盘点eureka中的微服务的*/
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		/*找到指定的微服务*/
		List<ServiceInstance> srvList = client.getInstances("SPRINGCLOUDBORN-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}
