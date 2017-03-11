import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIElements extends JPanel implements ActionListener {

	int velX = 1;
	public int x1 = 100;
	public int y1 = 10;
	public int x2 = 10;
	public int y2 = 10;

	private ArrayList<City> citiesToPaint = new ArrayList<City>();

	Timer tm = new Timer(5, this); // 10ms updaterate = 100fps

	JLabel jl;
	JButton jb;
	JPanel jp = new JPanel();

	public void paintTour(ArrayList<City> citiesToPaint, Graphics g) {
		int firstCityX = 0;
		int firstCityY = 0;
		
		int secoundCityX = 0;
		int secoundCityY = 0;
		
		int width = 8;
		int height = 8;
		for (int i = 0; i < citiesToPaint.size(); i++) { //get all city positions paint them and connect with lines
			firstCityX = citiesToPaint.get(i).getX() ;
			firstCityY = citiesToPaint.get(i).getY();
			g.fillOval(firstCityX - (int)(height / 2), firstCityY - (int)(height / 2), width, height); //adujt for city dot size so that lines are centered
			
			if (i >0) {
				secoundCityX = citiesToPaint.get(i - 1).getX();
				secoundCityY = citiesToPaint.get(i - 1).getY();
				g.drawLine(firstCityX, firstCityY,secoundCityX, secoundCityY);
			}

		}
		// g.fillOval(x1*2, y1, x2, y2);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // needed for compatibility
		g.setColor(Color.blue);

		// g.drawRect(x1, y1, x2, y2);
		// g.fillRect(x1*2, y1*2, x2*2, y2*2);
		/*
		 * g.fillOval(x1, y1, x2, y2); g.setColor(Color.red); g.fillOval(x1*2,
		 * y1, x2, y2); g.fillOval(x1, y1*2, x2, y2); g.setColor(Color.blue);
		 * g.fillOval(x1*2, y1*2, x2, y2);
		 * 
		 * g.drawLine(x1*5, y1*5, x2*2, y2*2);
		 */
		paintTour(citiesToPaint, g);

		tm.start();
	}

	public void actionPerformed(ActionEvent e) {
		// if(x1 < (GUIFrame.getWindowSizeX() - x1*3) && x1 > 0){
		// x1 = x1 + velX;
		// }
		repaint();
	}

	public ArrayList<City> getCitiesToPaint() {
		return citiesToPaint;
	}

	public void setCitiesToPaint(ArrayList<City> citiesToPaint) {
		this.citiesToPaint = citiesToPaint;
	}

}
