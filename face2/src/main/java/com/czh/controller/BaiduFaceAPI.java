package com.czh.controller;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.util.Base64Util;

import sun.misc.BASE64Decoder;

public class BaiduFaceAPI {
    //设置APPID/AK/SK
    private static final String APP_ID = "14464575";
    private static final String API_KEY = "XfWhr7AhQ8ctFDZ3juuqjv5j";
    private static final String SECRET_KEY = "gDtUKGMdUeuRw4bzGrDhfzOCLHFGbBz5";
    //定义AipFace
	private AipFace client; 
    
	/**
	 * 构造函数，实例化AipFace
	 */
    public BaiduFaceAPI(){
    	client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);//建立连接的超时时间
        client.setSocketTimeoutInMillis(60000);//通过打开的连接传输数据的超时时间（单位：毫秒）
 
        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
        
    }//人脸识别。从人脸库中查找相似度最高的1张图片
    public JSONObject identifyUserBybase64(String base64Str){
    	/**
    	 * HashMap<String, String> options = new HashMap<String, String>();
			options.put("face_field", "age,beauty,expression,faceshape,gender,glasses,race,qualities");
			options.put("max_face_num", "2");
			options.put("face_type", "LIVE");
 
			// 图片数据
			String imgStr = Base64Util.encode(arg0);
			String imageType = "BASE64";
			JSONObject res = client.detect(imgStr, imageType, options);
			System.out.println(res.toString(2));
    	 */
    	 // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        //options.put("ext_fields", "faceliveness");//判断活体
        options.put("user_top_num", "1");
        String groupId = "group1";
        
        // 图片数据
        byte[] byt = ImageUtil.base64StrToByteArray(base64Str);
     	String imgStr = Base64Util.encode(byt);
     	String imageType = "BASE64";
     	String groupIdList = "group1";
//        return  client.detect(imgStr, imageType, options);
     	 return  client.search(imgStr, imageType, groupIdList,options);
    
     	
    }
 
 
}
