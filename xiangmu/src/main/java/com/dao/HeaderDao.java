package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.pojo.Header;

@Mapper
@Component
public interface HeaderDao {
     List<Header> getHeader(int pid);
    //List<Header> getHeaderByPid(int pId);//查询所有的header
     List<Header> getHeaderByPid(int pId, int start, int rows);//查询所有的header
     int   totalheader(int PId);//总的数
     int  addHeaderByPid(int PId);//
	void addHeaderByPid(int pid, String header);//增加
	void removeHeaderByid(int id);//移除，删除
	void changeHeaderByid(int id, String header);//修改
	String selectone(int id);//查询一个展示给页面
} 
