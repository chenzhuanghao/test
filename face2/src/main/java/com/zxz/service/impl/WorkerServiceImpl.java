package com.zxz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czh.service.WorkerService;
import com.zxz.mapper.WorkerMapper;
import com.zxz.pojo.Worker;
@Service
public class WorkerServiceImpl implements WorkerService {
	@Autowired
	WorkerMapper workermapper;

	public List<Worker> list() {
		// TODO Auto-generated method stub
		return workermapper.list();
	}

	public int selectId(String userId) {
		// TODO Auto-generated method stub
		return workermapper.selectId(userId);
	}

}
