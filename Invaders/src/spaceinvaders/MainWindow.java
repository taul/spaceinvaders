package spaceinvaders;

import java.awt.Image;

import javax.swing.JFrame;

public class MainWindow extends JFrame implements Runnable {

	public static int WIDTH = 640;
	public static int HEIGHT = 480;

	private Player player;
	private AlienFleet fleet;
	private Image alienShipImage;
	private Image playerShipImage;
	private int gameSpeed = 100; // Update the screen every 100ms.
	private int score = 0;
	private boolean paused = false;

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
		player = new Player(playerShipImage, this);
		fleet = new AlienFleet(alienShipImage);
		startGame();
	}

	public void startGame() {
		Thread thread = new Thread(this);
		thread.start();
	}

	public void pauseGame(boolean b) {
		paused = b;
	}

	public void increaseScore() {
		score += 1;
		System.out.println("Current Score = " + score);
	}

	// Lose score if we get killed.
	public void decreaseScore() {
		score -= 4;
		System.out.println("Current Score = " + score);
	}

	public AlienFleet getAlienFleet() {
		return fleet;
	}

	public void run() {
		int count = 0;
		while (true) {
			try {
				Thread.sleep(gameSpeed);
			} catch (InterruptedException ie) {
				// Meh.
			}
			// when the game is running, move the aliens every 5*100ms.
			if (!paused) {
				if (count >= 5) {
					fleet.moveFleet();
					count = 0;
				}
			}
			repaint();// call draw in every class.
			count++;

		}
	}

}
