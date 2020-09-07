package biz.fabiotecnico1.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity													//Anotação do pacote JPA para conversão do objeto relacional
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// Define estratégia para geração automática das chaves primárias
	private Integer id;
	private String nome;
	
	@JsonManagedReference								//Referencia gerenciada pelo Json - De onde desejo a referência
	@ManyToMany(mappedBy = "categorias")				//JPA - relacionamento instanciado na lista da associação do produto
	private List<Produto> produtos = new ArrayList<>();	//Associação da categoria com o produto
	
	public Categoria() {							//Constutor sem parâmetros
	}

	// Generated Constructor using field
	public Categoria(Integer id, String nome) {		//Construtor com parâmetros
		super();
		this.id = id;
		this.nome = nome;
	}

	// Generated Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	//Generated hashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
