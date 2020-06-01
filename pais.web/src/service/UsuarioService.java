package service;
import dao.UsuarioDAO;
import model.Usuario;


public class UsuarioService {

	public boolean validar(Usuario usuario){
		UsuarioDAO dao = new UsuarioDAO();
		CryptoService criptoService = new CryptoService();
		String senhaCriptografada = criptoService.criptografar(usuario.getPassword());
		usuario.setPassword(senhaCriptografada);
		return dao.validar(usuario);
	}

}
