package com.mochijump.leveleditor;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity // This tells Hibernate to make a table out of this class
public class Level {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	

	private String levelName;
	
	@Column(length = 1000000)
	@Lob
	private ArrayList<Integer> startX;
	
	@Column(length = 1000000)
	@Lob
	private ArrayList<Integer> startY;
	
	@Column(length = 1000000)
	@Lob
	private ArrayList<Integer> width;
	
	@Column(length = 1000000)
	@Lob
	private ArrayList<Integer> height;
	
	@Column(length = 1000000)
	@Lob
	private ArrayList<Integer> hairClipStartX;
	
	@Column(length = 1000000)
	@Lob
	private ArrayList<Integer> hairClipStartY;
	
	private int mochiStartX;
	
	private int mochiStartY;
	

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
		System.out.println(levelName);
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
		System.out.println(width);
	}

	public ArrayList<Integer> getHeight() {
		return height;
	}

	public void setHeight (ArrayList<Integer> height) {
		this.height = height;
	}
	
	public ArrayList<Integer> getHairClipStartX(){
		return hairClipStartX;
	}
	
	public void setHairClipStartX(ArrayList<Integer> hairClipStartX) {
		this.hairClipStartX = hairClipStartX;
	}
	
	public ArrayList<Integer> getHairClipStartY(){
		return hairClipStartY;
	}
	
	public void setHairClipStartY(ArrayList<Integer> hairClipStartY) {
		this.hairClipStartY = hairClipStartY;
	}
	
	public int getMochiStartX() {
		return mochiStartX;
	}
	
	public void setMochiStartX (int mochiStartX) {
		this.mochiStartX = mochiStartX;
	}
	
	public int getMochiStartY() {
		return mochiStartY;
	}
	public void setMochiStartY(int mochiStartY) {
		this.mochiStartY = mochiStartY;
	}
	
}
