package service;

import java.util.ArrayList;

import dao.PaisDAO;
import model.Pais;

public class PaisService {
		PaisDAO dao = new PaisDAO();
		
		@SuppressWarnings("static-access")
		public int criar(Pais pais) {
			return dao.criar(pais);
		}
		
		public void atualizar(Pais pais){
			dao.atualizar(pais);
		}
		
		public void excluir(int id){
			dao.excluir(id);
		}
		
		@SuppressWarnings("static-access")
		public Pais carregar(int id){
			return dao.carregar(id);
		}
		
		@SuppressWarnings({ "rawtypes", "static-access" })
		public ArrayList maiorPopulacao(Pais pais) {
			return dao.buscaMaiorPopulacao();
		}
		
		@SuppressWarnings({ "rawtypes", "static-access" })
		public ArrayList menorArea(ArrayList pais) {
			return dao.buscaMenorArea();
		}
		
		@SuppressWarnings("static-access")
		public Pais[] vetor3(Pais pais) {
			return dao.vetor3();
		}
	}
	

