package com.sistema.red_social.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.red_social.modelo.Rol;



@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {


}
