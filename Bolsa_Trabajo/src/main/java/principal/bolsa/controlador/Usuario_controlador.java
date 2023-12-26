package principal.bolsa.controlador;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import principal.bolsa.entity.Usuario;
import principal.bolsa.repository.UsuarioRepositorio;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario", description = "CRUD controlador usuarios")
public class Usuario_controlador {

    @Autowired
    private UsuarioRepositorio usuariorepository;

    @Operation(summary = "findAllUsuarios", description = "Encuentra todos los usuarios en la base de datos")
    @GetMapping("/consultar")
    public List<Usuario> getAllUsuarios() {
        return usuariorepository.findAll();
    }
}
