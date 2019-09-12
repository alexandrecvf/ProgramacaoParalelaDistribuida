package pacote;

import java.io.IOException;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Janela.getInstance();
		
		try {
			Janela.getInstance().conectar();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Servidor não encontrado!");
			System.exit(0);
		}
		
		new Thread(Janela.getInstance()).start();
	}

}
