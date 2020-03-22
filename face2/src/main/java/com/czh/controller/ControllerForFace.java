package com.czh.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.czh.service.SigninService;
import com.czh.service.WorkerService;
import com.zxz.pojo.Signin;
import com.zxz.pojo.State;
import com.zxz.pojo.Worker;

import entity.ApiEntity;
import entity.UserList;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/for-face")
public class ControllerForFace {
	@Autowired
	WorkerService workerservice;
	@Autowired
	SigninService signinService;
	@SuppressWarnings("null")
	@RequestMapping("/identify-user")
	public void identifyUser(HttpServletRequest request,HttpServletResponse response) throws IOException, InterruptedException{
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		PrintWriter pw= response.getWriter();
		//System.out.println("fffffffffffffff");
		String imgStr = request.getParameter("imgStr");
		//System.out.println(imgStr);
		BaiduFaceAPI baiduApi = new BaiduFaceAPI();
		org.json.JSONObject obj=  baiduApi.identifyUserBybase64(imgStr);//返回百度云的计算结果
		//System.out.println(obj.toString());
		ApiEntity apiEntity = JSON.parseObject(obj.toString(), ApiEntity.class);
		
		if(apiEntity.getResult() == null) {
			return;
		}
		UserList userList = apiEntity.getResult().getUser_list().get(0);
		BigDecimal scoreBig = userList.getScore();
		Integer score = scoreBig.intValue();
		Signin sin = new Signin();
		//State state = null;
		//Worker worker = null;
		String userId = "不符合资格";
		if(score >= 80) {

			// 获取信息并返回
			userId = userList.getUser_id();
			System.out.println(userId);
			//存入状态表
			int selectId = workerservice.selectId(userId);
			System.out.println(selectId);
			//worker.setUser_id(selectId);
			System.out.println("-----------------------");
			sin.setState(1);
			System.out.println("-----------------------");

			sin.setWorker(selectId);
			signinService.add(sin);
			
		}
			
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("user", userId);
		resultMap.put("result", "true");

		String jsonString =JSON.toJSONString(resultMap);
		pw.write(jsonString);
		pw.flush();
		pw.close();
	}
}
