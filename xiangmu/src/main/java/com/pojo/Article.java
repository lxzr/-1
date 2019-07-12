package com.pojo;

public class Article {
  private int id;
  private int wid;
  private String head;
  private String text;
  private String pictureAddress;
  private String publishTime;
  private int heatNumber;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getWid() {
	return wid;
}
public void setWid(int wid) {
	this.wid = wid;
}
public String getHead() {
	return head;
}
public void setHead(String head) {
	this.head = head;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getPictureAddress() {
	return pictureAddress;
}
public void setPictureAddress(String pictureAddress) {
	this.pictureAddress = pictureAddress;
}
public String getPublishTime() {
	return publishTime;
}
public void setPublishTime(String publishTime) {
	this.publishTime = publishTime;
}
public int getHeatNumber() {
	return heatNumber;
}
public void setHeatNumber(int heatNumber) {
	this.heatNumber = heatNumber;
}
@Override
public String toString() {
	return "Article [id=" + id + ", wid=" + wid + ", head=" + head + ", text=" + text + ", pictureAddress="
			+ pictureAddress + ", publishTime=" + publishTime + ", heatNumber=" + heatNumber + "]";
}

  
}
