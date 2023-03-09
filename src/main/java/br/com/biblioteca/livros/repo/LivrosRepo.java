package br.com.biblioteca.livros.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.biblioteca.livros.model.Livros;




public interface LivrosRepo extends CrudRepository<Livros, Integer> {

	
	public ArrayList<Livros> findByOrderByTitulo();
	public ArrayList<Livros> findByTituloContaining(String titulo);
}
