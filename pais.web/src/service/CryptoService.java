package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class CryptoService {

	public String criptografar(String original) {
		//String que irá ter o hash, que será retornada no final
		String hashed_pwd = new String(); 
		
		try {
			//MessageDigest é a classe padrão no Java pra processar mensagens, podendo aplicar métodos de hash na mensagem
			//Pode mudar o parâmetro pra SHA-128, MD5, etc. Não tenho certeza de todos os métodos suportados
			MessageDigest md = MessageDigest.getInstance("SHA-256"); 
			try{
				//O update do MessageDigest atualiza o conteúdo da mensagem. Só será processado com a chamada do digest()
				//O parâmetro pro update() é um byte[], então convertemos a string original.
				//O método String.getBytes() aceita a codificação da string original como parâmetro, como boa prática, usamos UTF-8
				md.update(original.getBytes("UTF-8"));
				
			//Try-catch necessário pro String.getBytes, caso a codificação usada não exista
			} catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
			
			//Processa a mensagem no MessageDigest, gerando o novo byte[] processado
			byte[] digest = md.digest();
			
			//Converto o byte[] pra uma representação em String do Base64, que padroniza o comprimento e caracteres usados
			hashed_pwd = Base64.getEncoder().encodeToString(digest);

			System.out.println("string original: " + original);
			System.out.println("digested(hex): " + hashed_pwd);
			
		//Try-catch necessário pro MessageDigest.getInstance() (linha 14), caso o algoritmo selecionado não exista
		//Por exemplo, tentar passar "SHA-Qualquercoisa" como parâmetro vai levantar essa exceção
		} catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		
		return hashed_pwd;
	}
}