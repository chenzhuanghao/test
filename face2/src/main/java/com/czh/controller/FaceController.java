package com.czh.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zxz.pojo.Dept;

@Controller
@RequestMapping("")
public class FaceController {
	@RequestMapping("/Face")
	public ModelAndView listCategory(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("trackingjs");
		return mav;
	}
}
