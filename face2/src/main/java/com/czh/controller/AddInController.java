package com.czh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.czh.service.InformService;
import com.zxz.pojo.Dept;
import com.zxz.pojo.Inform;


/**
 * Servlet implementation class identifyUser
 */
@Controller
@RequestMapping("/one")
public class AddInController {
	@Autowired
	InformService informService;
	@RequestMapping("/addInform")
	public void listCategory(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		String i_topic = request.getParameter("i_topic");
		String i_article = request.getParameter("i_article");
		String i_date = request.getParameter("i_date");
		String i_name = request.getParameter("i_name");
		System.out.println(i_topic);
		Inform inform = new Inform();
		inform.setI_topic(i_topic);
		inform.setI_article(i_article);
		inform.setI_date(i_date);
		inform.setI_name(i_name);
		int num = informService.add(inform);
		if(num > 0) {
			response.sendRedirect("../index.jsp");
		}
 
		
		//// 鏀惧叆杞彂鍙傛暟
		//mav.addObject("cs", cs);
		// 鏀惧叆jsp璺緞
		//mav.setViewName("listCategory");
		//System.out.println("hhhhhhhhhhhhhhhhhhhhhhh");
		//return str;
	}
/*    @RequestMapping(value = "/identifyUser")
	public void identifyUser(HttpServletRequest request,HttpServletResponse response) throws IOException, InterruptedException{
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		PrintWriter pw= response.getWriter();
		System.out.println("fffffffffffffff");
		String imgStr = request.getParameter("imgStr");
		
		BaiduFaceAPI baiduApi = new BaiduFaceAPI();
		JSONObject obj=  baiduApi.identifyUserBybase64(imgStr);//返回百度云的计算结果
		System.out.println(obj.toString());
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result_num = obj.getInt("result_num");//人脸个数
		if(result_num == 1){
			JSONObject result0 = obj.getJSONArray("result").getJSONObject(0);
			resultMap.put("result", "true");
			double score = result0.getJSONArray("scores").getDouble(0);//与人脸库中最相似的人脸的相似度
			if(score>=85){//暂且设为如果大于85则可以认为是同一个人
				resultMap.put("user",result0.getString("user_info"));
			}else{
				resultMap.put("user","404");
			}
		}else{
			resultMap.put("result","false");
		}
		//pw.write(net.sf.json.JSONObject.fromObject(resultMap).toString());
		pw.flush();
		pw.close();
	}*/


}
