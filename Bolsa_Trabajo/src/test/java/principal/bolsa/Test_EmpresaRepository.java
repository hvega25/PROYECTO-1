package principal.bolsa;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Test_EmpresaRepository {/*
	
    @Autowired
    private EmpresaRepository empresaRepository;
    
    
    @Test
    void testObtenerEmpresa() {
        
        List<AdminDTO> empresas = empresaRepository.ObtenerEmpresa();
        
        //Verificar si no hay datos nulos en empresa
        assertNotNull(empresas);
        //Si hay mas de una
        assertTrue(empresas.size() > 0);
        
        //Comprobar la empresa 1
        AdminDTO primeraEmpresa = empresas.get(0);
        assertNotNull(primeraEmpresa.getNombre());
        assertNotNull(primeraEmpresa.getDireccion());
        assertTrue(primeraEmpresa.getTelefono().matches("\\d+"));
        assertNotNull(primeraEmpresa.getCorreo());
        
    }
    
    @Test
    void testObtenerEmpresaById() {
    	
        Long id = 1L; // Reemplaza con un ID válido
        AdminDTO empresa = empresaRepository.obtenerEmpresa(id);
        assertNotNull(empresa);
        
    }
*/
}
