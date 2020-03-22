package com.czh.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zxz.pojo.Dept;
import com.zxz.pojo.State;

@Component
public interface StateService {
	List<State> list();
	
}
