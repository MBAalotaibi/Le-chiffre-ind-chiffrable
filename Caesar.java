/**
 * A class that declares methods as described in Assignment doc.
 *
 * @author Mo
 */
public class Caesar extends MonoAlphaSubstitution {

	private int shift;

	public Caesar(int key) {
		super();
		shift = key;
	}

	public Caesar() {
		super();
		shift = 0;
	}

	public String encrypt(String text) {

		String Text = "";
		char charater;
		for (int i = 0; i < text.length(); i++) {
			charater = text.charAt(i);
			Text += encrypt(charater);
		}

		return Text;
	}

	public String decrypt(String text) {
		String Message = "";
		for (int i = 0; i < text.length(); i++) {
			char alphabet = text.charAt(i);
			Message += decrypt(alphabet);

		}
		return Message;
	}

	public static void main(String args[]) {
		if (args.length == 3) {
			String type = args[0];
			String Key = args[1].toLowerCase();
			String TEXT = args[2].substring(0, args[2].length());

			Caesar caesar_object = new Caesar(Integer.parseInt(Key));

			if ("encrypt".compareTo(type) == 0) {
				String encrypt_text = caesar_object.encrypt(TEXT);
				System.out.println(encrypt_text);
			} else if ("decrypt".equals(type) ) {
				String decrypt_text = caesar_object.encrypt(TEXT);
				System.out.println(decrypt_text);
			} else {
				System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\r\n"
						+ "Usage: java Caesar encrypt key \"cipher text\"");
			}
		} else if (args.length < 3) {
			System.out.println("Too few parameters!\nUsage: java Caesar encrypt n \"cipher text\"");
		} else {
			System.out.println("Too many parameters!\nUsage: java Caesar encrypt n \"cipher text\"");
		}

	}

	public char encrypt(char charater) {

		if (charater >= 'a' && charater <= 'z') {

			charater = (char) (charater + shift);
			if (charater > 'z') {
				charater = (char) (charater + 'a' - 'z' - 1);
			}

		}

		else if (charater >= 'A' && charater <= 'Z') {

			charater = (char) (charater + shift);

			if (charater > 'Z') {
				charater = (char) (charater + 'A' - 'Z' - 1);
			}

		}

		return charater;

	}

	public char decrypt(char character) {
		if (character >= 'a' && character <= 'z') {

			character = (char) (character - shift);

			if (character < 'a') {
				character = (char) (character - 'a' + 'z' + 1);
			}

		} else if (character >= 'A' && character <= 'Z') {

			character = (char) (character - shift);

			if (character < 'A') {
				character = (char) (character - 'A' + 'Z' + 1);
			}

		}
		return character;

	}

}
