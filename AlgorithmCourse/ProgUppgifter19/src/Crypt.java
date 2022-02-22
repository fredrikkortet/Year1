
public class Crypt
{
	/**
	 * 
	 * @param tkn one character
	 * @param key the key that change the character
	 * @return here is the new character encrypted
	 */
	public static char encrypt_character(char tkn, int key)
	{
		int tokenNumber = ((int) tkn) + key;
		if (122 < tokenNumber) // check if its outside the token
		{
			tokenNumber = tokenNumber - 122;
			tokenNumber = tokenNumber + 47;
		}else if (90 < tokenNumber && tokenNumber < 96)
		{
			tokenNumber = tokenNumber - 90;
			tokenNumber = tokenNumber + 96;
		}else if (57 < tokenNumber && tokenNumber < 64)
		{
			tokenNumber = tokenNumber - 57;
			tokenNumber = tokenNumber + 64;
		}
		return (char) tokenNumber;
	}
/**
 * 
 * @param tkn the encrypted character
 * @param key the key to unlock your power
 * @return here is the decryped character 
 */
	public static char decrypt_character(char tkn, int key)
	{
		int tokenNumber = ((int) tkn) - key;
		if (48 > tokenNumber) // check if its outside the token range
		{
			tokenNumber = 48 - tokenNumber;
			tokenNumber = 123 - tokenNumber;
		}else if (65 > tokenNumber && tokenNumber > 57)
		{
			tokenNumber = 65 - tokenNumber;
			tokenNumber = 58 - tokenNumber;
		}else if (97 > tokenNumber && tokenNumber > 90)
		{
			tokenNumber = 97 - tokenNumber;
			tokenNumber = 91 - tokenNumber;
		}
		return (char) tokenNumber;
	}
}
