package ch.grademasters.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @description Klasse um Passwort zu versschluesseln
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin EncryptUtils.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */
public class EncryptUtils {

	//Variablen definieren
	public static final String DEFAULT_ENCODING = "UTF-8";
	static BASE64Encoder enc = new BASE64Encoder();
	static BASE64Decoder dec = new BASE64Decoder();

	/**
	 * @description Passwort wird Codiert
	 * @param text
	 * @return null
	 */
	public static String base64encode(String text) {
		try {
			//Passwort wird codiert
			String rez = enc.encode(text.getBytes(DEFAULT_ENCODING));
			return rez;
		}
		//Exception
		catch (UnsupportedEncodingException e) {
			return null;
		}
	}// base64encode

	/**
	 * @description Passwort wird decodiert
	 * @param text
	 * @return null
	 */
	public static String base64decode(String text) {

		try {
			//Passwort wird decodiert
			return new String(dec.decodeBuffer(text), DEFAULT_ENCODING);
		}
		catch (IOException e) {
			return null;
		}

	}// base64decode
}
