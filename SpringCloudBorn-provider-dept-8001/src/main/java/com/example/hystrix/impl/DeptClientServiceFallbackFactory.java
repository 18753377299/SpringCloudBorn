//package com.example.hystrix.impl;
//
//import com.example.hystrix.DeptClientService;
//import feign.hystrix.FallbackFactory;
//import org.SpringCloudBorn_api.entities.Dept;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{
//
//	@Override
//	public DeptClientService create(Throwable cause) {
//
//		return new DeptClientService() {
//
//			@Override
//			public List<Dept> list() {
//				System.out.println("===>没有对应的信息");
//				return null;
//			}
//
//			@Override
//			public Dept get(long id) {
//
//				return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
//						.setDb_source("no this database in MySQL");
//			}
//
//			@Override
//			public boolean add(Dept dept) {
//				return false;
//			}
//		};
//	}
//
//
//
//
//}
