package com.zxz.mapper;

import java.util.List;

import com.zxz.pojo.Dept;
import com.zxz.pojo.Inform;

public interface InformMapper {
	   public int add(Inform inform);  
       
	      
	    public void delete(int id);  
	       
	      
	    public Inform get(int id);  
	     
	      
	    public int update(Inform inform);   
	       
	      
	    public List<Inform> list();
	    
	      
	    public int count(); 
}
