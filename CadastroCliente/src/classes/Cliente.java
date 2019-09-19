package classes;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import cadastroPessoa.Pessoa;
import cadastroPessoa.PessoaDAO;
import cadastroPessoa.PessoaDAOHelper;
import cadastroPessoa.PessoaHelper;


public class Cliente {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ORB orb = ORB.init(args, null);
		
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		
		Pessoa pessoa = PessoaHelper.narrow(ncRef.resolve_str("CAD-SERVER"));
		PessoaDAO pessoaDAO = PessoaDAOHelper.narrow(ncRef.resolve_str("CAD-SERVER-DAO"));
		
		pessoa.setNome("Alexandre Corba");
		pessoa.setEmail("alexandre@corba.edu.br");
		
		pessoaDAO.adicionar(pessoa);
	}

}
