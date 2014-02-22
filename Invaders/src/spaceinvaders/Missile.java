package spaceinvaders;

import java.awt.*;

import javax.swing.ImageIcon;

/**
 *
 */
public class Missile implements Runnable {

	private int WIDTH = 5;
	private int HEIGHT = 10;

	private int xPosition = 0;
	private int yPosition = 0;

	private int missileSpeed = 10; // how long, in milliseconds, between moving 2 pixels. is this a
								// good way to do it?
	boolean missileExists = true;

	AlienFleet fleet;
	private Image missileImage;
	private MainWindow mw;
	public Missile(int x, int y, AlienFleet fleet, MainWindow mw) {
		xPosition = x;// Set the shot direction
		yPosition = y;
		this.fleet = fleet;
		this.mw = mw;
		missileImage = new ImageIcon(this.getClass().getResource("bomb.png")).getImage();
		Thread thread = new Thread(this);
		thread.start();
	}

	private boolean move() {

		// check if we hit anything.
		if (fleet.checkShot(xPosition, yPosition)) {
			// We killed an alien!
			System.out.println("We killed an alien ship!");
			missileExists = false;
			return true;
		}

		yPosition -= 2; // is 2 pixels too little?

		// check if it's gone of screen
		if (yPosition < 0) {
			missileExists = false;
			return true;
		}

		return false;
	}

	public void drawMissile(Graphics g) {
		if (missileExists) {
			g.drawImage(missileImage, xPosition, yPosition, mw);
		} else {

		}

	}

	public boolean missileExists() {
		return missileExists;
	}

	// The wonderful thread run method that makes the missile move
	public void run() {
		while (true) {
			try {
				Thread.sleep(missileSpeed);
			} catch (InterruptedException ie) {
				// damn exceptions, stop trying to interrupt me.
			}

			if (move()) {
				break;
			}
		}
	}

}