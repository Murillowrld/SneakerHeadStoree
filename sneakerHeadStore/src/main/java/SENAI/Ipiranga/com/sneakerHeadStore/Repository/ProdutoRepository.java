package SENAI.Ipiranga.com.sneakerHeadStore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SENAI.Ipiranga.com.sneakerHeadStore.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto> findBynomeContainingIgnoreCase(String nome);
	public List<Produto> findBypreco (Double preco);

}
