package com.zxz.mapper;

import java.util.List;

import com.zxz.pojo.Dept;
import com.zxz.pojo.Manager;

public interface ManagerMapper {
	   public int add(Manager manager);  
       
	      
	    public void delete(int id);  
	       
	      
	    public Manager get(int id);  
	     
	      
	    public int update(Manager manager);   
	       
	      
	    public List<Manager> list();
	    
	      
	    public int count();


		public int logincheck(Manager manager); 
}
