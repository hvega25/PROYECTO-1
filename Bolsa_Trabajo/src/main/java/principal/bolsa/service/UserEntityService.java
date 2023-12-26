package principal.bolsa.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import principal.bolsa.dto.UserRegisterDTO;
import principal.bolsa.entity.UserAuthority;
import principal.bolsa.entity.Usuario;
import principal.bolsa.repository.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;


@Service
public class UserEntityService {

    private final UsuarioRepositorio repository;
    private final PasswordEncoder passwordEncoder;

    public UserEntityService(UsuarioRepositorio repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Usuario> findByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    public Usuario save(UserRegisterDTO userDTO) {
        Usuario user = new Usuario(
                null,
                userDTO.username(),
                passwordEncoder.encode(userDTO.password()),
                userDTO.email(),
                List.of(UserAuthority.READ)
        );
        return this.repository.save(user);
    }

}