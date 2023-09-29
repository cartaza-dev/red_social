package com.sistema.red_social.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.red_social.modelo.Usuario;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{



	public  Usuario findByUsername(String username);
	
	public List<Usuario> findAll();

	
	
	
}
