package principal.bolsa.controlador;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oferta")
public class Oferta_controlador {
	
	@GetMapping("/")
	public String consultar() { 
		return "hola";
	}

}

