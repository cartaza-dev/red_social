package com.sistema.red_social.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.sistema.red_social.modelo.Usuario;
import com.sistema.red_social.repositorio.UsuarioRepositorio;


@Service
public class UserDetailesServiceImpl implements UserDetailsService {

	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public UserDetailesServiceImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepositorio.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario NO encontrado");
        }

        // Crear un UserDetails a partir de la entidad Usuario
        UserDetails userDetails = User.withUsername(usuario.getUsername())
                .password(usuario.getPassword()) // Aquí puedes configurar la contraseña encriptada si es necesario
                .roles("USER") // Puedes asignar roles a tu usuario
                .build();

        return userDetails;
    }
}