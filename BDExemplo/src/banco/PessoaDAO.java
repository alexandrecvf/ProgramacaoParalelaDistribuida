package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Pessoa;

public class PessoaDAO {
	public Connection conexao;
	
	public PessoaDAO() {
		this.conexao = new ConnectionFactory().getConnection();
		System.out.println("Conectado com sucessoa ao BD!");
	}
	
	public void adicionar(Pessoa pessoa) {
		String sql = "insert into pessoa (nome, email)" + "values(?,?)";
		
		try {
			PreparedStatement par = conexao.prepareStatement(sql);
			par.setString(1, pessoa.getNome());
			par.setString(2, pessoa.getEmail());
			par.execute();
			par.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu errado");
		}
	}
	
	public void remover(String nomePessoa) {
		String sql = "Delete from pessoa where nome = ?";
		
		try {
			PreparedStatement par = conexao.prepareStatement(sql);
			par.setString(1, nomePessoa);
			
			par.execute();
			par.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu errado na hora de remover");
		}
	}
	
	public List<Pessoa> pesquisar(String nomePessoa) {
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		String sql = "select * from pessoa where nome like ?";
		
		try {
			PreparedStatement par = conexao.prepareStatement(sql);
			par.setString(1, nomePessoa);
			
			ResultSet rs = par.executeQuery();
			while(rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setEmail(rs.getString("email"));
				
				listaPessoas.add(pessoa);
			}
			
			rs.close();
			par.close();
			
			return listaPessoas;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu errado na hora de pesquisar");
			return null;
		}
	}
}
