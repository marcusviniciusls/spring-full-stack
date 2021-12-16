package br.com.udemy.Spring.FullStack.config;

import br.com.udemy.Spring.FullStack.domain.Categoria;
import br.com.udemy.Spring.FullStack.domain.Cidade;
import br.com.udemy.Spring.FullStack.domain.Estado;
import br.com.udemy.Spring.FullStack.domain.Produto;
import br.com.udemy.Spring.FullStack.repositorys.CategoriaRepository;
import br.com.udemy.Spring.FullStack.repositorys.CidadeRepository;
import br.com.udemy.Spring.FullStack.repositorys.EstadoRepository;
import br.com.udemy.Spring.FullStack.repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        // Criação de Categorias
        Categoria categoria = new Categoria("Informática");
        Categoria categoria1 = new Categoria("Escritório");
        Categoria categoria2 = new Categoria("Elétrico");
        Categoria categoria3 = new Categoria("Vestuário");
        Categoria categoria4 = new Categoria("Biblioteca");        
        categoriaRepository.saveAll(Arrays.asList(categoria,categoria1,categoria2,categoria3,categoria4));
        
        // Criação de Produtos
        Produto produto = new Produto("Harry Potter e a Pedra FIlosofal",new BigDecimal("50.99"), categoria4);
        Produto produto1 = new Produto("Harry Potter e o Prisioneiro de Aszaban",new BigDecimal("100"), categoria4);
        Produto produto2 = new Produto("Canetas",categoria3);
        Produto produto3 = new Produto("Sapato", categoria3);
        Produto produto4 = new Produto("Cabos",new BigDecimal("100"), categoria2);
        produtoRepository.saveAll(Arrays.asList(produto,produto1,produto2,produto3,produto4));
        
        // Criação Estados
        Estado estado = new Estado("SP");
        Estado estado2 = new Estado("RJ");
        Estado estado1 = new Estado("CE");
        estadoRepository.saveAll(Arrays.asList(estado1,estado,estado2));
        
        // Criação Cidades
        Cidade cidade = new Cidade("São Paulo", estado);
        Cidade cidade9 = new Cidade("Campinas", estado);
        Cidade cidade1 = new Cidade("Sorocaba", estado);
        Cidade cidade2 = new Cidade("Bragança Paulista", estado);
        Cidade cidade3 = new Cidade("Santos", estado);
        Cidade cidade4 = new Cidade("Rio de Janeiro", estado2);
        Cidade cidade5 = new Cidade("Fluminense", estado2);
        Cidade cidade6 = new Cidade("Volta Redonda", estado2);
        Cidade cidade7 = new Cidade("Sobral", estado1);
        Cidade cidade8 = new Cidade("Fortaleza", estado1);
        cidadeRepository.saveAll(Arrays.asList(cidade,cidade1,cidade2,cidade3,cidade4,cidade5,cidade6,cidade7,cidade8));
        
        
        
    }
}
