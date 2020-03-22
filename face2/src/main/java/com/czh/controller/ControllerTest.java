package com.czh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("")
public class ControllerTest {
	@RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
       
        return null;
    }
	
	@RequestMapping("/jsonTest")
	public void test(HttpServletRequest request,HttpServletResponse response){
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map1 = new HashMap<String,Object>();
		Map<String,Object> map2 = new HashMap<String,Object>();
		map1.put("id", "10001");
		map1.put("username", "杜甫");
		map1.put("email", "xianxin@layui.com");
		map1.put("sex", "男");
		map1.put("city", "江杭州");
		map1.put("sign", "点击此处，显示更多。当内容超出时，点击单元格会自动显示更多内容。");
		map1.put("experience", "116");
		map1.put("ip", "192.168.0.8");
		map1.put("logins", "108");
		map1.put("joinTime", "2016-10-14");

		map2.put("id", "10001");
		map2.put("username", "杜甫");
		map2.put("email", "xianxin@layui.com");
		map2.put("sex", "男");
		map2.put("city", "江杭州");
		map2.put("sign", "点击此处，显示更多。当内容超出时，点击单元格会自动显示更多内容。");
		map2.put("experience", "116");
		map2.put("ip", "192.168.0.8");
		map2.put("logins", "108");
		map2.put("joinTime", "2016-10-14");
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(map1);
		list.add(map2);
		map.put("code", "0");
		map.put("msg", "");
		map.put("count", 2);
		map.put("data", list);
		String str = JSON.toJSONString(map);
		System.out.println(map.toString());
	    out.write(str);
	}
}