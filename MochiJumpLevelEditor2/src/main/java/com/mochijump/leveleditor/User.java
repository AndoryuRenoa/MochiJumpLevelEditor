package com.mochijump.leveleditor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String userFirstName;
	
	private String userName;
	
	private String emailAddress;
	
	private String password;
	
	private boolean isAccountNonLocked;
	
	private Long keyNum;
	
	public Integer getId () {
		return id;
	}
	

	public void setId (Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	
	public boolean getIsAccountNonLocked () {
		return isAccountNonLocked;
	}
	
	public void setIsAccountNonLocked (boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}
	
	public Long getKeyNum () {
		return this.keyNum;
	}
	
	public void setKeyNum (Long keyNum) {
		this.keyNum = keyNum;
	}
	
}
