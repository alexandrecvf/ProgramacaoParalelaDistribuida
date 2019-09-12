package cliente;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import CalculadoraApp.CalculadoraServer;
import CalculadoraApp.CalculadoraServerHelper;

public class Cliente {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ORB orb = ORB.init(args, null);
		
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		
		CalculadoraServer calc = CalculadoraServerHelper.narrow(ncRef.resolve_str("CALC-SERVER"));
		
		int a = calc.somar(20, 30);
		System.out.println("20 + 30 = " + a);
		
	}

}
