package com.MochiJump.LevelEditor;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


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
	

	private String levelName;
	

	private ArrayList<Integer> startX;
	

	private ArrayList<Integer> startY;
	

	private ArrayList<Integer> width;
	

	private ArrayList<Integer> height;
	

	public Integer getId () {
		return id;
	}
	

	public void setId (Integer id) {
		this.id = id;
	}
	

	public String getlevelName() {
		return levelName;
	}
	

	public void setLevelName(String levelName) {
		this.levelName=levelName;
		System.out.println("Someone Tried to get levelName");
	}
	

	public ArrayList<Integer> getStartX() {
		return startX;
	}

	public void setStartX(ArrayList<Integer> startX) {
		this.startX = startX;
	}

	public ArrayList<Integer> getStartY() {
		return startY;
	}

	public void setStartY (ArrayList<Integer> startY) {
		this.startY = startY;
	}

	public ArrayList<Integer> getWidth () {
		return width;
	}

	public void setWidth (ArrayList<Integer> width) {
		this.width = width;
	}

	public ArrayList<Integer> getHeight() {
		return height;
	}

	public void setHeight (ArrayList<Integer> height) {
		this.height = height;
	}
	
	
}
