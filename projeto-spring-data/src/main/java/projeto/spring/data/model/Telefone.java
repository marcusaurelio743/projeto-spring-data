package projeto.spring.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	
	private String numero;
	private String tipo;

	@ManyToOne(optional = false)
	private UsuarioSpringData usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public UsuarioSpringData getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioSpringData usuario) {
		this.usuario = usuario;
	}

}
