package com.MochiJump.LevelEditor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// this is my first attempt at trying to create a table that will hold the information I need for recording rectangle objects

// will probably change the Integer's to Integer[] down the line

// read below and formulate how you plan to take those svg rectangle from the client side and convert them into something that can be properly placed into
// MySQL

// https://stackoverflow.com/questions/40247556/spring-boot-automatic-json-to-object-at-controller

@Entity
public class UserInput {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String tableName;
	
	private Integer startX;
	
	private Integer startY;
	
	private Integer width;
	
	private Integer height;
	
	public Integer getId () {
		return id;
	}
	
	public void setId (Integer id) {
		this.id = id;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName=tableName;
	}
	
	public Integer getStartX() {
		return startX;
	}
	public void setStartX(Integer startX) {
		this.startX = startX;
	}
	
	public Integer getStartY() {
		return startY;
	}
	
	public void setStartY (Integer startY) {
		this.startY = startY;
	}
	
	public Integer getWidth () {
		return width;
	}
	
	public void setWidth (Integer width) {
		this.width = width;
	}
	
	public Integer getHeight() {
		return height;
	}
	
	public void setHeight (Integer height) {
		this.height = height;
	}
	
	
}
