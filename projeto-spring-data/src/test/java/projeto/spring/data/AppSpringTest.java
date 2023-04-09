package projeto.spring.data;

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
		System.out.println("Iniciou o Spring com sucesso !!!");
	}

}
