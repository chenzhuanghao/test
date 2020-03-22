package com.zxz.mapper;

import java.util.List;

import com.zxz.pojo.State;
import com.zxz.pojo.Worker;

public interface WorkerMapper {
	   public int add(Worker worker);  
       
	      
	    public void delete(int id);  
	       
	      
	    public Worker get(int id);  
	     
	      
	    public int update(State category);   
	       
	      
	    public List<Worker> list();
	    
	      
	    public int count();


		public int selectId(String user_pass); 
}
