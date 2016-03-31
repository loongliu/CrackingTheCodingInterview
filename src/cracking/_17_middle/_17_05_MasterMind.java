package cracking._17_middle;

import java.util.ArrayList;

public class _17_05_MasterMind {
	
	public static void game(String real, String guess){
		int hit = 0;
		int preHit = 0;
		ArrayList<Character> realList = new ArrayList<>();
		ArrayList<Character> guessList = new ArrayList<>();
		for(int i = 0; i<real.length() && i<guess.length();i++){
			if(real.charAt(i) == guess.charAt(i)){
				hit++;
			}else{
				realList.add(real.charAt(i));
				guessList.add(guess.charAt(i));
			}
		}
		for(Character c : realList){
			if(guessList.contains(c)){
				preHit++;
				guessList.remove(c);
			}
		}
		System.out.println("hit:" + hit + ", preHit:" + preHit);
	}

	public static void main(String[] args) {
		game("RGBY","GGRR");
	}

}
