package principal.bolsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import principal.bolsa.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
      Optional<Usuario> findByUsername(String username);

}
