/**
 * A class that declares methods as described in Assignment doc.
 *
 * @author Mo
 */

public class Vigenere extends Substitution {

	private String KEY;
	private int newShitKey;

	public Vigenere() {
		super();
		KEY = "";
	}

	public Vigenere(String key) {
		super();
		this.KEY = key;
	}

	@Override
	public String encrypt(String text) {

		String answer = "";
		char message[] = text.toCharArray();
		int message_length = message.length;

		int key_count = 0;
		for (int i = 0; i < message_length; ++i) {

			newShitKey = KEY.charAt(i) - 'A';
			answer += encrypt(message[i]);

			if (key_count >= KEY.length()) {
				key_count = 0;
			}
			key_count += 1;

		}

		return answer;
	}

	@Override
	public String decrypt(String text) {
		String answer = "";
		char Message[] = text.toCharArray();
		int message_length = Message.length;

		int key_count = 0;
		for (int i = 0; i < message_length; ++i) {
			
			if (key_count >= KEY.length()) {
				key_count = 0;
			}
			
			newShitKey = KEY.charAt(i) - 'A';
			answer += decrypt(Message[i]);
			key_count += 1;
			

		}

		return answer;
	}

	public static void main(String args[]) {

		if (args.length == 3) {
			String type = args[0];
			String KEY = args[1];
			String TEXT = args[2].substring(0, args[2].length());

			Vigenere vigenere = new Vigenere(KEY);

			if ("encrypt".compareTo(type) == 0) {
				String encrypt_text = vigenere.encrypt(TEXT);
				System.out.println(encrypt_text);
			} else if ("decrypt".equals(type) ) {
				String decrypt_text = vigenere.decrypt(TEXT);
				System.out.println(decrypt_text);
			} else {
				System.out.println("First parameter must be \"encrypt\" or \"decrypt\"!\r\n"
						+ "Usage: java Vigenere encrypt key \"cipher text\"");
			}
		} else if (args.length < 3) {
			System.out.println("Too few parameters!\nUsage: java Vigenere encrypt key \"cipher text\"");
		} else {
			System.out.println("Too many parameters!\nUsage: java Vigenere encrypt key \"cipher text\"");
		}

	}

	@Override
	public char encrypt(char character) {
		Caesar obj = new Caesar(newShitKey);
		return obj.encrypt(character);

	}

	@Override
	public char decrypt(char character) {
		
		Caesar obj = new Caesar(newShitKey);
		return obj.decrypt(character);

	}

}
