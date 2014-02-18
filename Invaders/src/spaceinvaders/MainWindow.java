package spaceinvaders;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	public static int WIDTH = 640;
	public static int HEIGHT = 480;

	public static void main(String[] args) {
		new MainWindow();
	}

	public MainWindow() {
		add(new Board());
		setTitle("Space Invaders");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

}
