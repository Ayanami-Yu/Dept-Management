package com.example.myProject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dept")
public class Dept {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptNo;
	
	@Column(name = "dName")
	private String dName;
	
	@Column(name = "loc")
	private String loc;
	
	public Dept() {
		
	}
	
	public Dept(Integer deptNo, String dName, String loc) {
		super();
		this.deptNo = deptNo;
		this.dName = dName;
		this.loc = loc;
	}
	
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public String getDName() {
		return dName;
	}
	public void setDName(String dName) {
		this.dName = dName;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
