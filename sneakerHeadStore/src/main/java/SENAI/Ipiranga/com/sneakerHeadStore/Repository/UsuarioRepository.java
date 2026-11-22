package SENAI.Ipiranga.com.sneakerHeadStore.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import SENAI.Ipiranga.com.sneakerHeadStore.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public List<Usuario> findByNomeContainingIgnoreCase(String nome);
	public Optional<Usuario> findByemail(String email);
	Optional<Usuario> findBycpf(String cpf);
	

}
