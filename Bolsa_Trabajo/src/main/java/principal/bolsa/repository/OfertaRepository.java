package principal.bolsa.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import principal.bolsa.dto.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta, Long>{
	
	public List<Oferta> findAll();
	
	
}
