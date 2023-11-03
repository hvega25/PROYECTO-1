package principal.bolsa.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import principal.bolsa.dto.oferta;

public interface OfertaRepository extends JpaRepository<oferta, Long>{
	
	public List<oferta> findAll();
	

}
