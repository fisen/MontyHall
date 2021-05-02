package monty.hall.player;

public class UndeterminedPlayer extends Player {

	public boolean wantsToChangeBox() {
		return true;
	}

	@Override
	public String getPrettyName() {
		return "Undetermined player";
	}
}
