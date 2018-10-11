package com.example.demo.repository.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "DEMO_USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEMO_USERS_SEQ" )//Oracle
	@SequenceGenerator(sequenceName="DEMO_USERS_SEQ", allocationSize=1,name="DEMO_USERS_SEQ")//Oracle
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long id;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Mexico_City")
	@Column(name = "CREATED_ON")
	private Date createOn;
	
	@Column(name = "PRODUCTS")
	private String products;
	
	@Column(name = "ADMIN_USER")
	private String adminUser;
	
	//NO SE GENERA GET NI SET Y SE EXCLUYE DEL toString(), hashCode() y equals() 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Order> orders = new HashSet<Order>();
	
	public User() {}
	
	public User(Long id, String userName, String password, Date createOn, String products, String adminUser,
			Set<Order> orders) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.createOn = createOn;
		this.products = products;
		this.adminUser = adminUser;
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", createOn=" + createOn
				+ ", products=" + products + ", adminUser=" + adminUser + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminUser == null) ? 0 : adminUser.hashCode());
		result = prime * result + ((createOn == null) ? 0 : createOn.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (adminUser == null) {
			if (other.adminUser != null)
				return false;
		} else if (!adminUser.equals(other.adminUser))
			return false;
		if (createOn == null) {
			if (other.createOn != null)
				return false;
		} else if (!createOn.equals(other.createOn))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	

}
