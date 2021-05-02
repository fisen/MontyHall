package monty.hall.player;

public interface PlayerInterface {

	String getPrettyName();

	boolean wantsToChangeBox();

	int getBox();

	void chooseNewBox();
}
