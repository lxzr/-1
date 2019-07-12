package com.service;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;

import com.pojo.User;


@Service
public class UserService {
	 @Autowired
	 UserDao userDao;
	//功能1//验证用户是否存在，是否可用
  public String checkName(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  response.setContentType("text/html;charset=UTF-8");
      request.setCharacterEncoding("UTF-8");
      String name = request.getParameter("name");
      User people = new User();
      people.setName(name);
      return userDao.checkName(people);
  }
//功能2//用户登录
  public String checkUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  response.setContentType("text/html;charset=UTF-8");
      request.setCharacterEncoding("UTF-8");
      String name = request.getParameter("name");
      String password = request.getParameter("password");
      User people = new User();
      people.setName(name);
      people.setPassword(password);
      return userDao.checkUser(people);
  }
//功能3//用户注册
  public int saveUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  response.setContentType("text/html;charset=UTF-8");
      request.setCharacterEncoding("UTF-8");
      String name = request.getParameter("name");
      String password = request.getParameter("password");
      User people = new User();
      people.setName(name);
      people.setPassword(password);
      return userDao.saveUser(people);
  }


}
