package principal.bolsa.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import principal.bolsa.entity.Empresa;
import principal.bolsa.entity.Oferta;
import principal.bolsa.repository.EmpresaRepository;
import principal.bolsa.repository.OfertaRepository;

@RestController
@RequestMapping("/admin")
public class Admin_Controlador {

	@Autowired
	private EmpresaRepository empresaRepositorio;

	@Autowired
	private OfertaRepository ofertaRepositorio;

	// Método que consulta todas las empresas que existen
	@GetMapping("/consultarTodo")
	public List<Empresa> getAllEmpresasWithoutOfertas() {
		return empresaRepositorio.findAll();
	}

	//Método que obtiene por id de una empresa las ofertas
	@GetMapping("/{id}/ofertas")
	public List<Oferta> getOfertasByEmpresaId(@PathVariable Long id) {
		Empresa empresa = empresaRepositorio.findById(id).orElseThrow();
		return empresa.getOfertas();
	}

	// Metodo para eliminar las ofertas asociadas a una empresa
	@DeleteMapping("/eliminar/{ofertaId}")
	public ResponseEntity<?> eliminarOfertaPorId(@PathVariable Long ofertaId) {
		// Buscar la oferta por su ID
		Optional<Oferta> oferta = ofertaRepositorio.findById(ofertaId);

		if (oferta.isPresent()) {
			ofertaRepositorio.deleteById(ofertaId);
			return ResponseEntity.ok("Oferta eliminada correctamente");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oferta no encontrada");
		}
	}

}
