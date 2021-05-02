package monty.hall.player;

import monty.hall.lib.Randomer;

public abstract class Player implements PlayerInterface {

	private int playersBox;

	public int getBox(){
		return this.playersBox;
	}

	public void chooseNewBox(){
		this.playersBox = Randomer.randomNumberBetween1and3();
	}
}
