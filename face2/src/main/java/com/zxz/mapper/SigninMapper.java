package com.zxz.mapper;

import java.util.List;

import com.zxz.pojo.Dept;
import com.zxz.pojo.Signin;

public interface SigninMapper {
	   public int add(Signin signin);  
       
	      
	    public void delete(int id);  
	       
	      
	    public Signin get(int id);  
	     
	      
	    public int update(Signin signin);   
	       
	      
	    public List<Signin> list();
	    
	      
	    public int count(); 
}
