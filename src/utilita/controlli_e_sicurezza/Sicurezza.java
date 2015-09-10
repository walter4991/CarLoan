package utilita.controlli_e_sicurezza;

import java.util.Base64;

import javax.crypto.Cipher;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Classe che permette di criptare e decriptare le password del sistema tramite l'algoritmo AES 
 * usato anche da governo degli Stati Uniti d'America.
 * @author Sergio
 *
 */
public class Sicurezza {
	static Cipher cipher;
	/**
	 * Array di byte contenente la chiave per la cifratura e decifratura
	 */
	private final byte[] chiave = { 'c', 'a', 'r', 'l', 'o', 'a', 'n',
			'n', 'c', 'a', 'r', 'l', 'o', 'a', 'n', 'a' };

	private static SecretKey chiaveCifratura;

	/**
	 * Costruisce un istanza della classe sicurezza avvalorando gli attributi per il funzionamento 
	 * dell'algoritmo AES
	 * @throws Exception
	 * 		da gestire
	 */
	public Sicurezza() throws Exception {

		chiaveCifratura = new SecretKeySpec(chiave, "AES");
		cipher = Cipher.getInstance("AES");
	}

	/**
	 * Usa l'aloritmo AES e permette di criptare le password del sistema
	 * @param plainText
	 * 		la stringa da criptare
	 * @return
	 * 		la stringa criptata
	 * @throws Exception
	 * 		da gestire
	 */
	public   String encrypt(String plainText) throws Exception {

		byte[] plainTextByte = plainText.getBytes();

		System.out.println("chiaveCifratura: " + chiaveCifratura.toString());

		cipher.init(Cipher.ENCRYPT_MODE, chiaveCifratura);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encryptedByte);
		return encryptedText;
	}

	/**
	 * Usa l'aloritmo AES e permette di decriptare le password del sistema
	 * @param encryptedText
	 * 		la stringa da decriptare
	 * @return
	 * 		la stringa decriptata
	 * @throws Exception
	 * 		da gestire
	 */
	public   String decrypt(String encryptedText) throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(encryptedText);
		cipher.init(Cipher.DECRYPT_MODE, chiaveCifratura);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		String decryptedText = new String(decryptedByte);
		return decryptedText;
	}
}
