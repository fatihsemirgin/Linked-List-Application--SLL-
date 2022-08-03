import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	private static int count = 0;	///  For the number of elements (rows) in the file.(Size of sll1)
	public static void reading(String file_name, SingleLinkedList sll) throws IOException {	  /// To add the data from the file to the list.																						
		File dosya = new File(file_name);
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(dosya), "UTF8"));
			String satir;
			while ((satir = inputStream.readLine()) != null) {
				count++;
				satir = satir.trim();
				satir = satir.toUpperCase(Locale.ENGLISH);
				sll.add(satir);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
	public static void readingHighScore(String file_name, SingleLinkedList sll) throws IOException {  /// To add the data from the high score file to the list.  	 																																																		/// file
		int count = 0;
		String name = "";
		File dosya = new File(file_name);
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(dosya), "UTF8"));
			String satir;
			while ((satir = inputStream.readLine()) != null) {
				count++;
				//satir=satir.toUpperCase(Locale.ENGLISH);
				if (count % 2 == 0) {
					sll.addtext(name, satir);
				}
				name = satir;
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
	public static void alignment(String element, String data) {		/// For screen alignments.
		if (data.equalsIgnoreCase("Step : ")) {
			System.out.print(String.format("%" + (47 - (Integer.parseInt(element) * 2 + Integer.parseInt(element)) + 3) + "s", data));																													// yapabilirsin
		} else {
			if (element.length() > 1)
				System.out.print(String.format("%" + (15 - (element.length() - 1)) + "s", data));
			else
				System.out.print(String.format("%" + 15 + "s", data));
		}
	}
	public static void main(String[] args) throws IOException {
		int number = 1;			/// Counter for player name. 
		boolean game_flag=true;	/// To finish the game.
		while (true) {
			System.out.print("\n"+String.format("%" + 65 + "s", "******* WHEEL OF FORTUNE *******\n"));
			count = 0;
			SingleLinkedList sll1 = new SingleLinkedList();
			SingleLinkedList sll2 = new SingleLinkedList();
			SingleLinkedList sll3 = new SingleLinkedList();
			SingleLinkedList sll4 = new SingleLinkedList();
			SingleLinkedList sll5 = new SingleLinkedList();
			SingleLinkedList sll_wheel = new SingleLinkedList();
			int score = 0,size=0;								/// size --> For the feedback from method sameNumberCount.   score --> Game score
			String wheel="",guess = "";							/// wheel is random data from the wheel.  guess is random letter from the sll2.
			String player = "You";							 
			boolean flag2=true,flag_bankrupt = true;			/// flag2 --> to not write the warning text. flag_bankrupt --> for bankruptcy. 
			int x = 1,count2=0;									/// x for the step, count2 for size of sll2
			reading("D://animals.txt", sll1);		
			for (int i = 65; i <= 90; i++) {
				sll2.add(Character.toString((char) i));
				count2++;
			}
			int rnd_sll1 = (int) ((Math.random() * count) + 1);	/// For random position in the sll1 list.
			String word = sll1.searching(rnd_sll1);
			for (int a = 0; a < word.length(); a++) {
				sll4.add2(word.substring(a, a + 1));			/// The letters of the randomly selected word are added to the list.
				sll5.add2("_");									/// The same number of additions is made to the closed list.
			}
			sll_wheel.add2("10");sll_wheel.add2("20");sll_wheel.add2("30");sll_wheel.add2("40");sll_wheel.add2("100");sll_wheel.add2("200");sll_wheel.add2("300");
			sll_wheel.add2("400");sll_wheel.add2("Bankrupt");sll_wheel.add2("Bankrupt");
			System.out.println("\n\n-----------------------------------------------");
			player = player + number;	/// To change the player name in case of replay.
			
			while (true) {
				String rcv = sll5.combination();						/// Merge letters
				int rnd_wheel = (int) ((Math.random() * 10) + 1);		/// For random position in the wheel list.
				int rnd_sll2 = (int) ((Math.random() * count2) + 1);	/// For random position in the sll2 list.
				wheel = sll_wheel.searching(rnd_wheel);
				//flag = true;
				if (wheel.equalsIgnoreCase("Bankrupt"))
					flag_bankrupt = false;
				System.out.print("WORD  : ");
				sll5.printList();
				if (rcv.equalsIgnoreCase(word)) {	///  For the game to be over if the word formed when the letters are combined and the guessed word are the same.
					alignment(Integer.toString(sll4.size()), "Step : ");
					System.out.print(x);
					alignment(Integer.toString(x), "Score : ");
					System.out.print(score);
					if (flag2) {		/// To not write the warning text.
						alignment(Integer.toString(score), "SLL2 : ");
						sll2.printList();
						System.out.println("\n\n"+player+" GET " + score + " TL !!!");
					} else {
						alignment(Integer.toString(score), "SLL2 : ");
						System.out.println("\n\n"+player+" GET " + score + " TL !!!");
					}
					break;
				}
				alignment(Integer.toString(sll4.size()), "Step : ");
				System.out.print(x);
				alignment(Integer.toString(x), "Score : ");
				System.out.print(score);
				if (flag2) {
					alignment(Integer.toString(score), "SLL2 : ");
					sll2.printList();
				}
				guess = sll2.searching(rnd_sll2);		/// For random letter in the sll2 list.
				System.out.print("\n\nWHEEL : " + wheel);
				if (flag_bankrupt) {					///
					System.out.print("\n\nGUESS : " + guess);
				}
				if (flag_bankrupt) {		///  If there is no bankruptcy, the letter is deleted.
					if (sll2.size() == 1)
						flag2 = false;
					sll2.delete(guess, null);
					count2--;
					//flag = true;
					size = sll4.sameNumberCount(guess);
					for (int j = 0; j < size; j++) {	/// where there is more than one of the same letter in the word.
						int sch2 = sll4.searching2(guess);
						if (sch2 != -1) {				/// -1 means there are no predictive letters in the word.
							sll5.add3(sch2, guess);		///	The guessed letter is added to the closed word (the letter is also opened in word).
						}
					}
				} else
					System.out.print("\n\nGuess : No forecast was made due to bankruptcy.");
					/// Score Calculations
					if (wheel.equalsIgnoreCase("Bankrupt")) {
						score = 0;
					}
					else
						score += (Integer.parseInt(wheel)) * size;
				x++;
				flag_bankrupt = true;
				System.out.println("\n-----------------------------------------------");
			}
			System.out.println("\n++++++++++++++ HIGH SCORE TABLES ++++++++++++++\n");
			readingHighScore("D://HighScoreTable.txt", sll3);	/// Adding the score table to the list.
			System.out.println("### OLD TOP 10 ###\n");
			sll3.printList();
			sll3.addtext(player, score);	/// To add the end game score and name to the list.
			if (sll3.size() > 10) {
				sll3.deletelast();			/// Deletes the last element(minimum point).
			}
			System.out.println("\n### NEW TOP 10 ###\n");
			sll3.printList();
			sll3.writeToFile("D://HighScoreTable.txt");		/// To write the list of names and scores to the file.
			Scanner scan = new Scanner(System.in);
			System.out.println("\nDo you want to continue for the new game? (Please enter 'Yes' or 'No')");
			while(true) {
				String receive = scan.next();
				if (receive.equalsIgnoreCase("yes")) {
					number++;
					break;
				} else if (receive.equalsIgnoreCase("no")) {
					System.out.println("\n<<<  The game is closed  >>>\n");
					System.out.print(String.format("%" + 55 + "s", "******* WHEEL OF FORTUNE ******\n"));
					game_flag=false;
					break;
				}else {
					System.out.print("!!! Invalid Input !!! ---> Please enter a valid input : ");
					continue;
				}
			}
			if(!game_flag)
				break;
		}
	}

}
