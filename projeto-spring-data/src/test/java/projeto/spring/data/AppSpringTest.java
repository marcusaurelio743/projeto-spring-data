package projeto.spring.data;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.dao.InterfaceSpringDataUser;
import projeto.spring.data.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Test 
	public void testeInsert() {
		UsuarioSpringData usuario = new UsuarioSpringData();
		usuario.setEmail("Usuario@test.com.br");
		usuario.setIdade(27);
		usuario.setLogin("Usuario@email.com");
		usuario.setSenha("admin");
		usuario.setNome("Pelé");
		
		 interfaceSpringDataUser.save(usuario);
		System.out.println("Usuarios cadastrados "+interfaceSpringDataUser.count());
	}
	
	@Test 
	public void testeConsulta() {
		
		Optional<UsuarioSpringData> usuario = interfaceSpringDataUser.findById(5L);
		usuario.get();
		
		System.out.println(usuario);
		
		System.out.println("===============================================");
		List<UsuarioSpringData> usuarios =  (List<UsuarioSpringData>) interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuarioSpringData : usuarios) {
			
			System.out.println(usuarioSpringData);
		}
	}

}
