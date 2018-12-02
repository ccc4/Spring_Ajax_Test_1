package model;

import java.util.Date;

public class Board {
	private int idx;
	private String name;
	private String title;
	private Date writeDate;
	
	
	
	
	public Board() {
	}
	
	// 아래 두 필드에 대한 생성자만 만들어주니 오류 발생.
	// 기본 생성자 만들어주니 mapper 에서 데이터 가져올 때 오류 안생긴다!
	public Board(String name, String title) {
		this.name = name;
		this.title = title;
	}
	
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	
}
