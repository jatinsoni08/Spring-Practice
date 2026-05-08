package com.app.jatin;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//indicate reading the data from the properties file
//@PropertySource
@ConfigurationProperties("my.db")
public class DatabaseCon {
	
	private String driver;
	private String url;
	private String usr;
	private String pwd;
	public DatabaseCon() {
		super();
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsr() {
		return usr;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "DatabaseCon [driver=" + driver + ", url=" + url + ", usr=" + usr + ", pwd=" + pwd + "]";
	}
	
	
}
