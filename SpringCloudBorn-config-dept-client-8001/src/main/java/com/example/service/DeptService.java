package com.example.service;

import java.util.List;

import org.SpringCloudBorn_api.entities.Dept;

public interface DeptService
{
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
