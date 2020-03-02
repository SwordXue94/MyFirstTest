package cn.tjuscs.st;

public class Pocket {
	public boolean moneyDecision(int givenNum) {
		
		if(givenNum > 93) {
			return false;
		}
		if(givenNum >= 50) {
			return moneyDecision(givenNum - 50);
		}
		else if(givenNum > 23 && givenNum <= 43) {
			return moneyDecision(givenNum - 20);
		}
		else if(givenNum > 13 && givenNum <= 23) {
			return moneyDecision(givenNum - 10);
		}
		else if(givenNum > 3 && givenNum <= 13) {
			return moneyDecision(givenNum - 5);
		}
		else if(givenNum >= 0 && givenNum <= 3) {
			return true;
		}
		else return false;
	}

}

