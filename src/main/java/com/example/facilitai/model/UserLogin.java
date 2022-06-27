package com.example.facilitai.model;

public class UserLogin {
	
	private Long idUser;
	
	private String nomeUser;
	
	private String emailUser;
	
	private String senhaUser;
	
	private String fotoUser;
	
	private String telefoneUser;
	
	private String tipoUser;
	
	private Integer ticketsUser;
	
	private String Token;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNomeUser() {
		return nomeUser;
	}

	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getSenhaUser() {
		return senhaUser;
	}

	public void setSenhaUser(String senhaUser) {
		this.senhaUser = senhaUser;
	}

	public String getFotoUser() {
		return fotoUser;
	}

	public void setFotoUser(String fotoUser) {
		this.fotoUser = fotoUser;
	}

	public String getTelefoneUser() {
		return telefoneUser;
	}

	public void setTelefoneUser(String telefoneUser) {
		this.telefoneUser = telefoneUser;
	}

	public String getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}

	public Integer getTicketsUser() {
		return ticketsUser;
	}

	public void setTicketsUser(Integer ticketsUser) {
		this.ticketsUser = ticketsUser;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}
	
}
