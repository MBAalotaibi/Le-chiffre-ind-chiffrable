/**
 * A class that declares methods as described in Assignment doc.
 *
 * @author Mo
 */
 public abstract class Substitution implements Cipher {

	private String KEY = "]kYV}(!7P$n5_0i R:?jOWtF/=-pe'AD&@r6%ZXs\"v*N"
			+ "[#wSl9zq2^+g;LoB`aGh{3.HIu4fbK)mU8|dMET><,Qc\\C1yxJ";

	// abstract function encrypt
	public abstract char encrypt(char character);

	// abstract function decrypt
	public abstract char decrypt(char character);

	// Encrypt method for substitution cipher
	public String encrypt(String plain_text) {
		StringBuilder string_builder = new StringBuilder(plain_text.length());

		for (char c : plain_text.toCharArray())
			string_builder.append(KEY.charAt((int) c - 32));

		return string_builder.toString();
	}

	// Decryption method for substitution cipher
	public String decrypt(String Crypto_text) {
		StringBuilder string_builder = new StringBuilder(Crypto_text.length());

		for (char ch : Crypto_text.toCharArray())
			string_builder.append((char) (KEY.indexOf((int) ch) + 32));

		return string_builder.toString();
	}
}
