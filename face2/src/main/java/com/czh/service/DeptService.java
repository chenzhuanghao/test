package com.czh.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zxz.pojo.Dept;

@Component
public interface DeptService {
	List<Dept> list();
	
}
