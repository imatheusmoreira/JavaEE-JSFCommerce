package br.edu.ifce.code;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifce.model.Produto;
import br.edu.ifce.model.Usuario;
import br.edu.ifce.utils.JPAUtil;


public class ConsultasJPQL {
	public static void main (String args[]) throws IOException {
		EntityManager manager = JPAUtil.getEntityManager();
		populardb(manager);
	}	
	
	public static List<Produto> consulta_inicial(EntityManager manager) {
		String jpql = "select p from Produto p order by p.descricao";
		TypedQuery<Produto> consulta = manager.createQuery(jpql, Produto.class);
		return consulta.getResultList();		
	}	
	
	public static void populardb(EntityManager manager) throws IOException {
		manager.getTransaction().begin();
		//##########################################################
		Usuario usuario = new Usuario();
	    usuario.setLogin("admin");
	    usuario.setSenha("123456");
	    
	    usuario.getPermissao().add("ROLE_ADMIN");
	    usuario.getPermissao().add("ROLE_USER");	    
	    
	    usuario.setActive(true);
	    
		//##########################################################
		Produto agua = new Produto();
		agua.setCodigo(10120L);
		agua.setDescricao("Agua Mineral 500ML");
		agua.setValor(new BigDecimal("3.50"));
		agua.setFoto("https://www.mercadinholobao.com.br/wp-content/uploads/2020/08/e7d98be07bb2dddb84f3a3b1c9900cc1.png");
		
		Produto kisuco = new Produto();
		kisuco.setCodigo(10121L);
		kisuco.setDescricao("Kisuco Angélica");
		kisuco.setValor(new BigDecimal("0.50"));
		kisuco.setFoto("https://angelicacollection.files.wordpress.com/2014/02/angcoll-merch-10.jpg");
		
		Produto leite = new Produto();
		leite.setCodigo(10122L);
		leite.setDescricao("Leite Condensado");
		leite.setValor(new BigDecimal("2.83"));
		leite.setFoto("http://superprix.vteximg.com.br/arquivos/ids/173107-600-600/Leite-Condensado-Itambe-Nolac-395g--Lata-.png");
		
		manager.persist(usuario);
		manager.persist(agua);
		manager.persist(kisuco);
		manager.persist(leite);
		
		manager.getTransaction().commit();	
	}
	
}
