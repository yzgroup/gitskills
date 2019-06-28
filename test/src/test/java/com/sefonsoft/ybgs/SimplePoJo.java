package com.sefonsoft.ybgs;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(creatorVisibility = NONE, fieldVisibility = NONE, getterVisibility = NONE, setterVisibility = NONE, isGetterVisibility = NONE)
public class SimplePoJo {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("num")
	private Integer num;
	
	@JsonProperty("unit")
	private String unit;
	
	@JsonProperty("createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	
	
	public SimplePoJo() {
		super();
	}
	public SimplePoJo(String name, Integer num, String unit) {
		super();
		this.name = name;
		this.num = num;
		this.unit = unit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "SimplePoJo [name=" + name + ", num=" + num + ", unit=" + unit + ", createTime=" + createTime + "]";
	}
	
	
}
