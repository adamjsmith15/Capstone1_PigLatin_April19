// Adam Smith Capstone 1 April 2019
import java.util.Scanner;

public class PigLatin {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Welcome to the Pig Latin Translator");
		addSpacing();
		String keepPlaying = "y";
		
		while(keepPlaying.equalsIgnoreCase("y")) {
			String userWord = "";
			while (userWord.trim().isEmpty()) {
				System.out.print("Please enter a word to be translated: ");
				userWord = scnr.nextLine();
			}
			addSpacing();
			System.out.println(convertSentenceToWords(userWord));
			addSpacing();
			System.out.println("Translate another line? (y/n)");
			keepPlaying = scnr.next();
		}
		System.out.println("Goodbye");
		scnr.close();
	}
	public static String convertStringToPigLatin(String word) {
		word = word.toLowerCase();
		if(isVowel(word.charAt(0)) && !(containsANumber(word)) && !(containsASymbol(word))) {
			return word.concat("way");
		}else if (containsANumber(word) || containsASymbol(word)){
			return word;
		}else if(indexOfVowel(word) == -1) {
			return word + "ay";
		}else {
			String newEndOfWord = word.substring(0, indexOfVowel(word));
			String tempWord = word.substring(indexOfVowel(word));
			return tempWord + newEndOfWord + "ay";
		}
		
	}
	public static boolean isVowel(char c){
		final String VOWELS = "aeiou";
		return VOWELS.indexOf(Character.toLowerCase(c)) >= 0;
		
	}
	public static int indexOfVowel(String word) {
		final String VOWELS = "aeiou";
		for(int i = 0; i < word.length(); i++) {
			if(VOWELS.contains(String.valueOf(word.charAt(i)))){
				return i;
			}
			
		}
		return -1;
		
	}
	public static boolean containsANumber(String word) {
		final String NUMBERS = "1234567890";
		for(int i = 0; i < word.length(); i++) {
			if(NUMBERS.contains(String.valueOf(word.charAt(i)))) {
				return true;
			}
		}
		return false;
	}
	public static boolean containsASymbol(String word) {
		final String SYMBOLS = "!@#$%^&*()_+-=`~{}[];:',.<>/?";
		for(int i = 0; i < word.length(); i++) {
			if(SYMBOLS.contains(String.valueOf(word.charAt(i)))) {
				return true;
			}
		}
		return false;
	}
	public static String convertSentenceToWords(String word) {
		String wordArr [] = word.split(" ");
		String sentence = "";
		for(int i = 0; i < wordArr.length; i++) {
			sentence += convertStringToPigLatin(wordArr[i]) + " ";
			
		}
		return sentence;
	}
	public static void addSpacing() {
		System.out.println("");
	}

}
