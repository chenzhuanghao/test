package com.zxz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czh.service.DeptService;
import com.zxz.mapper.DeptMapper;
import com.zxz.pojo.Dept;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptMapper deptMapper;
	
	public List<Dept> list() {
		System.out.println("1111111111111111111111111");
		return deptMapper.list();
	}
	


}
