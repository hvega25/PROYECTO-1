package principal.bolsa.controlador;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import principal.bolsa.entity.Empresa;
import principal.bolsa.entity.Usuario;
import principal.bolsa.repository.UsuarioRepositorio;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario", description = "CRUD controlador usuarios")
public class Usuario_controlador {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Operation(summary = "findAllUsuarios", description = "Encuentra todos los usuarios en la base de datos")
    @GetMapping("/consultar")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @PutMapping("/actualizar/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        Usuario usuarioExiste = usuarioRepositorio.findById(id).orElse(null);
        if (usuarioExiste == null) {
            return null;
        }

        if (usuarioActualizado.getUsername() != null) {
            usuarioExiste.setUsername(usuarioActualizado.getUsername());
        }

        if (usuarioActualizado.getPassword() != null) {
            usuarioExiste.setPassword(usuarioActualizado.getPassword());
        }

        if (usuarioActualizado.getEmail() != null) {
            usuarioExiste.setEmail(usuarioActualizado.getEmail());
        }

        usuarioRepositorio.save(usuarioExiste);
        return usuarioExiste;
    }




}
