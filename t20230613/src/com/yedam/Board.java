package com.yedam;

import java.io.Serializable;

public class Board implements Serializable{
	private int no;
	private String title;
	private String content;
	private String name;
	
	public Board(int no, String title, String name, String content) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
