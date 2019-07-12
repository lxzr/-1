package com.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.dao.ArticleDao;
import com.pojo.Article;




@Service
public class ArticleService {
	@Autowired
	ArticleDao articleDao;
	public JSONObject getArticleByid(HttpServletRequest request) {
		String  page1=request.getParameter("page");
	      if(page1==null|page1=="") {
	    	  page1="1";
	      }
	      int page=Integer.valueOf(page1);
	      String   rows1=request.getParameter("rows");
	      if(rows1==null|rows1=="") {
	    	  rows1="10";//每页默认显示10个数
	      }
	      int rows=Integer.valueOf(rows1);
	      int start=(page-1)*rows;
		String ids=request.getParameter("ids");
		String[] staffIds = ids.split(",");
		List<Article> list=new ArrayList<Article>();
		int total=0;
		for (int i = 0; i < staffIds.length; i++) {
//			System.out.println(staffIds[i]+"haha");
			int id1=Integer.valueOf(staffIds[i]);
			//System.out.println(id1);
			List<Article> list1=articleDao.getArticleByid(id1);
			
			if(list1.size()>0) {
				for (int j = 0; j < list1.size(); j++) {
					list.add(list1.get(j));
					total=total+1;
				}
				
			}
			
		}
		//System.out.println(total);//一共3个
		List<Article> list3=new ArrayList<Article>();
//		System.out.println(list3.size());
		//System.out.println(start+rows);
		
		//为了只有一页的时候的操作
		
		if(list.size()>=(start+rows)) {
			for (int i = start; i <(start+rows); i++) {
				list3.add(list.get(i));
			}
		}
		else {
			for (int i = start; i <list.size(); i++) {
				list3.add(list.get(i));
			}
		}
		//System.out.println(total);
		 JSONObject res = new JSONObject();
		 res.put("total",total);
		  res.put("rows",list3);
		 // System.out.println(res);
		return res;
		
	}
	//新增功能
	public void addArticleByPid(HttpServletRequest request, MultipartFile file) {
		// TODO Auto-generated method stub
		
		int wid=Integer.valueOf(request.getParameter("id"));
		String head=request.getParameter("head");
		String text=request.getParameter("text");
       String picture=saveFile(request, file);
	   Article article=new Article();
		article.setWid(wid);
		article.setHead(head);
		article.setHeatNumber(0);
		article.setText(text);
		article.setPictureAddress(picture);
		articleDao.addArticleByPid(article);
	
		
		
	}
	
	private String saveFile(HttpServletRequest request,MultipartFile file) {
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				// 保存的文件路径(如果用的是Tomcat服务器，文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中
				// )
				///String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
				//String s1=System.getProperty("user.dir");
				//String filePath=s1+"\\src\\main\\resources"+"\\upload\\";
			  //String basePath = request.getServletContext().getRealPath("upload/");
			  //
				//String basePath=path +"static/upload/";
				//String uploadDir=ResourceUtils.getURL("classpath:").getPath()+"static/upload/";
				//String filePath = basePath + file.getOriginalFilename();
				///String basePath = request.getServletContext().getRealPath("templates/");
		        //System.out.println(basePath);
				//list.add(file.getOriginalFilename());	
		        String filePath="upload\\"+file.getOriginalFilename();
				System.out.println(filePath+"nihao");
				File saveDir = new File(filePath);
//				if (!saveDir.getParentFile().exists())
//					saveDir.getParentFile().mkdirs();
//registry
//				// 转存文件
				
				file.transferTo(saveDir);
				return file.getOriginalFilename();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return file.getOriginalFilename();
	}

	
	//删除所选的所有id的内容
	public void removeByArticleid(HttpServletRequest request) {
		// TODO Auto-generated method stub
	
		String ids=request.getParameter("ids");
		
		String[] staffIds = ids.split(",");
		for (String id : staffIds) {
			System.out.println(id);
			int id1=Integer.valueOf(id);
			articleDao.removeByArticleid(id1);
		}
	
		
	}
	//找到当前点击的文章返回给页面
	public JSONObject selectOneArticleByid(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int id=Integer.valueOf(request.getParameter("id"));
		JSONObject res = new JSONObject();
		res.put("oneArtice", articleDao.selectOneArticleByid(id));
		return res;
	}
//////////刷新功能
	public void UpdataOneArticleByid(HttpServletRequest request, MultipartFile file) {
		// TODO Auto-generated method stub
		
		int id=Integer.valueOf(request.getParameter("id"));
		String head=request.getParameter("head");
		String text=request.getParameter("text");
		//String picture="";
//		System.out.println(id+head+text);
//		System.out.println("是否到这里；了");
//		if(file!=""&file!=null)
       String picture=saveFile(request, file);
	   Article article=new Article();
	   article.setId(id);
		article.setHead(head);
		//article.setHeatNumber(0);
		article.setText(text);
		article.setPictureAddress(picture);
		
//		int id=Integer.valueOf(request.getParameter("id"));
////		int wid=Integer.valueOf(request.getParameter("wid"));
//		String head=request.getParameter("head");
//		String text=request.getParameter("text");
//		Article article=new Article();
//		String picture=saveFile(request, file);
//		article.setId(id);
////		article.setWid(wid);
//		article.setHead(head);
//	//	article.setHeatNumber(0);
//		article.setText(text);
//		article.setPictureAddress(picture);
		if(picture==""|picture==null) {
			articleDao.UpdataOneArticleByid1(article);
		}
		
		else {
			articleDao.UpdataOneArticleByid(article);
		}
	}
	
}
