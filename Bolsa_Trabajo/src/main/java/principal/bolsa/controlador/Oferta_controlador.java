package principal.bolsa.controlador;



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

import principal.bolsa.entity.Oferta;
import principal.bolsa.repository.OfertaRepository;



@RestController
@RequestMapping("/oferta")
public class Oferta_controlador { 
	
	@Autowired   
	private OfertaRepository ofertaRepositorio ; 
	
	@GetMapping("/consultar")
    public List<Oferta> getAllOfertas() {
        return ofertaRepositorio.findAll(); 
    }
    
    @PostMapping("/agregar")
    public Oferta agregarOferta(@RequestBody Oferta nuevaOferta) {
        // Guardar la nueva oferta en la base de datos
        Oferta ofertaGuardada = ofertaRepositorio.save(nuevaOferta);
        return ofertaGuardada;
    }
     
    //Eliminar por id
    @DeleteMapping("/eliminar/{ofertaId}")
    public ResponseEntity<?> eliminarOfertaPorId(@PathVariable Long ofertaId) {
        ofertaRepositorio.deleteById(ofertaId);
        return ResponseEntity.ok("Oferta eliminada correctamente");
    }

    
}



