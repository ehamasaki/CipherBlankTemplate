public class Cipher {
	
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,.() '\"![]/%-_;?-=:"
			+ '\n' + '\r';
	private static final String SIMPLE_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	// Set this variable to the default alphabet you wish to use
	private static final String DEFAULT_ALPHABET = ALPHABET;

	private static Dictionary dictionary = Dictionary.buildDictionary("location	/Volumes/KINGSTON/Java 2016/CipherBlankTemplate/words.txt");

	
	public static String vigenereCipherEncrypt(String plain, String password, String alphabet) {
	String encryptCode = "";
	int[] codeArr = new int[password.length()];
	int codeIndex = 0;
	for (int i = 0; i < codeArr.length; i++) {
		codeArr[i] = alphabet.indexOf(password.substring(i, i + 1));
	}
	for (int i = 0; i < plain.length(); i++) {
		if (codeIndex == password.length() - 1) {
			codeIndex = 0;
		}
		encryptCode += rotationCipherEncrypt(plain.substring(i, i + 1), codeArr[codeIndex], alphabet);
		codeIndex++;
	}
	return encryptCode;
}

public static String vigenereCipherDecrypt(String cipher, String password, String alphabet) {
	String encryptCode = "";
	int[] codeArr = new int[password.length()];
	int codeIndex = 0;
	for (int i = 0; i < codeArr.length; i++) {
		codeArr[i] = (alphabet.indexOf(password.substring(i, i + 1))) * (-1);
	}
	for (int i = 0; i < cipher.length(); i++) {
		if (codeIndex == password.length() - 1) {
			codeIndex = 0;
		}
		encryptCode += rotationCipherEncrypt(cipher.substring(i, i + 1), codeArr[codeIndex], alphabet);
		codeIndex++;
	}
	return encryptCode;
}

public static String rotationCipherEncrypt(String plain, int shift, String alphabet) {
	String letter = "";
	String cipher = "";
	for (int i = 0; i < plain.length(); i++) {
		int index = 0;
		letter = plain.substring(i, i + 1);
		index = alphabet.indexOf(letter) + shift;
		index = shiftIndex(index, alphabet.length(), plain.length());
		cipher = cipher + alphabet.substring(index, index + 1);

	}
	return cipher;
}


public static String rotationCipherDecrypt(String cipher, int shift, String alphabet) {
	String letter = "";
	String decode = "";
	for (int i = 0; i < cipher.length(); i++) {
		int index = 0;
		letter = cipher.substring(i, i + 1);
		index = alphabet.indexOf(letter) - shift;
		index = shiftIndex(index, alphabet.length(), cipher.length());
		decode = decode + alphabet.substring(index, index + 1);

	}
	return decode;
}

public static String rotationCipherCrack(String cipherText, String alphabet){
	
	Dictionary dictionary = Dictionary.buildDictionary("/Volumes/KINGSTON/Java 2016/CipherBlankTemplate/words.txt");
	
	String[] cipherTextArr = Cipher.getWords(cipherText);
	for (int i = 0; i < 100000; i++){
		Cipher.rotationCipherEncrypt(cipherText, i);
			if (Cipher.isEnglish(cipherText) == true) return cipherText;		
	}
	
return "";
}

private static String vigenereCipherCrackThreeLetter(String cipher, String alphabet) {
	 
	String password = "";
	String alphabet = "abcdefghijklmnopqrstuvwxyz";

	for (int a = 0; a <  cipher.length(); a += 3) {
		String letter1 = cipher.substring(a, a + 1);

		LetterBag bag1 = new LetterBag();
		bag1.add(letter1);

		String mostFrequent1 = bag1.getMostFrequent();
		
			int mostFreqIndex = alphabet.indexOf(mostFrequent1);
			
			int spaceIndex = alphabet.indexOf(" ");

		int shiftAmount = Math.abs((mostFreqIndex - spaceIndex));
			password += alphabet.substring(shiftAmount, shiftAmount + 1);
	}

	for (int b = 1; b <  cipher.length(); b += 3) {
		String letter2 = cipher.substring(b, b + 1);

		LetterBag bag2 = new LetterBag();
		bag2.add(letter2);

		String mostFrequent2 = bag2.getMostFrequent();
		
			int mostFreqIndex = alphabet.indexOf(mostFrequent2);
			
			int spaceIndex = alphabet.indexOf(" ");
			
		int shiftAmount = Math.abs((mostFreqIndex - spaceIndex));
			password += alphabet.substring(shiftAmount, shiftAmount + 1);
	}

	for (int c = 2; c <  cipher.length(); c += 3) {
		String letter3 = cipher.substring(c, c + 1);

		LetterBag bag3 = new LetterBag();
		bag3.add(letter3);

		String mostFrequent3 = bag3.getMostFrequent();
		
			int mostFreqIndex = alphabet.indexOf(mostFrequent3);
			
			int spaceIndex = alphabet.indexOf(" ");

		int shiftAmount = Math.abs((mostFreqIndex - spaceIndex));
			password += alphabet.substring(shiftAmount, shiftAmount + 1);
	}

	return password;
}

private static String vigenereCipherCrack(String cipher, int passwordLength, String alphabet) {
	 
	String password = "";
	String alphabet = "abcdefghijklmnopqrstuvwxyz";

	for (int a = 0; a <  cipher.length(); a += 3) {
		String letter1 = cipher.substring(a, a + 1);

		LetterBag bag1 = new LetterBag();
		bag1.add(letter1);

		String mostFrequent1 = bag1.getMostFrequent();
		
			int mostFreqIndex = alphabet.indexOf(mostFrequent1);
			
			int spaceIndex = alphabet.indexOf(" ");

		int shiftAmount = Math.abs((mostFreqIndex - spaceIndex));
			password += alphabet.substring(shiftAmount, shiftAmount + 1);
	}

	for (int b = 1; b <  cipher.length(); b += 3) {
		String letter2 = cipher.substring(b, b + 1);

		LetterBag bag2 = new LetterBag();
		bag2.add(letter2);

		String mostFrequent2 = bag2.getMostFrequent();
		
			int mostFreqIndex = alphabet.indexOf(mostFrequent2);
			
			int spaceIndex = alphabet.indexOf(" ");
			
		int shiftAmount = Math.abs((mostFreqIndex - spaceIndex));
			password += alphabet.substring(shiftAmount, shiftAmount + 1);
	}

	for (int c = 2; c <  cipher.length(); c += 3) {
		String letter3 = cipher.substring(c, c + 1);

		LetterBag bag3 = new LetterBag();
		bag3.add(letter3);

		String mostFrequent3 = bag3.getMostFrequent();
		
			int mostFreqIndex = alphabet.indexOf(mostFrequent3);
			
			int spaceIndex = alphabet.indexOf(" ");

		int shiftAmount = Math.abs((mostFreqIndex - spaceIndex));
			password += alphabet.substring(shiftAmount, shiftAmount + 1);
	}

	return password;
}

private static String vigenereCipherCrack(String cipher, String alphabet) {
	 
	String password = "";
	String alphabet = "abcdefghijklmnopqrstuvwxyz";

	for (int a = 0; a <  cipher.length(); a += 3) {
		String letter1 = cipher.substring(a, a + 1);

		LetterBag bag1 = new LetterBag();
		bag1.add(letter1);

		String mostFrequent1 = bag1.getMostFrequent();
		
			int mostFreqIndex = alphabet.indexOf(mostFrequent1);
			
			int spaceIndex = alphabet.indexOf(" ");

		int shiftAmount = Math.abs((mostFreqIndex - spaceIndex));
			password += alphabet.substring(shiftAmount, shiftAmount + 1);
	}

	for (int b = 1; b <  cipher.length(); b += 3) {
		String letter2 = cipher.substring(b, b + 1);

		LetterBag bag2 = new LetterBag();
		bag2.add(letter2);

		String mostFrequent2 = bag2.getMostFrequent();
		
			int mostFreqIndex = alphabet.indexOf(mostFrequent2);
			
			int spaceIndex = alphabet.indexOf(" ");
			
		int shiftAmount = Math.abs((mostFreqIndex - spaceIndex));
			password += alphabet.substring(shiftAmount, shiftAmount + 1);
	}

	for (int c = 2; c <  cipher.length(); c += 3) {
		String letter3 = cipher.substring(c, c + 1);

		LetterBag bag3 = new LetterBag();
		bag3.add(letter3);

		String mostFrequent3 = bag3.getMostFrequent();
		
			int mostFreqIndex = alphabet.indexOf(mostFrequent3);
			
			int spaceIndex = alphabet.indexOf(" ");

		int shiftAmount = Math.abs((mostFreqIndex - spaceIndex));
			password += alphabet.substring(shiftAmount, shiftAmount + 1);
	}

	return password;
}

}