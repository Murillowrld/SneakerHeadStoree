package SENAI.Ipiranga.com.sneakerHeadStore.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import SENAI.Ipiranga.com.sneakerHeadStore.Model.Usuario;
import SENAI.Ipiranga.com.sneakerHeadStore.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository Repository;
	private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	public UsuarioService(UsuarioRepository repository) {
		this.Repository = repository;
		
		}
	public Usuario cadastrarUsuario(Usuario usuario) {

	    if (usuario == null) {
	        throw new IllegalArgumentException(
	                "Os dados do usuário não foram informados");
	    }
	    if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
	        throw new IllegalArgumentException("A senha deve ser informada");
	    }

	    String senhaEncoder = encoder.encode(usuario.getSenha());
	    usuario.setSenha(senhaEncoder);
	    return Repository.save(usuario);
	}

	public Optional<Usuario> logar(Optional<Usuario> user) {

	    if (user == null || user.isEmpty()) {
	        return Optional.empty();
	    }

	    Usuario usuarioLogin = user.get();

	    if (usuarioLogin.getEmail() == null ||
	            usuarioLogin.getEmail().isBlank() ||
	            usuarioLogin.getSenha() == null ||
	            usuarioLogin.getSenha().isBlank()) {
	        return Optional.empty();
	    }

	    Optional<Usuario> usuarioEncontrado =
	            Repository.findByemail(usuarioLogin.getEmail());

	    if (usuarioEncontrado.isEmpty()) {
	        return Optional.empty();
	    }

	    Usuario usuarioBanco = usuarioEncontrado.get();

	    if (!encoder.matches(
	            usuarioLogin.getSenha(),
	            usuarioBanco.getSenha())) {
	        return Optional.empty();
	    }

	    String auth = usuarioLogin.getEmail() + ":" +
	            usuarioLogin.getSenha();
	    String encodedAuth = Base64.getEncoder()
	            .encodeToString(auth.getBytes(StandardCharsets.UTF_8));
	    String authHeader = "Basic " + encodedAuth;

	    usuarioLogin.setId(usuarioBanco.getId());
	    usuarioLogin.setNome(usuarioBanco.getNome());
	    usuarioLogin.setEmail(usuarioBanco.getEmail());
	    usuarioLogin.setCpf(usuarioBanco.getCpf());
	    usuarioLogin.setCep(usuarioBanco.getCep());

	    return Optional.of(usuarioLogin);
	}
}