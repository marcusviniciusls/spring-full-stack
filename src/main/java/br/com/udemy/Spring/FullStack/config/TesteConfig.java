package br.com.udemy.Spring.FullStack.config;

import br.com.udemy.Spring.FullStack.domain.*;
import br.com.udemy.Spring.FullStack.domain.enums.Natureza;
import br.com.udemy.Spring.FullStack.repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

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
    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private TelefoneRepository telefoneRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        // Criação de Categorias
        Categoria categoria = new Categoria("Informática");
        Categoria categoria1 = new Categoria("Escritório");
        Categoria categoria2 = new Categoria("Elétrico");
        Categoria categoria3 = new Categoria("Vestuário");
        Categoria categoria4 = new Categoria("Biblioteca");
        Categoria categoria5 = new Categoria("Informática");
        Categoria categoria6 = new Categoria("Escritório");
        Categoria categoria7 = new Categoria("Elétrico");
        Categoria categoria8 = new Categoria("Vestuário");
        Categoria categoria9 = new Categoria("Biblioteca");
        Categoria categoria10 = new Categoria("Informática");
        Categoria categoria11 = new Categoria("Escritório");
        Categoria categoria12 = new Categoria("Elétrico");
        Categoria categoria13 = new Categoria("Vestuário");
        Categoria categoria14 = new Categoria("Biblioteca");
        Categoria categoria15 = new Categoria("Informática");
        Categoria categoria16 = new Categoria("Escritório");
        Categoria categoria17 = new Categoria("Elétrico");
        Categoria categoria18 = new Categoria("Vestuário");
        Categoria categoria19 = new Categoria("Biblioteca");
        categoriaRepository.saveAll(Arrays.asList(categoria,categoria1,categoria2,categoria3,categoria4,
                categoria5,categoria6,categoria7,categoria8,categoria9,categoria10,categoria11,categoria12,
                categoria13,categoria14,categoria15,categoria16,categoria17,categoria18,categoria19));
        
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
        cidadeRepository.saveAll(Arrays.asList(cidade,cidade1,cidade2,cidade3,cidade4,cidade5,cidade6,cidade7,cidade8,cidade9));
        
        // Criação de Endereço
        Endereco endereco = new Endereco("Rua Caetano Basso","252","Parque Savoi City","03584-130",cidade);
        Endereco endereco1 = new Endereco("Rua Piquinhu","227","Vila Ré","03657-010",cidade);
        Endereco endereco2 = new Endereco("Rua Bernado","100","Sé","00000-100",cidade1);

        // Criação de Telefones
        Telefone telefone = new Telefone("11","99352-7709");
        Telefone telefone1 = new Telefone("11","98934-7080");
        Telefone telefone2 = new Telefone("21","3569-0873");

        
        Cliente cliente = new Cliente("Marcus Vinicius","viniciusmls@outlook.com", 0, "467518998-90");
        cliente.addListaEndereco(endereco);
        cliente.addListaEndereco(endereco1);

        Cliente cliente1 = new Cliente("Antonio Lima","antonio@gmail.com", 1, "46130373368");
        cliente1.addListaEndereco(endereco2);

        endereco.setCliente(cliente);
        endereco1.setCliente(cliente);
        endereco2.setCliente(cliente1);

        telefone.setCliente(cliente);
        telefone1.setCliente(cliente);
        telefone2.setCliente(cliente1);

        cliente.addListaTelefone(telefone);
        cliente.addListaTelefone(telefone1);
        cliente1.addListaTelefone(telefone2);

        ItemPedido itemPedido = new ItemPedido(new BigDecimal("100.00"), 3, new BigDecimal("500"));
        itemPedido.setProduto(produto);

        Pedido pedido = new Pedido(endereco);

        pedido.addListaItemPedidos(itemPedido);
        itemPedido.setPedido(pedido);
        clienteRepository.saveAll(Arrays.asList(cliente1,cliente));
        pedidoRepository.save(pedido);
        itemPedidoRepository.save(itemPedido);
        enderecoRepository.saveAll(Arrays.asList(endereco,endereco1,endereco2));

        telefoneRepository.save(telefone);
        telefoneRepository.save(telefone1);
        telefoneRepository.save(telefone2);



    }
}
