package pacote;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Janela extends JFrame implements Runnable, ActionListener, KeyListener{
	
	static Janela janelinha;
	
	JLabel lblBemVindos,lblConectar;
	JTextField txtIP,txtPorta,txtNome,txtMsg;
	JTextArea texto;
	JButton btnEnviar,btnSair;
	Desenho desenho;
	
	Socket cliente;
	OutputStream output;
	OutputStreamWriter writer;
	BufferedWriter buffer;
	
	public Janela() {
		super("Bate Papo - Desenho");
		this.setSize(800,600);
		this.setVisible(true);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		desenho = new Desenho();
		desenho.setBounds(450, 0, 350, 600);
		desenho.setVisible(true);
		add(desenho);
		
		lblConectar = new JLabel("Conecte: ");
		txtIP = new JTextField("127.0.0.1");
		txtPorta = new JTextField("12345");
		txtNome = new JTextField("Pessoa");
		Object[] elementos = {lblConectar,txtIP,
									txtPorta,txtNome};
		JOptionPane.showMessageDialog(this, elementos);
		
		lblBemVindos = new JLabel();
		lblBemVindos.setBounds(10,10,200,20);
		lblBemVindos.setText("Janela de Bate-Papo");
		lblBemVindos.setVisible(true);
		add(lblBemVindos);
		
		texto = new JTextArea();
		texto.setBounds(10,30,300,300);
		texto.setEditable(false);
		texto.setVisible(true);
		add(texto);
		texto.setBorder(BorderFactory.
						createEtchedBorder(Color.blue,Color.blue));
		
	
		txtMsg = new JTextField();
		txtMsg.setBounds(10,340,300,50);
		txtMsg.setEditable(true);
		txtMsg.setVisible(true);
		add(txtMsg);
		txtMsg.setBorder(BorderFactory.
						createEtchedBorder(Color.red,Color.red));
		txtMsg.addKeyListener(this);
		
		
		btnEnviar = new JButton();
		btnEnviar.setBounds(310,340,50,50);
		btnEnviar.setText(">");
		btnEnviar.setVisible(true);
		add(btnEnviar);
		btnEnviar.setToolTipText("Enviar Mensagem");
		btnEnviar.addActionListener(this);
		
		
		btnSair = new JButton();
		btnSair.setBounds(360,340,50,50);
		btnSair.setText("X");
		btnSair.setVisible(true);
		add(btnSair);
		btnSair.setToolTipText("Sair do Bate Papo");
		btnSair.addActionListener(this);
		
		
		this.repaint();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void conectar() throws NumberFormatException, UnknownHostException, IOException {
		cliente = new Socket(txtIP.getText(),
								Integer.parseInt(txtPorta.getText()));
		output = cliente.getOutputStream();
		writer = new OutputStreamWriter(output);
		buffer = new BufferedWriter(writer);
		
		buffer.write(txtNome.getText()+"\n");
		buffer.flush();
		System.out.println("Conectado com Sucesso");
		
		
	}
	
	public void enviarMensagem(String msg) throws IOException {
		if(msg.equals("/Sair")) {
			buffer.write("Desconectado \n");
			texto.append("Desconectado \n");
		}
		else if (msg.charAt(0) == '£') {
			buffer.write(msg+"\n");
		}
		else {
			
			buffer.write(msg+"\n");
			texto.append(txtNome.getText()+" escreveu "+msg+"\n");
		}
		buffer.flush();
		txtMsg.setText("");
	}
	
	public void sair() throws IOException {
		buffer.write("Desconectado \n");
		texto.append("Desconectado \n");
				
		buffer.close();
		writer.close();
		output.close();
		cliente.close();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		InputStream stream;
		InputStreamReader reader;
		BufferedReader buffer;
		String msg = "";
		int x=0,y=0;
		
		try {
			stream = cliente.getInputStream();
			reader = new InputStreamReader(stream);
			buffer = new BufferedReader(reader);
			
			while(!"/Sair".equals(msg)) {
				
				if(buffer.ready()) {
					msg = buffer.readLine();
					
					
					if(msg.equals("/Sair")) {
						texto.append("Desconectado \n");
					}
					else if (msg.charAt(0) == '£') {
						System.out.println(msg);
						String[] separar = msg.split("Â£");
						System.out.println("separa:"+separar.length);
						try {
							x = Integer.parseInt(separar[1]);
							y = Integer.parseInt(separar[2]);
						} catch (Exception e) {
							// TODO: handle exception
							x = 0;
							y = 0;
						}
						System.out.println("x: "+x+"^ y: "+y);
						Graphics g = desenho.getGraphics(); 
						desenho.paint(g,x,y,4,4,Color.BLACK);

					}
					else {
						texto.append(msg+"\n");
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				enviarMensagem(txtMsg.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnEnviar)) {
			
			try {
				enviarMensagem(txtMsg.getText());
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource().equals(btnSair)) {
			try {
				sair();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	public static Janela getInstance() {
		if (janelinha == null){
			janelinha = new Janela();
			return janelinha;
		}
		else
			return janelinha;
	}
}
