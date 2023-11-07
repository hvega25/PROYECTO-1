package principal.bolsa.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import principal.bolsa.dto.Empresa;
import principal.bolsa.dto.Oferta;
import principal.bolsa.repository.EmpresaRepository;
import principal.bolsa.repository.OfertaRepository;

@RestController
@RequestMapping("/empresa")
public class Empresa_controlador {

	@Autowired
	private EmpresaRepository empresaRepositorio;
	
	@Autowired
	private OfertaRepository ofertaRepository;

	// método para consultar solo un elemento de la base de datos

	@GetMapping("/consultarEmpresa/{id}")
	Empresa consulta(@PathVariable Long id) {
		return empresaRepositorio.findById(id).orElseThrow();
	}
	
	//Metodo para mirar ofertas segun la empresa
	@GetMapping("/{id}/ofertas")
	public List<Oferta> getOfertasByEmpresaId(@PathVariable Long id) {
	    Empresa empresa = empresaRepositorio.findById(id).orElseThrow();
	    return empresa.getOfertas();
	}
	
	//Metodo para eliminar las ofertas asociadas a una empresa
	@DeleteMapping("/eliminar/{ofertaId}")
	public ResponseEntity<?> eliminarOfertaPorId(@PathVariable Long ofertaId) {
	    // Buscar la oferta por su ID
	    Optional<Oferta> oferta = ofertaRepository.findById(ofertaId);

	    if (oferta.isPresent()) {
	        // Si la oferta existe, eliminarla
	        ofertaRepository.deleteById(ofertaId);
	        return ResponseEntity.ok("Oferta eliminada correctamente");
	    } else {
	        // Si la oferta no existe, devolver una respuesta de error
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oferta no encontrada");
	    }
	}
	
	
//    //Eliminar por id
//    @DeleteMapping("/eliminar/{empresaId}")
//    public ResponseEntity<?> eliminarEmpresaPorId(@PathVariable Long empresaId) {
//    	empresarepositorio.deleteById(empresaId);
//        return ResponseEntity.ok("Empresa eliminada correctamente");
//    }
	

	// método para consultar todos los datos de la base de datos
	@GetMapping("/consultar")
	public List<Empresa> getAllEmpresas() {
		return empresaRepositorio.findAll();
	} 

//método para agregar a la base de datos
	@PostMapping("/agregar")
	public Empresa agregarEmpresa(@RequestBody Empresa nuevaEmpresa) {
		// Guardar la nueva oferta en la base de datos
		Empresa empresaGuardada = empresaRepositorio.save(nuevaEmpresa);
		return empresaGuardada;
	}
	

	//Modificar datos por id
	@PutMapping("/actualizar/{id}")
	public Empresa actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresaActualizada){
		Empresa empresaExiste = empresaRepositorio.findById(id).orElse(null);
		if (empresaExiste == null) {
			return null;
		}

		if (empresaActualizada.getNombre()!=null) {
			empresaExiste.setNombre(empresaActualizada.getNombre());
		}
		
		if (empresaActualizada.getDireccion() !=null) {
			empresaExiste.setDireccion(empresaActualizada.getDireccion());
		}

		if (empresaActualizada.getTelefono()!=null) {
			empresaExiste.setTelefono(empresaActualizada.getTelefono());
		}

		if (empresaActualizada.getCorreo()!=null) {
			empresaExiste.setCorreo(empresaActualizada.getCorreo());
		}

		empresaRepositorio.save(empresaExiste);
		return empresaExiste;
	}
}
