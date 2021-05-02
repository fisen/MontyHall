package monty.hall.host;

import monty.hall.lib.Randomer;


public class Host {
	private int correct_box;

	public boolean isCorrectAnswer(int answer) {
		return correct_box == answer;
	}

	public int getPlayersNewBoxAfterDecision(boolean decision, int playersBox) {
		if (!decision) {
			return playersBox;
		}
		if (playersBox == correct_box) {
			return getRandomlyEmptyBox();
		}
		return correct_box;
	}

	private int getRandomlyEmptyBox() {
		int random = Randomer.randomNumberBetween1and3();
		while (random == correct_box) {
			random = Randomer.randomNumberBetween1and3();
		}
		return random;
	}

	public void chooseNewBox() {
		this.correct_box = Randomer.randomNumberBetween1and3();
	}

}