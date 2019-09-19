package banco;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/aula18", "root", "");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro! Não Conectado");
			throw new RuntimeException(e);
		}
	}
}
