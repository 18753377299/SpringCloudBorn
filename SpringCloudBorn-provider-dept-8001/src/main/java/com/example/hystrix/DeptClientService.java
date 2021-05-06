package com.example.hystrix;

import com.example.hystrix.impl.DeptClientServiceImpl;
import org.SpringCloudBorn_api.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(value="SPRINGCLOUDBORN-DEPT",fallbackFactory= DeptClientServiceImpl.class)
public interface DeptClientService {
	
	@GetMapping(value = "/dept/get/{id}")
	public Dept get(@PathVariable("id") long id);

	@GetMapping(value = "/dept/list")
	public List<Dept> list();

	@PostMapping(value = "/dept/add")
	public boolean add(Dept dept);


}
