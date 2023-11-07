package principal.bolsa.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import principal.bolsa.repository.EmpresaRepository;
import principal.bolsa.repository.OfertaRepository;

@RestController
@RequestMapping("/admin")
public class Admin_Controlador {
	
	
	@Autowired
	private EmpresaRepository empresarepositorio;
	
	@Autowired   
	private OfertaRepository ofertaRepositorio ; 

}
