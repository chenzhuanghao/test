package com.zxz.mapper;

import java.util.List;

import com.zxz.pojo.Dept;
import com.zxz.pojo.State;

public interface StateMapper {
	   public int add(State category);  
       
	      
	    public void delete(int id);  
	       
	      
	    public State get(int id);  
	     
	      
	    public int update(State category);   
	       
	      
	    public List<State> list();
	    
	      
	    public int count(); 
}
