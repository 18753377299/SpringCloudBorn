package com.example.service;

import java.util.List;

import org.SpringCloudBorn_api.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.impl.DeptClientServiceFallbackFactory;

@FeignClient(value="EUREKA-CLIENT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
	
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Dept dept);
	
}