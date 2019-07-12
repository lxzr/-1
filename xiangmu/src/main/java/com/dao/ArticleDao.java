package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.pojo.Article;

@Component
@Mapper
public  interface ArticleDao {
	List<Article>  getArticleByid(int id);
	void addArticleByPid(Article article);
	void removeByArticleid(int id);
	Article selectOneArticleByid(int id);
	void UpdataOneArticleByid(Article article);
	void UpdataOneArticleByid1(Article article);
}
