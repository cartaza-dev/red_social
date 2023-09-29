package com.sistema.red_social.servicio;

import java.util.Set;

import com.sistema.red_social.modelo.Usuario;
import com.sistema.red_social.modelo.UsuarioRol;

public interface UsuarioServicio {
    
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles)throws Exception;
    
     public Usuario obtenerUsuario(String username);

	void eliminarUsuario(Integer usuarioId);
    
}