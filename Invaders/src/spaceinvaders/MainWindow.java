package spaceinvaders;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	
	public MainWindow() {
		add(new Board());
		setTitle("Space Invaders");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(640,480);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		new MainWindow();
	}

}
