package servidor;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CalculadoraApp.CalculadoraServer;
import CalculadoraApp.CalculadoraServerHelper;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ORB orb = ORB.init(args, null);
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			
			// Inicializar o nosso objeto
			CalculadoraImpl calculadoraImpl = new CalculadoraImpl();
			
			// Transformar o objeto em referência
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(calculadoraImpl);
			CalculadoraServer calc = CalculadoraServerHelper.narrow(ref);
			
			// Obtém a referência do nameservice;
			org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objref);
			
			// Liga o objeto ao nome da rede a ORB
			NameComponent n[] = ncRef.to_name("CALC-SERVER");
			ncRef.rebind(n, calc);
			System.out.println("Servidor está em execução...");
			orb.run();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
