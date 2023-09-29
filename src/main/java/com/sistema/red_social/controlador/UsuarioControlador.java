package com.sistema.red_social.controlador;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.red_social.modelo.Rol;
import com.sistema.red_social.modelo.Usuario;
import com.sistema.red_social.modelo.UsuarioRol;
import com.sistema.red_social.repositorio.UsuarioRepositorio;
import com.sistema.red_social.servicio.UsuarioServicio;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioService;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{

        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setId(2);
        rol.setNombre("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        return usuarioService.guardarUsuario(usuario,usuarioRoles);
    }


    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Integer usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }

    
    @GetMapping("/listar")
    public List<Usuario> obtenerListaUsuarios(){
    return usuarioRepositorio.findAll();
    }

     /*@PutMapping("/usuarios/{id}")
      public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario detallesUsuario){
        Usuario usuario = usuarioRepositorio.findByUsername("lucasfnn");
       
         usuario.setNombre(detallesUsuario.getNombre());
         usuario.setApellido(detallesUsuario.getApellido());
        usuario.setEmail(detallesUsuario.getEmail());
         usuario.setTelefono(detallesUsuario.getTelefono());
       
        
         Usuario usuarioActualizado = usuarioRepositorio.save(usuario);
         
         return ResponseEntity.ok(usuarioActualizado);
    
    }*/
}
