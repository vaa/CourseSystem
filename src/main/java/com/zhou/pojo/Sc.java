package com.zhou.pojo;

import java.io.Serializable;
import java.util.Date;

public class Sc implements Serializable{
	private static final long serialVersionUID = 1L;
	private String sno;
	private String cno;
	private String grade;
	private Date date;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Sc [sno=" + sno + ", cno=" + cno + ", grade=" + grade + ", date=" + date + "]";
	}

	
}
