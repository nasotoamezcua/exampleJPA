package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDTO {
	
	private Long idUser;
	private String userName;
	private String password;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Mexico_City")
	private Date createOn;
	
	public UserDTO() {}
	
	public UserDTO(Long idUser, String userName, String password, Date createOn) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.password = password;
		this.createOn = createOn;
	}
	
	
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

}
