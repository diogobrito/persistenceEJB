package br.com.fiap.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Remove;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ChamadoBean implements ChamadoRemote {
	
	@PersistenceContext
	private EntityManager em; 
	
	private List<Chamado> chamados;
	
	public ChamadoBean() {
		chamados = new ArrayList<Chamado>();
	}
	
	@Resource
	private SessionContext ctx;

	public void cadastrar(Chamado chamado) {
		em.persist(chamado);
		/*chamados.add(chamado);
		System.out.println("Chamado [" + chamado.getDescricao() + "] registrado com sucesso.");*/
	}

	public List recuperarTodos() {
		return chamados;
	}

	@Remove
	public void checkout() {
		System.out.println("Removendo instancia deste EJB.");
	}
	
}
