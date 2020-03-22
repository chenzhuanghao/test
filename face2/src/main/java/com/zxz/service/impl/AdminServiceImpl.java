package com.zxz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czh.service.AdminService;
import com.czh.service.DeptService;
import com.zxz.mapper.AdminMapper;
import com.zxz.mapper.DeptMapper;
import com.zxz.pojo.Admin;
import com.zxz.pojo.Dept;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper adminMapper;
	
	public List<Admin> list() {
		System.out.println("1111111111111111111111111");
		return adminMapper.list();
	}
	


}
