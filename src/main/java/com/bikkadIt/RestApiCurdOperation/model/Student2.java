package com.bikkadIt.RestApiCurdOperation.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student2 {

	@Id
	private int stuId;

	private String stuName;

	private String StuAddr;

	private String stuEmail;

	private String stuPass;

	public Student2() {
		super();
	}

	public Student2(int stuId, String stuName, String stuAddr, String stuEmail, String stuPass) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		StuAddr = stuAddr;
		this.stuEmail = stuEmail;
		this.stuPass = stuPass;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuAddr() {
		return StuAddr;
	}

	public void setStuAddr(String stuAddr) {
		StuAddr = stuAddr;
	}

	public String getStuEmail() {
		return stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public String getStuPass() {
		return stuPass;
	}

	public void setStuPass(String stuPass) {
		this.stuPass = stuPass;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", StuAddr=" + StuAddr + ", stuEmail=" + stuEmail
				+ ", stuPass=" + stuPass + "]";
	}

}
