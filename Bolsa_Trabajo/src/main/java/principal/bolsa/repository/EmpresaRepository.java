package principal.bolsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import principal.bolsa.dto.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa,Long>{

}
