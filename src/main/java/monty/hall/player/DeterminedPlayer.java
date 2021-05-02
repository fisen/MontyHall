package monty.hall.player;

public class DeterminedPlayer extends Player{

	public  boolean wantsToChangeBox() {
		return false;
	}

	@Override
	public String getPrettyName() {
		return "Determined player";
	}
}
