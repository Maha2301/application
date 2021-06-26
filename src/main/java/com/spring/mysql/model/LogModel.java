package com.spring.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class LogModel {
	@Id
	@Column(unique=true,columnDefinition="VARCHAR(64)")
	private String Id;
	private String name;
	private String logType;
	private String date;
	private String time;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "LogModel [Id=" + Id + ", name=" + name + ", logType=" + logType + ", date=" + date + ", time=" + time
				+ "]";
	}
}
