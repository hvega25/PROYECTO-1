package principal.bolsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import principal.bolsa.dto.AdminDTO;
import principal.bolsa.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Query("SELECT new principal.bolsa.dto.AdminDTO(e.nombre, e.direccion, e.telefono, e.correo) FROM Empresa e")
	public List<AdminDTO> ObtenerEmpresa();

}
