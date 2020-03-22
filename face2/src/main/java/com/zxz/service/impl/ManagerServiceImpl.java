package com.zxz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czh.service.ManagerService;
import com.zxz.mapper.ManagerMapper;
import com.zxz.pojo.Manager;
@Service
public class ManagerServiceImpl implements ManagerService {
@Autowired
	ManagerMapper mmapper;
	public List<Manager> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public int logincheck(Manager manager) {
		System.out.println("’‚ «manager=================================");
		return mmapper.logincheck(manager);
	}

}
