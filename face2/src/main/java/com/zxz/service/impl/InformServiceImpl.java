package com.zxz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czh.service.InformService;
import com.zxz.mapper.InformMapper;
import com.zxz.pojo.Inform;
@Service
public class InformServiceImpl implements InformService {
	@Autowired
	InformMapper informMapper;
	
	public List<Inform> list() {
		System.out.println("1111111111111111111111111");
		return informMapper.list();
	}

	public int add(Inform inform) {
		// TODO Auto-generated method stub
		return informMapper.add(inform);
	}
	


}
