package principal.bolsa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import principal.bolsa.dto.AdminDTO;
import principal.bolsa.repository.OfertaRepository;

class Test_OfertaRepository {

	@Autowired   
	private OfertaRepository ofertaRepositorio ; 

	@Test
	void testObteneOFerta() {
	        
	        List<AdminDTO> empresas = OfertaRepository.();
	        
	        assertNotNull(empresas);
	        assertTrue(empresas.size() > 0);
	        
	        //Comprobar la empresa 1
	        AdminDTO primeraEmpresa = oferta.get(0);
	        assertNotNull(Ofertas.getNombre());
	        assertNotNull(Ofertas.getDireccion());
	        assertTrue(Ofertas.getTelefono().matches("\\d+"));
	        assertNotNull(Ofertas.getCorreo());
	        
	    }
}


