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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	// Método que obtiene por id de una empresa las ofertas
	@GetMapping("/empresaID/{id}/ofertas")
	public List<Oferta> getOfertasByEmpresaId(@PathVariable Long id) {
		Empresa empresa = empresaRepositorio.findById(id).orElseThrow();
		return empresa.getOfertas();
	}

	//Método para actualizar una oferta 
	@PutMapping("/actualizarOferta/empresaID/{empresaId}/ofertaID/{ofertaId}")
	public Oferta editarOferta(@PathVariable Long empresaId, @PathVariable Long ofertaId,
			@RequestBody Oferta ofertaActualizada) {
		Empresa empresa = empresaRepositorio.findById(empresaId).orElse(null);
		if (empresa == null) {
			return null;
		}

		Oferta oferta = ofertaRepositorio.findById(ofertaId).orElse(null);
		if (oferta == null) {
			return null;
		}

		if (ofertaActualizada.getNombre() != null) {
			oferta.setNombre(ofertaActualizada.getNombre());
		}
		if (ofertaActualizada.getDescripcion() != null) {
			oferta.setDescripcion(ofertaActualizada.getDescripcion());
		}
		if (ofertaActualizada.getFecha() != null) {
			oferta.setFecha(ofertaActualizada.getFecha());
		}
		if (ofertaActualizada.getHorario() != null) {
			oferta.setHorario(ofertaActualizada.getHorario());
		}
		if (ofertaActualizada.getJornada() != null) {
			oferta.setJornada(ofertaActualizada.getJornada());
		}
		if (ofertaActualizada.getPuesto() != null) {
			oferta.setPuesto(ofertaActualizada.getPuesto());
		}

		ofertaRepositorio.save(oferta);

		return oferta;
	}
	


}
