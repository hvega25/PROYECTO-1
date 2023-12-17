package principal.bolsa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import principal.bolsa.entity.Empresa;
import principal.bolsa.repository.EmpresaRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

//esto prueba toda la app @SpringBootTest 
@DataJpaTest //esto es para un controlador en especifico
class BolsaTrabajoApplicationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmpresaRepository empresaRepositorio;


    //prueba de Persistencia

    private Empresa insertarEmpresa(Empresa empresa) {

        //entityManager.persist(empresa);
        entityManager.merge(empresa);
        entityManager.flush();
        return empresa;
    }

    //Para comprobar persistencia
    @Test
    void gifindAllByName() {
        Empresa em = new Empresa(56, "nombre1", "direccion2", "telefono1", "correo2");
        Empresa em2 = new Empresa(64, "nombre16", "direccion2", "telefono1", "correo2");

        em = insertarEmpresa(em);
        em2 = insertarEmpresa(em2);

        List<Empresa> empresas = empresaRepositorio.findEmpresaByNombre("nombre1");
        assertEquals(1, empresas.size());
        //assertEquals( 1L, empresas.get(0).getId());


<<<<<<< Updated upstream
	}
=======
    }

    /*//Para el uso del sql
    @Test
    @Sql("empresas.sql")
    void findAllwithSQL() {
        List<Empresa> em = empresaRepositorio.findAll();
        assertEquals(4, em.size());

    }*/
>>>>>>> Stashed changes


}
