package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class Title {
	 private int id;
	 private int pId;
	 private String text;
	 private List<Title> children = new ArrayList<Title>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String gettext() {
		return text;
	}
	public void settext(String text) {
		this.text = text;
	}
	public List<Title> getChildren() {
		return children;
	}
	public void setChildren(List<Title> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", pid=" + pid + ", text=" + text + ", children=" + children + "]";
	}
	
	 
}
