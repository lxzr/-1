package com.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pojo.Header;
import com.service.HeaderService;

@RestController
public class HeaderConller {
	@Autowired
	HeaderService headerservice;
	//这里做的是利用循环递归查询的所有的header信息
	@RequestMapping("/getHeader")
	@ResponseBody
	public List<Header> getHeader(){
		int pid=0;
		
	    System.out.println("来了");
	    
		return headerservice.getHeader1(pid);
	}
	//这里是做的查询，还有分页没有做
	@RequestMapping("/getHeaderByPid")
	@ResponseBody
	public JSONObject getHeaderByPid(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="id",required = false) String id
			) throws IOException{
//		@RequestParam(value="pId",required = false) String pId
       int pId=Integer.valueOf(id);
//       headerservice.getHeaderByPid(request,pd);
      // System.out.println(pid);
//		int pid=0;
		return headerservice.getHeaderByPid(request,response,pId);
	}
	//这里做的是添加功能
	@RequestMapping("/addHeaderByPid")
	@ResponseBody
	public void addHeaderByPid(HttpServletRequest request) {
//			@RequestParam(value="id",required = false) String id){
//		 int pid=Integer.valueOf(id);
	  String id=request.getParameter("id");
	  int pid=Integer.valueOf(id);
	  String header=request.getParameter("Header");
//	  String header=request.getParameter("header");
		headerservice.addHeaderByPid(pid,header);
	}
	@RequestMapping("/removeHeaderByid")
	@ResponseBody
	public void  removeHeaderByid(HttpServletRequest request ) {
		headerservice.removeHeaderByid(request);
	}
	@RequestMapping("/changeHeaderByid")
	@ResponseBody
	public void changeHeaderByid(HttpServletRequest request) {
		headerservice.changeHeaderByid(request);
	}
	@RequestMapping("/selectone")
	@ResponseBody
	public String selectone(HttpServletRequest request) {
		 String header=headerservice.selectone(request);
		 System.out.println(header);
		 return header;
	}
}
