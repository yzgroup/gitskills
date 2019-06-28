package com.cdintelligent.znzx.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户
 * @author michael
 *
 */
public class User {

	private String userId;//主键id,uuid的方式处理
	private String username;//用户名
	private String tureName;//真实姓名
	private String password;//密码
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date registeTime;//注册时间
	private String userRoleCode;//用户所属角色,老师,家长,学生
	private String currentGradeCode;//当前所在年级
	private String currentClassCode;//当前所在班级
	private String currentSchoolCode;//当前所在学校
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisteTime() {
		return registeTime;
	}
	public void setRegisteTime(Date registeTime) {
		this.registeTime = registeTime;
	}
	public String getUserRoleCode() {
		return userRoleCode;
	}
	public void setUserRoleCode(String userRoleCode) {
		this.userRoleCode = userRoleCode;
	}
	public String getCurrentGradeCode() {
		return currentGradeCode;
	}
	public void setCurrentGradeCode(String currentGradeCode) {
		this.currentGradeCode = currentGradeCode;
	}
	public String getCurrentClassCode() {
		return currentClassCode;
	}
	public void setCurrentClassCode(String currentClassCode) {
		this.currentClassCode = currentClassCode;
	}
	public String getCurrentSchoolCode() {
		return currentSchoolCode;
	}
	public void setCurrentSchoolCode(String currentSchoolCode) {
		this.currentSchoolCode = currentSchoolCode;
	}
	public String getTureName() {
		return tureName;
	}
	public void setTureName(String tureName) {
		this.tureName = tureName;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", tureName=" + tureName + ", password=" + password
				+ ", registeTime=" + registeTime + ", userRoleCode=" + userRoleCode + ", currentGradeCode="
				+ currentGradeCode + ", currentClassCode=" + currentClassCode + ", currentSchoolCode="
				+ currentSchoolCode + "]";
	}
	
	
	
}
