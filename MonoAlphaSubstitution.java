/**
 * A class that declares methods as described in Assignment doc.
 *
 * @author Mo
 */
public class MonoAlphaSubstitution extends Substitution {

	private static char character[];
	private static char character_1[];

	public MonoAlphaSubstitution() {
		super();
		character_1 = new char[26];
		character = new char[26];
		char alpha = 'a';

		for (int i = 0; i < 26; i++) {
			character_1[i] = alpha;
			character[i] = alpha;
			alpha += 1;
		}

	}

	public MonoAlphaSubstitution(String text) {
		super();
		character_1 = new char[26];
		character = new char[26];
		char alpha = 'a';

		for (int i = 0; i < 26; i++) {
			character_1[i] = alpha;
			character[i] = alpha;
			alpha += 1;
		}
		for (int i = 0; i < text.length(); i += 2) {
			int temp = text.charAt(i) - 97;
			if (temp > 25 || temp <0){
				temp = text.charAt(i) - 65;
			}
			character_1[temp] = text.charAt(i + 1);
		}

	}

	@Override
	public String encrypt(String text) {
		String[] Input_text = text.split(" ");
		String Answer = "";
		char c[] = null;
		for (int k = 0; k < Input_text.length; k++) {
			c = new char[Input_text[k].length()];

			for (int i = 0; i < Input_text[k].length(); i++) {

				c[i] = encrypt(Input_text[k].charAt(i));
			}

			for (char alpha : c) {
				Answer += alpha;
			}
			if(k < Input_text.length-1){
				Answer += " ";
			}
		}

		return Answer;
	}

	@Override
	public String decrypt(String text) {
		String[] Input_text = text.split(" ");
		String Answer = "";
		char c[] = null;
		for (int k = 0; k < Input_text.length; k++) {
			c = new char[Input_text[k].length()];

			for (int i = 0; i < Input_text[k].length(); i++) {

				if (decrypt(Input_text[k].charAt(i)) >= 'a' && decrypt(Input_text[k].charAt(i)) <= 'z') {
					c[i] = decrypt(Input_text[k].charAt(i));
				}
				else {
					c[i] = Input_text[k].charAt(i);
				}
			}
			for (char alpha : c) {
				Answer += alpha;
			}
			if(k < Input_text.length-1){
				Answer += " ";
			}
		}
		return Answer;
	}

	@Override
	public char encrypt(char CHAR) {

		char answer = CHAR;
		for (int j = 0; j < 26; j++) {
			if (character[j] == CHAR) {
				answer = character_1[j];
				break;
			}
		}

		return answer;
	}

	@Override
	public char decrypt(char CHAR) {
		char answer = 0;
		for (int j = 0; j < 26; j++) {
			if (character_1[j] == CHAR) {
				answer = character[j];
				break;
			}
		}

		return answer;

	}

	public static void main(String args[]) {

		if (args.length == 3) {
			String type = args[0];
			String KEY = args[1];//.toLowerCase();
			String TEXT = args[2].substring(0, args[2].length());

			MonoAlphaSubstitution obj = new MonoAlphaSubstitution(KEY);

			if ("encrypt".compareTo(type) == 0) {
				String eccrypt_text = obj.encrypt(TEXT);
				System.out.println(eccrypt_text);
			} else if ("decrypt".equals(type) ) {
				String decrypt_text = obj.decrypt(TEXT);
				System.out.println(decrypt_text);
			} else {
				System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\r\n"
						+ "Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
			}
		} else if (args.length < 3) {
			System.out.println("Too few parameters!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
		} else {
			System.out.println("Too many parameters!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
		}

	}

}
