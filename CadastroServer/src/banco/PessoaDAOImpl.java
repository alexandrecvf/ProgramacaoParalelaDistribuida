package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cadastroPessoa.Pessoa;
import cadastroPessoa.PessoaDAOPOA;
import cadastroPessoa.PessoaDAOPackage.PessoaRetorno;

public class PessoaDAOImpl extends PessoaDAOPOA{
	public Connection conexao;

	@Override
	public void PessoaDAO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionar(Pessoa pessoa) {
		this.conexao = new ConnectionFactory().getConnection();		
		
		String sql = "insert into pessoa (nome, email)" + "values(?,?)";
		
		try {
			PreparedStatement par = conexao.prepareStatement(sql);
			par.setString(1, pessoa.getNome());
			par.setString(2, pessoa.getEmail());
			par.execute();
			par.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu errado na hora de adicionar!");
		}
		
		try {
			this.conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remover(String nomePessoa) {
		this.conexao = new ConnectionFactory().getConnection();
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
		
		try {
			this.conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public PessoaRetorno pesquisar(String nomePessoa) {
		this.conexao = new ConnectionFactory().getConnection();
		String sql = "select * from pessoa where nome like ?";
		PessoaRetorno pessoa = new PessoaRetorno();
		
		try {
			PreparedStatement par = conexao.prepareStatement(sql);
			par.setString(1, nomePessoa);
			
			ResultSet rs = par.executeQuery();
			
			while(rs.next()) {
				pessoa.id = rs.getInt("id");
				pessoa.nome = rs.getString("nome");
				pessoa.email = rs.getString("email");
			}
			
			rs.close();
			par.close();
			this.conexao.close();
			return pessoa;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu errado na hora de pesquisar");
			try {
				this.conexao.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
	}

}
