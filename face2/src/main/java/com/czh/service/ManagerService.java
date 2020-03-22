package com.czh.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zxz.pojo.Dept;
import com.zxz.pojo.Manager;

@Component
public interface ManagerService {
	List<Manager> list();
	int logincheck(Manager manager);
	
}
