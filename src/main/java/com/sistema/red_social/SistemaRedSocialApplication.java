package com.sistema.red_social;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.sistema.red_social.modelo.Rol;
import com.sistema.red_social.modelo.Usuario;
import com.sistema.red_social.modelo.UsuarioRol;
import com.sistema.red_social.servicio.UsuarioServicioImpl;

@SpringBootApplication
@EnableWebSecurity
public class SistemaRedSocialApplication implements CommandLineRunner {

	@Autowired
	private UsuarioServicioImpl usuarioServicio;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SistemaRedSocialApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Usuario usuario = new Usuario();

		usuario.setNombre("Carla");
		usuario.setUsername("cartaza");
		usuario.setApellido("artaza");
		usuario.setPassword("123456");
		usuario.setEmail("carlaartaza-dev@outlook.com");
		usuario.setEstado(true);
		usuario.setId_pais(1);
		usuario.setImagen_perfil("./imagen_perfil");

		Date fechaCreacion = new Date(System.currentTimeMillis());
		usuario.setFecha_creacion(fechaCreacion);

		Date fechaNacimiento = Date.valueOf("1990-01-15");
		usuario.setFecha_nacimiento(fechaNacimiento);

		Rol rol = new Rol();
		rol.setId(1);
		rol.setNombre("ADMIN");

		Set<UsuarioRol> usuariosRoles = new HashSet<>();

		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);

		usuariosRoles.add(usuarioRol);

		Usuario usuarioGuardado = usuarioServicio.guardarUsuario(usuario, usuariosRoles);

		System.out.println(usuarioGuardado.getUsername());

	}

}
