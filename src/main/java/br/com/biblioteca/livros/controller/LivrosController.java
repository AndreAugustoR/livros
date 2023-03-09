package br.com.biblioteca.livros.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.livros.model.Livros;
import br.com.biblioteca.livros.repo.LivrosRepo;


@RestController
public class LivrosController {

	@Autowired
	private LivrosRepo repo;

	@GetMapping("/livros")
	public ArrayList<Livros> recuperarTodos() {
		return (ArrayList<Livros>) repo.findAll();
	}

	@GetMapping("/livros/{id}")
	public ResponseEntity<Livros> recuperarPeloId(@PathVariable int id) {
		Livros l = repo.findById(id).orElse(null);
		if (l != null) {
			return ResponseEntity.ok(l);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/livros")
	public ResponseEntity<?> inserirLivro(@RequestBody Livros novo) {
		Livros res = repo.save(novo);
		if (res != null) {
			return ResponseEntity.status(201).body(res);
		}
		return (ResponseEntity<?>) ResponseEntity.badRequest();

	}

	@GetMapping("/livros/busca")
	public ResponseEntity<ArrayList<Livros>> buscarPorNome(@RequestParam(name = "palavra") String palavra) {
		ArrayList<Livros> lista = repo.findByTituloContaining(palavra) ;
		if (lista.size() > 0) {
			return ResponseEntity.ok(lista);
		}
		return ResponseEntity.status(404).body(null);
	}

	
}
