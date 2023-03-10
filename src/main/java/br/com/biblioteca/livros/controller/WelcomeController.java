package br.com.biblioteca.livros.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/") 
	public String sayWelcome() {
		return "<pre>"
		+ " Bem vindo a API de livros<br/>"
		+ " Endpoints Disponiveis <br/>"
		+ " /livros (GET) - para recuperar tudo<br/>"
		+ " /livros/id (GET) - para recuperar detalhes de um único livro<br/>"
		+ " /livros/busca (GET) - para buscar um livro com alguma palavra-chave ou parte de uma palavra<br/>"
		+ " /livros/id (DEL) - para deletar um livro do banco de dados</br>"
		+ " /livros (POST) - para incluir um novo livro</pre>";
	}

}
