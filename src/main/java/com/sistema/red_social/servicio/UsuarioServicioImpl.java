package com.sistema.red_social.servicio;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.red_social.modelo.Usuario;
import com.sistema.red_social.modelo.UsuarioRol;
import com.sistema.red_social.repositorio.RolRepositorio;
import com.sistema.red_social.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    
    @Autowired
    private RolRepositorio rolRepositorio;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
    	
        Usuario usuario1 = usuarioRepositorio.findByUsername(usuario.getUsername());
        
        if(usuario1 != null){
        System.out.println("El usuario ya existe");
        throw new Exception ("Ya existe este nombre de usuario");     
        }else {
        for(UsuarioRol usuarioRol:usuarioRoles){
        rolRepositorio.save(usuarioRol.getRol());
        }
        
        usuario.getUsuarioRoles().addAll(usuarioRoles);
        usuario1 = usuarioRepositorio.save(usuario);
        }
        return usuario1;
    }

       @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepositorio.findByUsername(username);
    }

       @Override
       public void eliminarUsuario(Integer usuarioId) {
           usuarioRepositorio.deleteById(usuarioId);
       }


    
}