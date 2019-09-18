package classes;

import java.util.List;

import banco.PessoaDAO;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Pessoa> listPessoas;
		PessoaDAO cadPes = new PessoaDAO();
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Alexandre2");
		pessoa1.setEmail("alexandrevilarinhof@gmail.com");
		
		//cadPes.adicionar(pessoa1);
		listPessoas = cadPes.pesquisar("Alexandre%");
		
		for (Pessoa pessoa : listPessoas) {
			System.out.print("ID: " + pessoa.getId() + " - ");
			System.out.print("Nome: " + pessoa.getNome() + " - ");
			System.out.println("Email: " + pessoa.getEmail());
		}
		
	}

}
