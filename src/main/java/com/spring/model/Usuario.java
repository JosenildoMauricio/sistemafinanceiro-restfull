package com.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_usuario_sistema")
	private Long id;
	
	@NotBlank(message = "Nome do usuário em branco.")
	@NotNull(message = "Nome do usuário não fornecido.")
	@Column(name="nome_usuario_sistema", unique=true)
	private String nomeUsuario;
	
	@NotBlank(message = "Email do usuario em branco.")
	@NotNull(message = "Email do usuário não fornecido.")
	@Email(message = "Email digitado não é valido.")
	@Column(name="email_usuario_sistema")
	private String emailUsuario;
	
	@NotBlank(message = "Senha do usuario em branco.")
	@NotNull(message = "Senha do usuário não fornecido.")
	@Size(min = 6, max = 8, message = "Senha tem que ter entre 6 a 8 digitos.")
	@Column(name="senha_usuario_sistema")
	private String senhaUsuario;
	
	@NotBlank(message = "CPF do usuário em branco.")
	@NotNull(message = "CPF do usuário não fornecido.")
	@Size(min = 11, max = 11, message = "CPF Invalido na quantidade de digitos(11).")
	@Column(name="cpf_usuario_sistema",unique=true)
	private String cpfUsuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
