package principal.bolsa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import principal.bolsa.controlador.Oferta_controlador;
import principal.bolsa.entity.Oferta;
import principal.bolsa.repository.OfertaRepository;

@SpringBootTest
class Test_OfertaControlador {
	
	// System under test: SUT Controlador Oferta
	@InjectMocks
	Oferta_controlador OfertaControlador;
	
//	@Autowired
	@Mock
	private OfertaRepository ofertaRepositorio;

	
//	@BeforeEach
//	void setUp(){	
//		MockitoAnnotations.openMocks(this);
//	}
	
	@Test
    void testGetAllOfertas() {
        // Creación de ofertas ficticias
        //when(ofertaRepositorio.findAll()).thenReturn(List.of(new Oferta(), new Oferta(), new Oferta()));
		
        // Configuración para devolver una lista vacía
        when(ofertaRepositorio.findAll()).thenReturn(List.of(new Oferta()));

        // Llamamos a la lista ficticia con el metodo get all ofertas
        List<Oferta> testing = OfertaControlador.getAllOfertas();
        
        // Verificamos el resultado de las ofertas
//        assertNotNull(testing);
//        assertEquals(3, testing.size());
        // Verificamos el resultado de la lista vacia
        assertNotNull(testing);
        assertTrue(testing.isEmpty());

        // Verificamos las veces que llamamos al repo ocn times()
        verify(ofertaRepositorio, times(1)).findAll();
    }
	
	
	

	@Test
	void agregarOferta() {
		
		
//		Oferta ofertaGuardada = ofertaRepositorio.save();
			
		
	}

//	@Test
//	void testEliminarOfertaPorId() {
//		fail("Not yet implemented");
//	}

}
