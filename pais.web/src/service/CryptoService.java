package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class CryptoService {

	public String criptografar(String original) {
		String hashed_pwd = new String(); 

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); 

			try{
				md.update(original.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}

			byte[] digest = md.digest();

			hashed_pwd = Base64.getEncoder().encodeToString(digest);

			System.out.println("string original: " + original);
			System.out.println("digested(hex): " + hashed_pwd);

		} catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}

		return hashed_pwd;
	}
}