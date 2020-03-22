package com.czh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.aip.face.AipFace;
import com.zxz.pojo.Dept;
import com.zxz.pojo.Worker;

import entity.User;

@Controller
@RequestMapping("/re-face")
public class RegisterFace {
	User user=new User();
	Worker worker = new Worker();
	Dept de = new Dept();
	@RequestMapping("/register-user")

	public void identifyUser(HttpServletRequest request,HttpServletResponse response) throws IOException, InterruptedException{
		response.setHeader("Content-Type", "application/x-www-form-urlencoded");
	    final String APP_ID = "14464575";
	    final String API_KEY = "XfWhr7AhQ8ctFDZ3juuqjv5j";
	    final String SECRET_KEY = "gDtUKGMdUeuRw4bzGrDhfzOCLHFGbBz5";
	    AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
		String yingwenname=request.getParameter("yingwenname");
		String uname=request.getParameter("username");
		String job=request.getParameter("job");
		String s=request.getParameter("sal");
		int sal = Integer.parseInt(s);
		String c=request.getParameter("comm");
		int comm = Integer.parseInt(c);
		String dept=request.getParameter("dept");
		int deptid = Integer.parseInt(dept);
		de.setDept_id(deptid);
		String imageup=request.getParameter("dataURL");
		worker.setUser_pass(yingwenname);
		worker.setUname(uname);
		worker.setJob(job);
		worker.setSal(sal);
		worker.setComm(comm);
		worker.setDept(de);
		//System.out.println(username);
		//System.out.println(imageup);
		user.setUsername(yingwenname);
		user.setImageup(imageup);
		sample(client);
	    

	}
	public void sample(AipFace client) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("user_info", user.getUsername());
		System.out.println("ffffffffffffffff");
	    
	    String image =user.getImageup() ;
	    String imageType = "BASE64";
	    String groupId = "group1";
	    String userId = user.getUsername();
	    
	    // 人脸注册
	    JSONObject res = client.addUser(image, imageType, groupId, userId, options);
	    System.out.println(res.toString(2));

	}
}
