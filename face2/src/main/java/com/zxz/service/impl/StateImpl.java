package com.zxz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czh.service.StateService;
import com.zxz.pojo.Dept;
import com.zxz.pojo.State;
@Service
public class StateImpl implements StateService {
	@Autowired
	StateImpl stateMapper;
	
	public List<State> list() {
		System.out.println("1111111111111111111111111");
		return stateMapper.list();
	}
	


}
