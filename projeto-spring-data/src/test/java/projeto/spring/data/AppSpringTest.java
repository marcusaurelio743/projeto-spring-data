package projeto.spring.data;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.dao.InterfaceSpringDataUser;
import projeto.spring.data.dao.InterfaceTelefone;
import projeto.spring.data.model.Telefone;
import projeto.spring.data.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;
	
	@Test 
	public void testeInsert() {
		UsuarioSpringData usuario = new UsuarioSpringData();
		usuario.setEmail("Usuario@test.com.br");
		usuario.setIdade(27);
		usuario.setLogin("Usuario@email.com");
		usuario.setSenha("admin");
		usuario.setNome("usuarioTeste");
		
		 interfaceSpringDataUser.save(usuario);
		System.out.println("Usuarios cadastrados "+interfaceSpringDataUser.count());
	}
	
	@Test
	public void teste1insert() {
		Optional<UsuarioSpringData> usuario = interfaceSpringDataUser.findById(7L);
		UsuarioSpringData user = usuario.get();
		user.setIdade(30);
		user.setNome("Usuario alterado");
		user = interfaceSpringDataUser.save(user);
		System.out.println(user);
	}
	
	
	
	@Test 
	public void testeConsulta() {
		
		Optional<UsuarioSpringData> usuario = interfaceSpringDataUser.findById(5L);
		usuario.get();
		
		System.out.println(usuario);
		for (Telefone telefone : usuario.get().getTelefones()) {
			System.out.println("============================================");
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
		}
		
		System.out.println("===============================================");
		
	}
	
	@Test
	public void consultarTodos() {
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			
			System.out.println(usuarioSpringData);
			System.out.println("====================================================");
			
			for(Telefone telefone : usuarioSpringData.getTelefones()) {
				System.out.println("Telefone");
				System.out.println(telefone.getNumero());
				System.out.println(telefone.getTipo());
				System.out.println(usuarioSpringData.getNome());
				System.out.println();
				System.out.println();
			}
			
			
		}
		
	}
	
	@Test
	public void testeUpdate() {
		Optional<UsuarioSpringData> usuario = interfaceSpringDataUser.findById(6L);
		UsuarioSpringData data = usuario.get();
		
		data.setNome("Pelé o rei do futebol");
		data.setIdade(40);
		data.setEmail("PeleAemail.com");
		data.setLogin("pele");
		data = interfaceSpringDataUser.save(data);
		
		System.out.println(data);
	}
	
	@Test
	public void testDeletar() {
		Optional<UsuarioSpringData> objeto = interfaceSpringDataUser.findById(8L);
		interfaceSpringDataUser.delete(objeto.get());
		/*outro jeito de deletar seria usando  interfaceSpringDataUser.deteteById(passando o Id)*/
	}
	
	@Test
	
	public void testBuscarporNome() {
		List<UsuarioSpringData> lista = interfaceSpringDataUser.buscaPorNome("H");
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println("=============================");
			System.out.println(usuarioSpringData);
		}
	}
	
@Test
	
	public void testBuscarporNomeParam() {
		UsuarioSpringData objeto = interfaceSpringDataUser.buscaPorNomeParam("Helena");
		
		
			System.out.println("=============================");
			System.out.println(objeto);
		
	}

	@Test
	public void testDeleteporNome() {
	
		interfaceSpringDataUser.DeletePorNome("Pelé da Silva");
	
	
	}
	
	@Test
	public void testUpdateModificado() {
		interfaceSpringDataUser.updateEmailporNome("email alterado", "TesteUsuario");
	}
	
	@Test
	public void testInsertTelefone(){
		Telefone telefone = new Telefone();
		telefone.setNumero("445454323");
		telefone.setTipo("Fixo");
		
		Optional<UsuarioSpringData> user = interfaceSpringDataUser.findById(3L);
		telefone.setUsuario(user.get());
		telefone = interfaceTelefone.save(telefone);
		
		System.out.println("===========================");
		System.out.println(telefone.getId());
		System.out.println(telefone.getNumero());
		System.out.println(telefone.getTipo());
		System.out.println(telefone.getUsuario());
	}

}
