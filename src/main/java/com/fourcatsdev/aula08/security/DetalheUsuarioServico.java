package com.fourcatsdev.aula08.security;

import com.fourcatsdev.aula08.modelo.Papel;
import com.fourcatsdev.aula08.modelo.Usuario;
import com.fourcatsdev.aula08.repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class DetalheUsuarioServico implements UserDetailsService {

	private UsuarioRepository usuarioRepository;
	
	public DetalheUsuarioServico(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByLogin(username);
		
		if(usuario != null && usuario.isAtivo()) {
			Set<GrantedAuthority> papeisDoUsuario = new HashSet<GrantedAuthority>();
			for(Papel papel: usuario.getPapeis()) {
				GrantedAuthority pp = new SimpleGrantedAuthority(papel.getPapel());
				papeisDoUsuario.add(pp);
			}			
			User user = new User(usuario.getLogin(), usuario.getPassword(), papeisDoUsuario);
			return user;
		} else {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
	}

}
