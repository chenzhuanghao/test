package com.czh.controller;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.util.Base64Util;

import sun.misc.BASE64Decoder;

public class BaiduFaceAPI {
    //����APPID/AK/SK
    private static final String APP_ID = "14464575";
    private static final String API_KEY = "XfWhr7AhQ8ctFDZ3juuqjv5j";
    private static final String SECRET_KEY = "gDtUKGMdUeuRw4bzGrDhfzOCLHFGbBz5";
    //����AipFace
	private AipFace client; 
    
	/**
	 * ���캯����ʵ����AipFace
	 */
    public BaiduFaceAPI(){
    	client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        // ��ѡ�������������Ӳ���
        client.setConnectionTimeoutInMillis(2000);//�������ӵĳ�ʱʱ��
        client.setSocketTimeoutInMillis(60000);//ͨ���򿪵����Ӵ������ݵĳ�ʱʱ�䣨��λ�����룩
 
        // ��ѡ�����ô����������ַ, http��socket��ѡһ�����߾�������
        //client.setHttpProxy("proxy_host", proxy_port);  // ����http����
        //client.setSocketProxy("proxy_host", proxy_port);  // ����socket����
        
    }//����ʶ�𡣴��������в������ƶ���ߵ�1��ͼƬ
    public JSONObject identifyUserBybase64(String base64Str){
    	/**
    	 * HashMap<String, String> options = new HashMap<String, String>();
			options.put("face_field", "age,beauty,expression,faceshape,gender,glasses,race,qualities");
			options.put("max_face_num", "2");
			options.put("face_type", "LIVE");
 
			// ͼƬ����
			String imgStr = Base64Util.encode(arg0);
			String imageType = "BASE64";
			JSONObject res = client.detect(imgStr, imageType, options);
			System.out.println(res.toString(2));
    	 */
    	 // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        //options.put("ext_fields", "faceliveness");//�жϻ���
        options.put("user_top_num", "1");
        String groupId = "group1";
        
        // ͼƬ����
        byte[] byt = ImageUtil.base64StrToByteArray(base64Str);
     	String imgStr = Base64Util.encode(byt);
     	String imageType = "BASE64";
     	String groupIdList = "group1";
//        return  client.detect(imgStr, imageType, options);
     	 return  client.search(imgStr, imageType, groupIdList,options);
    
     	
    }
 
 
}
