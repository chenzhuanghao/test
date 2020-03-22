package com.zxz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czh.service.SigninService;
import com.zxz.mapper.SigninMapper;
import com.zxz.pojo.Signin;
@Service
public class SigninServiceImpl implements SigninService {
	@Autowired
	SigninMapper signinmapper;
	public int add(Signin signin) {
		// TODO Auto-generated method stub
		return signinmapper.add(signin);
	}


}
