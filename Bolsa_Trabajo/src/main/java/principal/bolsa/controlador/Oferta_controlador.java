package principal.bolsa.controlador;



import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import principal.bolsa.dto.oferta;
import principal.bolsa.repository.OfertaRepository;



@RestController
@RequestMapping("/oferta")
public class Oferta_controlador {
	
	@Autowired 
	OfertaRepository ofertaRepositorio ; 
	
	@GetMapping("/consultar")
    public List<oferta> getAllOfertas() {
        return ofertaRepositorio.findAll();
    }
    
//    @PostMapping("/crear_oferta")
//    public ResponseEntity<?> crearOferta(@RequestBody oferta nuevaOferta) {
//    	return ofertaRepositorio.save(nuevaOferta);
//    }
    
    //Eliminar por id
    @DeleteMapping("/eliminar/{ofertaId}")
    public ResponseEntity<?> eliminarOfertaPorId(@PathVariable Long ofertaId) {
        ofertaRepositorio.deleteById(ofertaId);
        return ResponseEntity.ok("Oferta eliminada correctamente");
    }

    
}



