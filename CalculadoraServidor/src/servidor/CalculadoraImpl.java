package servidor;

import CalculadoraApp.CalculadoraServerPOA;

public class CalculadoraImpl extends CalculadoraServerPOA{

	@Override
	public int somar(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int subtrair(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int multiplicar(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double dividir(int a, int b) {
		// TODO Auto-generated method stub
		if(b == 0) {
			return 0;
		} else {
			return a/b;
		}
		
	}

}
