package pacote;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.JPanel;

public class Desenho extends JPanel implements MouseMotionListener{
	int x=0,y=0;
	
	public Desenho() {
		super();
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		
		addMouseMotionListener(this);
	}

	public void paint(Graphics g,int x0,int y0,int x1,int y1, Color cor) {
		g.setColor(cor);
		g.fillRect(x0, y0, x1, y1);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x = (int) e.getX();
		y = (int) e.getY();
		
		Graphics g = getGraphics();
		paint(g,x,y,4,4,Color.black);
		
		String posicao = "£"+x+"£"+y;
		try {
			Janela.getInstance().enviarMensagem(posicao);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
