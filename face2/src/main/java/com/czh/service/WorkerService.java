package com.czh.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zxz.pojo.Worker;
@Component
public interface WorkerService {
	List<Worker> list();

	int selectId(String userId);
}
