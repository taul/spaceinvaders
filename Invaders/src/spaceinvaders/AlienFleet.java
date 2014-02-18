package spaceinvaders;

import java.awt.*;

public class AlienFleet {

	// Three rows and 10 columns of ships
	AlienShip alienMatrix[][] = new AlienShip[3][10];

	// direction of the aliens
	boolean movingRight = true;

	Image shipImage;

	public AlienFleet(Image shipImage) {
		this.shipImage = shipImage;
		buildFleet();
		setStartingPositions();
	}

	// Initialize the fleet with the chosen shiptype!
	private void buildFleet() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				alienMatrix[i][j] = new AlienShip(shipImage);
			}
		}
	}

	private void setStartingPositions() {
		// All of the integers below should probably be static and based on
		// something instead of taken from thin air.
		int rowHeight = 50;// Height of the top row
		int leftStart = 50;// Position of the alien the farthest to the left
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				alienMatrix[i][j].setPosition(leftStart, rowHeight);
				leftStart += 40;
			}
			rowHeight += 50;// Next row
			leftStart = 50;
		}
	}

	public void moveArmy() {
		// something something. set new positions. probably will be quite a bit
		// of messy code here
		if (movingRight) {

		} else {

		}
		// Maybe add the aliens firing their missiles here?
	}

	public void drawArmy(Graphics g) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				alienMatrix[i][j].drawAlien(g);
			}
		}
		// Here we probably also will want to draw any of those missiles the
		// aliens fired.

	}

	// Collision detection, the fun part of game development! check if the shot
	// the player fired hit any evil alien ship.
	public boolean checkShot(int x, int y) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				if (alienMatrix[i][j].hitAlien(x, y)) {
					// Add to the some score counter here.
					return true;
				}
			}
		}
		return false;
	}

}
