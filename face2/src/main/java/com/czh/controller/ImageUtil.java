package com.czh.controller;

import sun.misc.BASE64Decoder;

public class ImageUtil {
    public static byte[] base64StrToByteArray(String imgStr)  
    {   //���ֽ������ַ�������Base64���벢����ͼƬ  
        if (imgStr == null) //ͼ������Ϊ��  
            return null;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64����  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//�����쳣����  
                    b[i]+=256;  
                }  
            }  
            return b;
        }   
        catch (Exception e)   
        {  
            return null;  
        }  
    } 

}
