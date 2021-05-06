package com.example.controller;

import org.SpringCloudBorn_api.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {
	@Autowired
	private DeptService service;

	@GetMapping(value = "/dept/get/{id}")
	//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id){
		Dept dept = null;
//         int result = 1/0;
		try {
			dept = service.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null == dept) {
			throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
		}
		return dept;
	}


	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		System.out.println("===>processHystrix_Get");
		return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}
	
}