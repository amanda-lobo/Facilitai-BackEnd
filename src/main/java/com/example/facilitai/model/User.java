package com.example.facilitai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_user_152")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	@NotNull
	private String nomeUser;
	
	@NotNull
	@Schema(example = "email@email.com.br")
	@Email
	private String emailUser;
	
	@NotNull
	@Size(min = 8)
	private String senhaUser;
	
	private String fotoUser;
	
	@NotNull
	private String telefoneUser;
	
	@NotNull
	private String tipoUser;
	
	@NotNull
	private Integer ticketsUser;

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
	
}
