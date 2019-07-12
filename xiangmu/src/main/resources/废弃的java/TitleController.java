//package com.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.fastjson.JSON;
//import com.pojo.Title;
//import com.service.TitleService;
//
//
//
//
//@RestController
//public class TitleController {
//	 @Autowired
//	 TitleService titleService;
//	 @RequestMapping("/getTitle")
//	 @ResponseBody
//	 public List<Title> getTitle(){
//		 List<Title> titles= titleService.getTitle();
//		 System.out.println(titles);
//		 return titles;
//	 }
//	 @RequestMapping("/addHeader1")
//	 @ResponseBody
//	 public void addHeader1(HttpServletRequest request, HttpServletResponse response){
//		 titleService.addHeader1(request, response);
//	 }
//
//}
