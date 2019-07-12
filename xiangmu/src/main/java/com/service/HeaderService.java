package com.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dao.HeaderDao;
import com.pojo.Header;
@Service
public class HeaderService {
	@Autowired
	HeaderDao headerdao;
	//循环遍历获取所有的对象
	public List<Header> getHeader1(int pid){
		 ArrayList<Header> lx=new ArrayList<Header>();
		getHeader(pid,lx);
		return lx;
	}
	public void getHeader(int pid,ArrayList<Header> lx){
		List<Header> headers=headerdao.getHeader(pid);
		if(headers!=null && headers.size()!=0){
		for (int i = 0; i < headers.size(); i++) {
			
			System.out.println("i+"+headers.get(i));
			Header Header=headers.get(i);
			lx.add(Header);
			//lx.add(headers.get(i));
			getHeader(headers.get(i).getId(),lx);	
		}
		}	
	}
	//通过pid去获取header对象，
	public JSONObject getHeaderByPid(HttpServletRequest request,
			HttpServletResponse response,int pId) throws IOException{
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
	      System.out.println(page+"page");
	      System.out.println(rows+"rows");
		int total= headerdao.totalheader(pId);
		System.out.println(total);
		//知道了展示的页码和要显示的总数，所有用limit(开始页数，显示个数）
		//select     *  from tou  limit #{start},#{count}
		//start是指每一页开始的id,而count是指加载多少个
		   int start=(page-1)*rows;System.out.println(start+"start");
		   JSONObject res = new JSONObject();
		   List<Header> list= headerdao.getHeaderByPid(pId,start,rows);
		   res.put("total",total);
		   res.put("rows",list);
		  
		   System.out.println(res);
		return res;
	}
	//通过pid去添加子header对象，
	public void addHeaderByPid(int pid,String header) {
		headerdao.addHeaderByPid(pid,header);
	}
	//通过id删除header对象，物理删除，不是逻辑删除
	public void removeHeaderByid(HttpServletRequest request) {
		String ids=request.getParameter("ids");
		
			String[] staffIds = ids.split(",");
			for (String id : staffIds) {
				System.out.println(id);
				int id1=Integer.valueOf(id);
				headerdao.removeHeaderByid(id1);
			}
		
	}
	//通过id进行修改字段
	public void changeHeaderByid(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int id=Integer.valueOf(request.getParameter("id"));
		String header=request.getParameter("header");
		headerdao.changeHeaderByid(id,header);
	}
	//通过id去查询当前要修改的选项并且加载到改输入框中，但是显示失败了
	public String selectone(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int id=Integer.valueOf(request.getParameter("id"));
		//System.out.println(id+"你好啊");
		return headerdao.selectone(id);
	}
}
