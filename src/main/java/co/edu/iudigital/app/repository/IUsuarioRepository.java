package co.edu.iudigital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.iudigital.app.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
	
	/*SELECT * FROM usuarios WHERE nombre='diana' AND apellido='jaramillo';
	
	public Usuario findByNombreAndApellido(String nombre, String apellido);
	
	@Query("SELECT u FROM usuario u WHERE u.nombre=?1 AND u.apellido=?2")
	public Usuario findByNombreAndApellido2(String nombre, String apellido);*/
	
	/**
	 * SELECT * FROM delitos d 
	 * INNER JOIN usuarios u 
	 * ON d.usuarios_id = u.id 
	 * WHERE u.nombre = 'diana';
	 */
	/*@Query(value = "SELECT * FROM delitos d "
			+ "INNER JOIN usuarios u ON d.usuarios_id = u.id "
			+ "WHERE u.nombre = ?1", nativeQuery = true)
	public List<Delitos> findDelitos(String nombre);*/
	
	public Usuario findByUsername(String email);

	@Query("SELECT u FROM Usuario u WHERE u.username=?1")
	public Usuario findByUsername2(String email);

}
