package com.sistema.red_social.modelo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	
    @Column(name="username", nullable = false, unique =  true)
	private String username;
	
    @Column(name="nombre", nullable = false)
	private String nombre;
	
    @Column(name="apellido", nullable = false)
	private String apellido;
	
    @Column(name="fecha_nacimiento")
	private Date fecha_nacimiento;
    
    @Column(name="email", nullable = false, unique = true)
	private String email;
	
    @Column(name="password", nullable = false)
	private String password;
	
    @Column(name="fecha_creacion")
	private Date fecha_creacion;
	
    @Column(name="pais", nullable = false)
	private int id_pais;
	
    @Column(name="estado", nullable = false)
	private Boolean estado;
	
    @Lob
    @Column(name="imagen_perfil", nullable = false)
	private String imagen_perfil;
    
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
	@JsonIgnore
	private Set<UsuarioRol> usuarioRoles = new HashSet<>();
	
	
	public Usuario() {
		super();
	}
	
	
	public Usuario(int id_usuario) {
		super();
		this.id_usuario = id_usuario;
	}


	public Usuario(int id_usuario, String username, String nombre, String apellido, Date fecha_nacimiento,
			String email, String password, Date fecha_creacion, int id_pais, Boolean estado, String imagen_perfil, Set<UsuarioRol> usuarioRoles) {
		super();
		this.id_usuario = id_usuario;
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.email = email;
		this.password = password;
		this.fecha_creacion = fecha_creacion;
		this.id_pais = id_pais;
		this.estado = estado;
		this.imagen_perfil = imagen_perfil;
		this.usuarioRoles = usuarioRoles;
	}


	public Usuario(String username) {
		super();
		this.username = username;
	}


	public int getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getFecha_creacion() {
		return fecha_creacion;
	}


	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}


	public int getId_pais() {
		return id_pais;
	}


	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public String getImagen_perfil() {
		return imagen_perfil;
	}


	public void setImagen_perfil(String imagen_perfil) {
		this.imagen_perfil = imagen_perfil;
	}

	public Set<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}
	

	
	
}
