package pacote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Servidor extends Thread{
	static ServerSocket servidor;
	static ArrayList<BufferedWriter> clientes;
	static Socket cliente;
	static Thread t1;
	String nome;
	
	InputStream stream;
	InputStreamReader reader;
	BufferedReader buffer;
	
	public Servidor(Socket cliente) {
		this.cliente = cliente;
		
		try {
			stream = cliente.getInputStream();
			reader = new InputStreamReader(stream);
			buffer = new BufferedReader(reader);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void run() {
		OutputStream output;
		OutputStreamWriter writer;
		BufferedWriter bufferW;
		String msg = "";
		try {
			output = this.cliente.getOutputStream();
			writer = new OutputStreamWriter(output);
			bufferW = new BufferedWriter(writer);
			clientes.add(bufferW);
			nome = msg = buffer.readLine();
			
			while(!"/Sair".equals(msg) && msg != null) {
					
					msg = buffer.readLine();
					System.out.println("Recebendo de Clientes: "+msg);

					if(msg.charAt(0)=='£'){
						distribuirMensagem(bufferW,msg+"\n");
					}
					else {
						distribuirMensagem(bufferW,nome	 +" escreveu "+msg+"\n");
					}
					
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void distribuirMensagem(BufferedWriter writer, String msg) throws IOException {
																	
		BufferedWriter writerAux;
		System.out.println("enviado para clientes: "+msg);
		for(BufferedWriter bw:clientes) {
			writerAux = bw;
			if(writer != writerAux) {
				bw.write(msg);
				bw.flush();
				
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		JLabel lblMensagem = new JLabel("Entre com a porta: ");
		JTextField txtPorta = new JTextField("12345");
		Object[] elementos = {lblMensagem,txtPorta};
		JOptionPane.showMessageDialog(null, elementos);
		
		servidor = new ServerSocket(Integer.parseInt
									(txtPorta.getText()));
		
		
		clientes = new ArrayList<BufferedWriter>();
		System.out.println("A porta "
				+Integer.parseInt(txtPorta.getText())+
				" foi aberta");
		
		while(true) {
			System.out.println("Aguardando a proxima conex√£o");
			cliente = servidor.accept();
			System.out.println("Cliente Conectado");
			t1 = new Servidor(cliente);
			t1.start();
		}
	}
}
