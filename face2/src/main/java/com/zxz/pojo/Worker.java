package com.zxz.pojo;

public class Worker {
	private Integer user_id;
	private String uname;
	private String user_pass;
	private String job;
	private String hir_time;
	private Integer sal;
	private Integer comm;
	private Dept dept;
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHir_time() {
		return hir_time;
	}
	public void setHir_time(String hir_time) {
		this.hir_time = hir_time;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	public Integer getComm() {
		return comm;
	}
	public void setComm(Integer comm) {
		this.comm = comm;
	}
	@Override
	public String toString() {
		return "Worker [user_id=" + user_id + ", uname=" + uname + ", user_pass=" + user_pass + ", job=" + job
				+ ", hir_time=" + hir_time + ", sal=" + sal + ", comm=" + comm + ", dept=" + dept + "]";
	}

	

}
