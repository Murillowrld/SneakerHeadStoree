package SENAI.Ipiranga.com.sneakerHeadStore.Model;


	import java.util.List;

	import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	import jakarta.persistence.CascadeType;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.OneToMany;
	import jakarta.persistence.Table;

	@Entity
	@Table(name="usuario")
	public class Usuario {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		private String nome;
		private String email;
		private String senha;
		private String cpf;
		private String cep;
		@OneToMany(mappedBy = "usuario", cascade=CascadeType.REMOVE)
		@JsonIgnoreProperties("usuario")
		private List<Produto> produto;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getCep() {
			return cep;
		}
		public void setCep(String cep) {
			this.cep = cep;
		}
		public List<Produto> getProduto() {
			return produto;
		}
		public void setProduto(List<Produto> produto) {
			this.produto = produto;
		}
}
