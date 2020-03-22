package com.zxz.mapper;

import java.util.List;

import com.zxz.pojo.Admin;

public interface AdminMapper {
	   public int add(Admin category);  
       
	      
	    public void delete(int id);  
	       
	      
	    public Admin get(int id);  
	     
	      
	    public int update(Admin category);   
	       
	      
	    public List<Admin> list();
	    
	      
	    public int count(); 
}
