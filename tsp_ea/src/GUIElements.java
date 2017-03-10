import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIElements extends JPanel implements ActionListener {
	
	int velX = 1;
	public int x1 = 100;
	public int y1 = 10;
	public int x2 = 10;
	public int y2 = 10;
	
	
	Timer tm = new Timer(50, this);
	
	JLabel jl;
	JButton jb;
	JPanel jp = new JPanel();
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g); //needed for compatibility
		g.setColor(Color.blue);
		
		//g.drawRect(x1, y1, x2, y2);
		//g.fillRect(x1*2, y1*2, x2*2, y2*2);
		
		g.fillOval(x1, y1, x2, y2);
		g.setColor(Color.red);
		g.fillOval(x1*2, y1, x2, y2);
		g.fillOval(x1, y1*2, x2, y2);
		g.setColor(Color.blue);
		g.fillOval(x1*2, y1*2, x2, y2);
		
		g.drawLine(x1*5, y1*5, x2*2, y2*2);
		
		tm.start();
	}
	
	public void actionPerformed(ActionEvent e){
		if(x1 < (GUIFrame.getWindowSizeX() - x1*3) && x1 > 0){
			x1 = x1 + velX;
		}
		repaint();
	}
	
}
