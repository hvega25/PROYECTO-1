package principal.bolsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import principal.bolsa.entity.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
