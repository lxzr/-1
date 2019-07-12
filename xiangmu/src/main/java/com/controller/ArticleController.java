package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.pojo.Article;
import com.service.ArticleService;

@RestController
public class ArticleController {
	@Autowired
	ArticleService articleService;
	@RequestMapping("/getArticleByid")
	public JSONObject getArticleByid(HttpServletRequest requset){
		
		
		return  articleService.getArticleByid(requset);
	}
	@RequestMapping("/addArticleByPid")
	//添加文章
	public void addArticleByPid(HttpServletRequest request,@RequestParam("picture") MultipartFile file) {//弹出的添加框添加
		//articleService.addArticleByPid(request);
		
		articleService.addArticleByPid(request,file);
	}
	
	
	@RequestMapping("/removeByArticleid")
	public void removeByArticleid(HttpServletRequest request) {
		articleService.removeByArticleid(request);
	}
	@RequestMapping("/selectOneArticleByid")
	public JSONObject selectOneArticleByid(HttpServletRequest request) {
		return articleService.selectOneArticleByid(request);
	}
	@RequestMapping("/UpdataOneArticleByid")
	public void UpdataOneArticleByid(HttpServletRequest request,@RequestParam("picture") MultipartFile file) {
		articleService.UpdataOneArticleByid(request,file);
		
	}
}
