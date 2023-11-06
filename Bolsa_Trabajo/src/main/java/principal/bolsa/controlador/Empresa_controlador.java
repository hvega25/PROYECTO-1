package principal.bolsa.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/empresa")
public class Empresa_controlador {

	@Autowired
	private EmpresaRepository empresarepositorio;

	// método para consultar solo un elemento de la base de datos

	@GetMapping("/cosultarEmpresa/{id}")
	Empresa consulta(@PathVariable Long id) {
		return empresarepositorio.findById(id).orElseThrow();
	}
	
	
	@GetMapping("/{id}/ofertas")
	public List<Oferta> getOfertasByEmpresaId(@PathVariable Long id) {
	    Empresa empresa = empresarepositorio.findById(id).orElseThrow();
	    return empresa.getOfertas();
	}

	// método para consultar todos los datos de la base de datos
	@GetMapping("/consultar")
	public List<Empresa> getAllEmpresas() {
		return empresarepositorio.findAll();
	} 

//método para agregar a la base de datos
	@PostMapping("/agregar")
	public Empresa agregarEmpresa(@RequestBody Empresa nuevaEmpresa) {
		// Guardar la nueva oferta en la base de datos
		Empresa empresaGuardada = empresarepositorio.save(nuevaEmpresa);
		return empresaGuardada;
	}
	
    //Eliminar por id
    @DeleteMapping("/eliminar/{empresaId}")
    public ResponseEntity<?> eliminarEmpresaPorId(@PathVariable Long empresaId) {
    	empresarepositorio.deleteById(empresaId);
        return ResponseEntity.ok("Empresa eliminada correctamente");
    }

	//Modificar datos por id
	@PutMapping("/actualizar/{id}")
	public Empresa actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresaActualizada){
		Empresa empresaExiste = empresarepositorio.findById(id).orElse(null);
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

		empresarepositorio.save(empresaExiste);
		return empresaExiste;
	}
}
