package biz.fabiotecnico1.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import biz.fabiotecnico1.cursomc.domain.Categoria;
import biz.fabiotecnico1.cursomc.domain.Cidade;
import biz.fabiotecnico1.cursomc.domain.Cliente;
import biz.fabiotecnico1.cursomc.domain.Endereco;
import biz.fabiotecnico1.cursomc.domain.Estado;
import biz.fabiotecnico1.cursomc.domain.Produto;
import biz.fabiotecnico1.cursomc.domain.emums.TipoCliente;
import biz.fabiotecnico1.cursomc.repositories.CategoriaRepository;
import biz.fabiotecnico1.cursomc.repositories.CidadeRepository;
import biz.fabiotecnico1.cursomc.repositories.ClienteRepository;
import biz.fabiotecnico1.cursomc.repositories.EnderecoRepository;
import biz.fabiotecnico1.cursomc.repositories.EstadoRepository;
import biz.fabiotecnico1.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{	//CommandLineRunner -> Permite executar uma ação ao inicar a aplicação

	@Autowired
	private CategoriaRepository categoriaRepository;		//Injeção de dependência do repositório de categorias
	
	@Autowired
	private ProdutoRepository produtoRepository; 			//Injeção de dependência do repositório de produtos
	
	@Autowired
	private CidadeRepository cidadeRepository;				//Injeção de dependência do repositório de cidade
	
	@Autowired
	private EstadoRepository estadoRepository;				//Injeção de dependência do repositório de estado
	
	@Autowired
	private ClienteRepository clienteRepository;			//Injeção de dependência do repositório de cliente
	
	@Autowired
	private EnderecoRepository enderecoRepository;			//Injeção de dependência do repositório de endereco
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { // Auto-generated method stub - assinatura do CommandLineRunner
		
		
		//Hard code Sample - inserted in database
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));	//Operação para salvar um ou uma lista de objeto - categoria
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3)); 	//Operação para salvar um ou uma lista de objeto - produto
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));	//Operação para salvar um ou uma lista de objeto - estado
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));	//Operação para salvar um ou uma lista de objeto - cidade
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Elores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c3); 
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));		//Operação para salvar um ou uma lista de objeto - cliente
		enderecoRepository.saveAll(Arrays.asList(e1, e2));	//Operação para salvar um ou uma lista de objeto - endereco
	}
}
