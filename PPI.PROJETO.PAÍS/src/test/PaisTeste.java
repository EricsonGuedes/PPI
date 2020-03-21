package test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.PaisDAO;
import model.Pais;
import service.PaisService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PaisTeste {
	Pais pais, copia;
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

	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		System.out.println(PaisDAO.carregar(1));
	}
	
	@Test
	public void test01Vetor() {
		System.out.println("vetor");
		model.Pais[] vetor = PaisDAO.vetor3();
		for (model.Pais pais : vetor) {
			System.out.println(pais);
		}
	}
	

	@Test
	public void test03Carregar() {
		System.out.println("criar");
		Pais pais = new Pais(0, "Espanha", 46524943L, 504030.0);
		PaisService.criar(pais);
	}

	
	/**
	@Test
	public void test01Criar() {
		System.out.println("criar");
		PaisDAO.criar(nomePais, populacaoPais, areaPais);
		id = cliente.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", cliente, copia);
	}
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		cliente.setFone("999999");
		copia.setFone("999999");		
		cliente.atualizar();
		cliente.carregar();
		assertEquals("testa atualizacao", cliente, copia);
	}
	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setFone(null);
		copia.setEmail(null);
		cliente.excluir();
		cliente.carregar();
		assertEquals("testa exclusao", cliente, copia);
	}**/


}