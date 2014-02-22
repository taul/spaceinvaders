package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame implements Runnable {

	public static int WIDTH = 640;
	public static int HEIGHT = 480;

	private Player player;
	private AlienFleet fleet;
	private Image alienShipImage;
	private Image playerShipImage;
	private Image bg;
	private int gameSpeed = 100; // Update the screen every 100ms.
	private int score = 0;
	private boolean paused = false;
	private Graphics screen;
    private BufferedImage bufImg;
    
	public static void main(String[] args) {
		new MainWindow();
	}

	public MainWindow() {
		super("Space Invaders");

		bg = new ImageIcon(this.getClass().getResource("background.png")).getImage();
		alienShipImage = new ImageIcon(this.getClass().getResource("invaders.png")).getImage();
		playerShipImage = new ImageIcon(this.getClass().getResource("player.png")).getImage();
		
		player = new Player(playerShipImage, this);
		fleet = new AlienFleet(alienShipImage, this);
		
		bufImg = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		screen = bufImg.createGraphics();
		
		addMouseListener(player);
		addMouseMotionListener(player);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
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
	

    public void paint(Graphics g) {
    	screen.setColor(Color.BLACK);
    	screen.fillRect(0, 0, WIDTH, HEIGHT);
    	screen.drawImage(bg,0,0,this);
    	fleet.drawFleet(screen);
        player.drawShip(screen);
        g.drawImage(bufImg,0,0,this);
    }
    public void update(Graphics g) {
        paint(g);
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
