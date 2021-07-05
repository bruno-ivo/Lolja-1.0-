package br.com.alura.lolja.dao;

import javax.persistence.EntityManager;

import br.com.alura.lolja.modelo.Categoria;

public class CategoriaDAO {
	
	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar (Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void atualizar (Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remover (Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}
}