package com.sistema.red_social.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="usuario_rol")
public class UsuarioRol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usuarioRolId;
	
	@ManyToOne(fetch= FetchType.EAGER)
	private Usuario usuario;
	
	
	@ManyToOne(fetch= FetchType.EAGER)
	private Rol rol;


	public int getUsuarioRolId() {
		return usuarioRolId;
	}


	public void setUsuarioRolId(int usuarioRolId) {
		this.usuarioRolId = usuarioRolId;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public UsuarioRol() {
		super();
	}
	

}
