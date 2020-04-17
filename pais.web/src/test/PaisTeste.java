package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import model.Pais;
import service.PaisService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PaisTeste {
	Pais pais, copia;
	PaisService paisService;
	static int id = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */

	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais();
		pais.setId(id);
		pais.setNome("Espanha");
		pais.setPopulacao(145123541);
		pais.setArea(45878475);
		copia = new Pais();
		copia.setId(id);
		copia.setNome("Espanha");
		copia.setPopulacao(145123541);
		copia.setArea(45878475);
		paisService = new PaisService();
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}

	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Pais teste = new Pais();
		teste.setId(0);
		teste.setNome("Brasil");
		teste.setPopulacao(210147125);
		teste.setArea(8515767.00);
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(1);
		System.out.println(teste);
		System.out.println(novo);
		assertEquals("testa inclusao", novo, teste);

	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = paisService.criar(pais);
		System.out.println(id);
		copia.setId(id);
		System.out.println(pais);
		assertEquals("testa criacao", pais, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setArea(9000000);
		copia.setArea(9000000);		
		paisService.atualizar(pais);
		pais = paisService.carregar(pais.getId());
		System.out.println(copia);
		System.out.println(pais);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		paisService.excluir(id);
		pais = paisService.carregar(id);
		assertEquals("testa exclusao", pais, copia);
	}

	@Test
	public void test04maiorpopu�acao() {
		System.out.println("Maior Populacao");


	}

	@Test
	public void test05menorArea() {
		System.out.println("Maior Populacao");
		System.out.println(paisService.maiorPopulacao());

	}

	@Test
	public void test05PaisMenor() {
		System.out.println("Busca do pa�s menor");
		System.out.println(paisService.menorArea());
		System.out.println("--------------------------------------------------------------------------------------------");
	}

	@Test
	public void test02OutroVetor() {
		System.out.println("outro");
		Pais[] vetor = paisService.vetor3();
		for (Pais pais : vetor) {
			System.out.println(pais);
		}
	}
}
