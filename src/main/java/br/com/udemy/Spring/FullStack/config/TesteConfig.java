package br.com.udemy.Spring.FullStack.config;

import br.com.udemy.Spring.FullStack.domain.*;
import br.com.udemy.Spring.FullStack.repositorys.*;
import br.com.udemy.Spring.FullStack.services.EmailService;
import br.com.udemy.Spring.FullStack.services.MockEmailService;
import br.com.udemy.Spring.FullStack.services.SmtpEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Classe que inicia com informações salva no Banco de Dados
 */
@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CityRepository cityRepository;
    
    @Autowired
    private StateRepository stateRepository;
    
    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private TelephoneRepository telephoneRepository;
    
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        
        // Criação de Categorias
        Category categoria = new Category("Informática");
        Category categoria1 = new Category("Escritório");
        Category categoria2 = new Category("Elétrico");
        Category categoria3 = new Category("Vestuário");
        Category categoria4 = new Category("Biblioteca");
        Category categoria5 = new Category("Informática");
        Category categoria6 = new Category("Escritório");
        Category categoria7 = new Category("Elétrico");
        Category categoria8 = new Category("Vestuário");
        Category categoria9 = new Category("Biblioteca");
        Category categoria10 = new Category("Informática");
        Category categoria11 = new Category("Escritório");
        Category categoria12 = new Category("Elétrico");
        Category categoria13 = new Category("Vestuário");
        Category categoria14 = new Category("Biblioteca");
        Category categoria15 = new Category("Informática");
        Category categoria16 = new Category("Escritório");
        Category categoria17 = new Category("Elétrico");
        Category categoria18 = new Category("Vestuário");
        Category categoria19 = new Category("CATEGORIA QUE NÃO DEVERÁ APARECER");
        categoria19.setStatus(false);
        categoryRepository.saveAll(Arrays.asList(categoria,categoria1,categoria2,categoria3,categoria4,
                categoria5,categoria6,categoria7,categoria8,categoria9,categoria10,categoria11,categoria12,
                categoria13,categoria14,categoria15,categoria16,categoria17,categoria18,categoria19));

        // Criação de Produtos
        Product produto = new Product("Harry Potter e a Pedra FIlosofal",new BigDecimal("50.99"), categoria4);
        Product produto1 = new Product("Harry Potter e o Prisioneiro de Aszaban",new BigDecimal("100"), categoria4);
        Product produto2 = new Product("Canetas",categoria3);
        Product produto3 = new Product("Sapato", categoria3);
        Product produto4 = new Product("Cabos",new BigDecimal("100"), categoria2);
        produto.setCodyProduct("1");
        produto1.setCodyProduct("2");
        produto2.setCodyProduct("3");
        produto3.setCodyProduct("4");
        produto4.setCodyProduct("5");
        productRepository.saveAll(Arrays.asList(produto,produto1,produto2,produto3,produto4));

        // Criação Estados
        State estado = new State(25,"São Paulo","SP");
        State estado2 = new State(33,"Rio de Janeiro","RJ");
        State estado1 = new State(11,"Rondônia","RO");
        State estado3 = new State(12,"Acre","AC");
        State estado4 = new State(13,"Amazonas","AM");
        State estado5 = new State(14, "Roraima","RR");
        State estado6 = new State(15,"Pará","PA");
        State estado7 = new State(16,"Amapá","AP");
        State estado8 = new State(17,"Tocatins","TO");
        State estado9 = new State(21,"Maranhão","MA");
        State estado10 = new State(22,"Piauí","PI");
        State estado11 = new State(23,"Ceará","CE");
        State estado12 = new State(24,"Rio Grande do Norte","RN");
        State estado13 = new State(25,"Paraíba","PB");
        State estado14 = new State(26,"Pernanbuco","PE");
        State estado15 = new State(27,"Alagoas","AL");
        State estado16 = new State(28,"Sergipe","SE");
        State estado17 = new State(29,"Bahia","BA");
        State estado18 = new State(31,"Minas Gerais","MG");
        State estado19 = new State(32,"Espirito Santo","ES");
        State estado20 = new State(41,"Paraná","PR");
        State estado21 = new State(42,"Santa Catarina","SC");
        State estado22 = new State(43,"Rio Grande do Sul","RS");
        State estado23 = new State(50,"Mato Grosso do Sul","MS");
        State estado24 = new State(51,"Mato Grosso","MT");
        State estado25 = new State(52,"Goías","GO");
        State estado26 = new State(53,"Distrito Federal","DF");
        stateRepository.saveAll(Arrays.asList(estado1,estado,estado2,estado3,estado4,estado5,estado6,estado7
        ,estado8,estado9,estado10,estado11,estado12,estado13,estado14,estado15,estado16,estado17,estado18,
                estado19,estado20,estado21,estado22,estado23,estado24,estado25,estado26));

        // Criação Cidades
        City cidade = new City("São Paulo", estado);
        City cidade9 = new City("Campinas", estado);
        City cidade1 = new City("Sorocaba", estado);
        City cidade2 = new City("Bragança Paulista", estado);
        City cidade3 = new City("Santos", estado);
        City cidade4 = new City("Rio de Janeiro", estado2);
        City cidade5 = new City("Fluminense", estado2);
        City cidade6 = new City("Volta Redonda", estado2);
        City cidade7 = new City("Sobral", estado1);
        City cidade8 = new City("Fortaleza", estado1);
        cityRepository.saveAll(Arrays.asList(cidade,cidade1,cidade2,cidade3,cidade4,cidade5,cidade6,cidade7,cidade8,cidade9));

        // Criação de Endereço
        Address endereco = new Address("Rua Caetano Basso","252","Parque Savoi City","03584-130",cidade);
        Address endereco1 = new Address("Rua Piquinhu","227","Vila Ré","03657-010",cidade);
        Address endereco2 = new Address("Rua Bernado","100","Sé","00000-100",cidade1);

        // Criação de Telefones
        Telephone telefone = new Telephone("11","99352-7709");
        Telephone telefone1 = new Telephone("11","98934-7080");
        Telephone telefone2 = new Telephone("21","3569-0873");


        Client cliente = new Client("Marcus Vinicius","marcus.silva.dev@gmail.com", 0, "467518998-90");
        cliente.addListaEndereco(endereco);
        cliente.addListaEndereco(endereco1);
        cliente.setPassword(bCryptPasswordEncoder.encode("12345"));

        Client cliente1 = new Client("Antonio Lima","viniciusmls@outlook.com", 1, "46130373368");
        cliente1.addListaEndereco(endereco2);
        cliente1.setPassword(bCryptPasswordEncoder.encode("9876"));
        cliente1.addProfile(br.com.udemy.Spring.FullStack.domain.enums.Profile.ADMIN);

        endereco.setClient(cliente);
        endereco1.setClient(cliente);
        endereco2.setClient(cliente1);

        telefone.setClient(cliente);
        telefone1.setClient(cliente);
        telefone2.setClient(cliente1);

        cliente.addListaTelefone(telefone);
        cliente.addListaTelefone(telefone1);
        cliente1.addListaTelefone(telefone2);

        OrderItem itemPedido = new OrderItem(new BigDecimal("100.00"), 3, new BigDecimal("500"));
        OrderItem itemPedido1 = new OrderItem(new BigDecimal("0.00"), 1, new BigDecimal("500"));
        itemPedido.setProduct(produto);
        itemPedido1.setProduct(produto1);

        Pedido pedido = new Pedido(endereco);

        pedido.addListaItemPedidos(itemPedido);
        pedido.addListaItemPedidos(itemPedido1);
        itemPedido.setOrder(pedido);
        itemPedido1.setOrder(pedido);
        pedido.setClient(cliente);
        clientRepository.saveAll(Arrays.asList(cliente1,cliente));
        orderRepository.save(pedido);
        orderItemRepository.save(itemPedido);
        orderItemRepository.save(itemPedido1);
        addressRepository.saveAll(Arrays.asList(endereco,endereco1,endereco2));

        telephoneRepository.save(telefone);
        telephoneRepository.save(telefone1);
        telephoneRepository.save(telefone2);



    }
}
