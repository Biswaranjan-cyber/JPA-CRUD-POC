package com.second;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "DEMO_USER")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT e FROM DEMO_USER e"),
        @NamedQuery(name= "User.findbyUser", query="SELECT e from DEMO_USER where userId= ?1 and password= ?2")
})
public class User implements Serializable{
	
	public User(String userId, String password, String userAddress) {
		super();
		this.userId = userId;
		this.password = password;
		this.userAddress = userAddress;
	}
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String password;
	private String userAddress;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	


}
