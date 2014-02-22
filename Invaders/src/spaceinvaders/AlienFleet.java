package spaceinvaders;

import java.awt.*;

public class AlienFleet {

	// Three rows and 10 columns of ships
	public static int nbrOfColumns = 10;
	public static int nbrOfRows = 6;
	
	AlienShip alienMatrix[][] = new AlienShip[nbrOfColumns][nbrOfRows];

	// direction of the aliens
	boolean movingRight = true;

	Image shipImage;
	
	//int moveDistance = AlienShip.WIDTH;
	int moveDistance = 5;
	int deadInColumn[] = new int[nbrOfColumns];
	
	private MainWindow mw;
	public AlienFleet(Image shipImage, MainWindow mw) {
		this.shipImage = shipImage;
		this.mw = mw;
		buildFleet();
		setStartingPositions();
	}

	// Initialize the fleet with the chosen shiptype!
	private void buildFleet() {
		for (int i = 0; i < nbrOfColumns; i++) {
			for (int j = 0; j < nbrOfRows; j++) {
				alienMatrix[i][j] = new AlienShip(shipImage, mw);
			}
		}
	}

	private void setStartingPositions() {
		// All of the integers below should probably be static and based on
		// something instead of taken from thin air.
		int rowHeight = AlienShip.WIDTH;// Height of the top row
		int leftStart = AlienShip.WIDTH;// Position of the alien the farthest to the left
		for (int i = 0; i < nbrOfColumns; i++) {
			for (int j = 0; j < nbrOfRows; j++) {
				alienMatrix[i][j].setPosition(leftStart, rowHeight);
				rowHeight += AlienShip.WIDTH;
			}
			leftStart += AlienShip.WIDTH;// Next row
			rowHeight = AlienShip.WIDTH;
		}
	}

	public void moveFleet() {
		// something something. set new positions. probably will be quite a bit
		// of messy code here
		if (movingRight) {
			for(int i = (nbrOfColumns-1); i >=0; i--){
				if(deadInColumn[i] < nbrOfRows){ //if anyone is alive in the column
					if (alienMatrix[i][0].getXPos() > (MainWindow.WIDTH-AlienShip.WIDTH-AlienShip.WIDTH)){ //If there's no space to move to the right
						System.out.println("this happend, mw wid-shipwid = " + (MainWindow.WIDTH-AlienShip.WIDTH) + " and XPos = " + alienMatrix[i][0].getXPos());
						movingRight = false;
						moveFleetOneStepDown();
						return; //Don't want to check the rest of them
					}
					else{
						moveFleetOneStep();
					}
				}
			}
		} else{ //Moving left
			System.out.println("movin' left");
			for(int i = 0; i < nbrOfColumns; i++){
				if(deadInColumn[i] < nbrOfRows){
					if (alienMatrix[i][0].getXPos() < AlienShip.WIDTH){
						movingRight = true;
						moveFleetOneStepDown();
						return;
					}
					else{
						moveFleetOneStep();
					}
				}
			}
		}
		
		
		// Maybe add the aliens firing random missiles?
		
	}
    public void moveFleetOneStepDown(){
		for (int i = 0; i < nbrOfColumns; i++) {
			for(int j = 0; j < nbrOfRows; j++){
				alienMatrix[i][j].setPosition(alienMatrix[i][j].getXPos(), alienMatrix[i][j].getYPos()+moveDistance);
				//Check if a living alien ship has reached the bottom of the screen (alienship.yPosition >= mw.HEIGHT)
				if(alienMatrix[i][j].isAlive() && alienMatrix[i][j].getYPos() >= MainWindow.HEIGHT){
					System.out.println("Game lost =(");
				}
			}
        }
	}
    
    public void moveFleetOneStep(){
    	if(movingRight){
    		for (int i = 0; i < nbrOfColumns; i++) {
    			for(int j = 0; j < nbrOfRows; j++){
    				alienMatrix[i][j].setPosition(alienMatrix[i][j].getXPos()+moveDistance, alienMatrix[i][j].getYPos());
    			}
            }
    	}else{
    		for (int i = 0; i < nbrOfColumns; i++) {
    			for(int j = 0; j < nbrOfRows; j++){
    				alienMatrix[i][j].setPosition(alienMatrix[i][j].getXPos()-moveDistance, alienMatrix[i][j].getYPos());
    			}
            }
    	}
    }

	public void drawFleet(Graphics g) {
		for (int i = 0; i < nbrOfColumns; i++) {
			for (int j = 0; j < nbrOfRows; j++) {
				alienMatrix[i][j].drawAlien(g);
			}
		}
		// Here we probably also will want to draw any of those missiles the
		// aliens fired.

	}

	// Collision detection, the fun part of game development! check if the shot
	// the player fired hit any evil alien ship.
	public boolean checkShot(int x, int y) {
		for (int i = 0; i < nbrOfColumns; i++) {
			for (int j = 0; j < nbrOfRows; j++) {
				if (alienMatrix[i][j].hitAlien(x, y)) {
					deadInColumn[i]++;
					// Add to the some score counter here.
					return true;
				}
			}
		}
		return false;
	}
	

    
    

}
