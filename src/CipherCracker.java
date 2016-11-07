
public class CipherCracker {
	public static void main(String[] args){
		
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

}
