import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		Dictionary d = Dictionary.buildDictionary("location	/Volumes/KINGSTON/Java 2016/CipherBlankTemplate/words.txt");
		String plainText = "Nima's pants are on fire!!!?!!";
		String cipherText = Cipher.rotationCipherEncrypt(plainText, 3);
	
		System.out.println("Plaintext: " + plainText);
		System.out.println("Cipertext: " + cipherText);
		System.out.println(d.isWord("you"));
		
//		System.out.println(Cipher.wordCount("bruh it works"));
//		System.out.println(Arrays.toString(Cipher.getWords("a b c d e f g h")));
		
		

	}

}