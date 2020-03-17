package PPI.PROJETO.PAÍS;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import org.junit.Before;

import org.junit.Test;


public class paisTeste {
	
	Pais pais, copia;
	static int id = 13;
	
	@Before
	public void setUp() throws Exception {
			System.out.println("setup");
			pais = new Pais(11, "Egito", 98313500 , 1001049 );
			copia = new Pais(11, "Egito", 98313500 , 1001049 );
			System.out.println(pais);
			System.out.println(copia);
			System.out.println(id);
		}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Pais fixture = new Pais(11, "Egito", 98313500 , 1001049 );
		Pais novo = new Pais(1, null, 0, 0);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}
		
	@Test
	public void test01Criar() {
		System.out.println("criar");
		pais.criar();
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
	}
	
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setArea(999999);
		pais.setPopulacao(999999);		
		pais.atualizar();
		pais.carregar();
		assertEquals("testa atualizacao", pais, copia);
	}
	
	@Test
		public void test03Excluir() {
			System.out.println("excluir");
			copia.setId(-1);
			copia.setNome(null);
			copia.setPopulacao(0);
			copia.setArea(0);
			pais.excluir();
			pais.carregar();
			assertEquals("testa exclusao", pais, copia);
		}

}
