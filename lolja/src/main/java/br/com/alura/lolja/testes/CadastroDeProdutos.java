package br.com.alura.lolja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.lolja.dao.CategoriaDAO;
import br.com.alura.lolja.dao.ProdutoDAO;
import br.com.alura.lolja.modelo.Categoria;
import br.com.alura.lolja.modelo.Produto;
import br.com.alura.lolja.util.JPAUtil;

public class CadastroDeProdutos {

	public static void main(String[] args) {
		
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();		
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(p2 -> System.out.println(p.getNome()));
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "Muito Bom", new BigDecimal("800"), celulares);
		EntityManager em = JPAUtil.getEntityManager();		
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}
}
