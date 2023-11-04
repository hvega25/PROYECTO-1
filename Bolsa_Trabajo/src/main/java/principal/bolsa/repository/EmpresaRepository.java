package principal.bolsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import principal.bolsa.dto.empresa;

public interface EmpresaRepository extends JpaRepository<empresa,Long>{

}
