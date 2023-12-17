package principal.bolsa.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import principal.bolsa.entity.Usuario;
import principal.bolsa.repository.UsuarioRepositorio;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class Usuario_controlador {

	@Autowired
	private UsuarioRepositorio usuarioRepository;
	@GetMapping("/consultar")
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}
}
