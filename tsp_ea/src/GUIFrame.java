import java.awt.FlowLayout;

import javax.swing.*;


public class GUIFrame extends JFrame{
	
	static int windowSizeX = 600;
	static int windowSizeY = 400;
	

	public GUIFrame(JPanel t) {
		this.setTitle("tsp_ea");
		this.setSize(windowSizeX, windowSizeY);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(t);

	}
	
	public static int getWindowSizeX() {
		return windowSizeX;
	}


	public static int getWindowSizeY() {
		return windowSizeY;
	}

}
