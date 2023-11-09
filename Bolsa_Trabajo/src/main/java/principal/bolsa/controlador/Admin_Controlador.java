package principal.bolsa.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@GetMapping("empresaID/{id}/ofertas")

	public List<Oferta> getOfertasByEmpresaId(@PathVariable Long id) {
		Empresa empresa = empresaRepositorio.findById(id).orElseThrow();
		return empresa.getOfertas();
	}

	// Metodo para eliminar las ofertas asociadas a una empresa
	@DeleteMapping("elminar/empresaID/{empresaId}/ofertaID/{ofertaId}")
	public ResponseEntity<String> eliminarOferta(@PathVariable Long empresaId, @PathVariable Long ofertaId) {
	    Empresa empresa = empresaRepositorio.findById(empresaId).orElse(null);
	    if (empresa == null) {
	        // Manejar el caso en que la empresa no se encuentra
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa no encontrada");
	    }

	    Oferta oferta = ofertaRepositorio.findById(ofertaId).orElse(null);
	    if (oferta == null) {
	        // Manejar el caso en que la oferta no se encuentra
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oferta no encontrada");
	    }

	    // Eliminar la oferta de la lista de ofertas de la empresa
	    empresa.getOfertas().remove(oferta);
	    oferta.setEmpresa(null);

	    // Guardar la empresa y la oferta con las listas actualizadas
	    empresaRepositorio.save(empresa);
	    ofertaRepositorio.save(oferta);

	    return ResponseEntity.ok("Oferta eliminada correctamente de la empresa");

	}
	








}
