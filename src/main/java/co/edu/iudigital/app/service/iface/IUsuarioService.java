package co.edu.iudigital.app.service.iface;

import java.util.List;

import co.edu.iudigital.app.dto.UsuarioDto;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.model.Usuario;

public interface IUsuarioService {

	public List<UsuarioDto> listUsers() throws RestException;
	
	public Usuario listUser(Long id) throws RestException;
	
	public Usuario saveUser(Usuario usuario) throws RestException;
	
	public Usuario listByUsername(String username);
	
	public Usuario updateUser(Usuario usuario) throws RestException;
}
