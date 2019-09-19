package classes;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import banco.PessoaDAOImpl;
import cadastroPessoa.Pessoa;
import cadastroPessoa.PessoaDAO;
import cadastroPessoa.PessoaDAOHelper;
import cadastroPessoa.PessoaHelper;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ORB orb = ORB.init(args, null);
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			
			// Inicializar o nosso objeto
			PessoaImpl pessoaImpl = new PessoaImpl();
			PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();
			
			// Transformar o objeto em referência
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(pessoaImpl);
			Pessoa pessoa = PessoaHelper.narrow(ref);
			
			org.omg.CORBA.Object ref2 = rootpoa.servant_to_reference(pessoaDAOImpl);
			PessoaDAO pessoaDAO = PessoaDAOHelper.narrow(ref2);
			
			// Obtém a referência do nameservice;
			org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objref);
			
			// Liga o objeto ao nome da rede a ORB
			NameComponent n[] = ncRef.to_name("CAD-SERVER");
			ncRef.rebind(n, pessoa);
			
			NameComponent n2[] = ncRef.to_name("CAD-SERVER-DAO");
			ncRef.rebind(n2, pessoaDAO);
			
			System.out.println("Servidor do Cadastro de Pessoa está em execução...");
			orb.run();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
