package servidor;

import hello.HelloPOA;

public class HelloImpl extends HelloPOA{

	@Override
	public void say_hello() {
		// TODO Auto-generated method stub
		System.out.println("Servidor: Olá Mundo!");
	}

	@Override
	public String say_this(String msg) {
		// TODO Auto-generated method stub
		
		System.out.println("Servidor recebeu a msg: " + msg);
		return msg;
	}

}
