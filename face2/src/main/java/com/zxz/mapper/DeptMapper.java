package com.zxz.mapper;

import java.util.List;

import com.zxz.pojo.Dept;

public interface DeptMapper {
	   public int add(Dept category);  
       
	      
	    public void delete(int id);  
	       
	      
	    public Dept get(int id);  
	     
	      
	    public int update(Dept category);   
	       
	      
	    public List<Dept> list();
	    
	      
	    public int count(); 
}
