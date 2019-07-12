package com.pojo;

public class Header {
	  private int id;
	  private int pId;
	  private String name;
	  private String publishTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	@Override
	public String toString() {
		return "Header [id=" + id + ", pId=" + pId + ", name=" + name + ", publishTime=" + publishTime + "]";
	}
	
	  
}
