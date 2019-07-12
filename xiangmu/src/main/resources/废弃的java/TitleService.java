//package com.service;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.dao.TitleDao;
//import com.pojo.Title;
//
//
//@Service
//public class TitleService {
//	@Autowired
//	TitleDao titledao;
//	//功能1，获取所有的节点（标题）
//	public List<Title> getTitle(){
//		return titledao.getTitle(0);
//		
//	}
//	//功能2，增加一个根节点
//	public Integer addHeader1(HttpServletRequest request, HttpServletResponse response){
//	String text=request.getParameter("titlename");
//	System.out.println(text);
//		return titledao.addHeader1(0,text);
//	}
//	
//}
