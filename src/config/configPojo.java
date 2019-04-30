package config;

import org.springframework.beans.factory.annotation.Value;


public class configPojo {
	@Value("${activemq.brokerURL}")
	private String url;
	@Value("${activemq.userName}")
	private String userName;
	@Value("${activemq.password}")
	private String password;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
