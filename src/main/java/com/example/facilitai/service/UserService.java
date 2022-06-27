package com.example.facilitai.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.facilitai.model.User;
import com.example.facilitai.model.UserLogin;
import com.example.facilitai.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> cadastrarUsuario(User user)	{
		if (userRepository.findByEmailUser(user.getEmailUser()).isPresent())
			return Optional.empty();
		
		user.setSenhaUser(criptografarSenha(user.getSenhaUser()));
		
		return Optional.of(userRepository.save(user));
	}
	
	public Optional<User> atualizarUsuario(User user)
	{
		if (userRepository.findById(user.getIdUser()).isPresent())
		{
			user.setSenhaUser(criptografarSenha(user.getSenhaUser()));
			
			return Optional.ofNullable(userRepository.save(user));
		}
		
		return Optional.empty();
	}
	
	public Optional<UserLogin> autenticarUsuario(Optional<UserLogin> userLogin)
	{
		Optional<User> user = userRepository.findByEmailUser(userLogin.get().getEmailUser());
		
		if(user.isPresent())
		{
			if (compararSenhas(userLogin.get().getSenhaUser(), user.get().getSenhaUser()))
			{
				userLogin.get().setIdUser(user.get().getIdUser());
				userLogin.get().setNomeUser(user.get().getNomeUser());
				userLogin.get().setTipoUser(user.get().getTipoUser());
				userLogin.get().setToken(gerarBasicToken(userLogin.get().getEmailUser(), userLogin.get().getSenhaUser()));
				userLogin.get().setSenhaUser(user.get().getSenhaUser());
				
				return userLogin;			}
		}
		return Optional.empty();
	}

	private String criptografarSenha(String senha)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.encode(senha);
	}
	
	private boolean compararSenhas(String senhaDigitada, String senhaBanco)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.matches(senhaDigitada, senhaBanco);
	}
	
	private String gerarBasicToken(String usuario, String senha)
	{
		String token = usuario + ":" + senha;
		byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);
	}
}