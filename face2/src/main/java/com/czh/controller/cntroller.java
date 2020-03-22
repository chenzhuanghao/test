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
import com.czh.service.DeptService;

import com.zxz.pojo.Dept;


/**
 * Servlet implementation class identifyUser
 */
@Controller
@RequestMapping("/one")
public class cntroller {
	@Autowired
	DeptService deptService;
	@RequestMapping("/listDept")
	public void listCategory(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
	    PrintWriter out = null;
		try {
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	   // PrintWriter out = response.getWriter();
		System.out.println("22222222222222222222");
		Map<String,Object> map = new HashMap<String,Object>();
		//List<Dept> ld = new ArrayList<Dept>();
		List<Dept> list= deptService.list();
		map.put("code", "0");
		map.put("msg", "");
		map.put("count", 2);
		map.put("data", list);
		String str = JSON.toJSONString(map);
		System.out.println(map.toString());
	    out.write(str);  
		
		//// 放入转发参数
		//mav.addObject("cs", cs);
		// 放入jsp路径
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
		JSONObject obj=  baiduApi.identifyUserBybase64(imgStr);//���ذٶ��Ƶļ�����
		System.out.println(obj.toString());
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result_num = obj.getInt("result_num");//��������
		if(result_num == 1){
			JSONObject result0 = obj.getJSONArray("result").getJSONObject(0);
			resultMap.put("result", "true");
			double score = result0.getJSONArray("scores").getDouble(0);//���������������Ƶ����������ƶ�
			if(score>=85){//������Ϊ�������85�������Ϊ��ͬһ����
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
