package principal.bolsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import principal.bolsa.dto.AdminDTO;
import principal.bolsa.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Query("SELECT new principal.bolsa.dto.AdminDTO(e.nombre, e.direccion, e.telefono, e.correo) FROM Empresa e")
	public List<AdminDTO> ObtenerEmpresa();
	
	@Query("SELECT new principal.bolsa.dto.AdminDTO(e.nombre, e.direccion, e.telefono, e.correo) FROM Empresa e where e.empresa_id = :id")
	public AdminDTO obtenerEmpresa(@Param("id") Long id);


	//Otras querys de busqueda
	List <Empresa> findEmpresaByNombre (String name);

    //Por rango es prueba
	//public List<AdminDTO> findbyTotalBeetween (Double min, Double max);

}
