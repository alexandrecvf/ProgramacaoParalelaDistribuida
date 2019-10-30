package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;

import classes.Pessoa;

public class PessoaDAO {
	public Connection conexao;
	
	public PessoaDAO() throws ServletException {
		this.conexao = new ConnectionFactory().getConnection();
		System.out.println("Conectado!");
	}
	
	public void adicionar(Pessoa pessoa) {
		String sql = "insert into pessoa (nome, email) values (?,?)";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getEmail());
			
			ps.execute();
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Não foi adicionado!");
		}
	}
}
