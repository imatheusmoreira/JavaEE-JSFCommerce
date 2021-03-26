package br.edu.ifce.utils;

import javax.persistence.EntityManager;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.edu.ifce.model.Usuario;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	private EntityManager manager = JPAUtil.getEntityManager();

	public UserDetails loadUserByUsername(String username) {
		Usuario usuario =  manager.createQuery("from Usuario where login = :username", Usuario.class)
				.setParameter("username", username).getSingleResult();
		return new User(username, usuario.getSenha(), usuario.getActive(), true, true, true, usuario.getAuthorities());

	}
}