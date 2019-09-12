package cliente;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import hello.Hello;
import hello.HelloHelper;

public class Cliente {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			ORB orb = ORB.init(args, null);
			
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			
			Hello oi = HelloHelper.narrow(ncRef.resolve_str("OLA-SERVER"));
			oi.say_hello();
			String msg = oi.say_this("Teste 123");
			System.out.println("Cliente: " + msg);
	}

}
