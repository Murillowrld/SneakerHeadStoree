package SENAI.Ipiranga.com.sneakerHeadStore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SENAI.Ipiranga.com.sneakerHeadStore.Model.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long>{

	public List<Tipo> findBynomeContainingIgnoreCase(String nome);
	public List<Tipo> findBymodeloContainingIgnoreCase(String modelo);
}
