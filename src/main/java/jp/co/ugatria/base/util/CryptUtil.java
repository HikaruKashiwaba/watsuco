package jp.co.ugatria.base.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.RandomStringUtils;

public class CryptUtil {

	/**
	 * salt + ストレッチングしたパスワードを取得
	 * @param password 生成前のパスワード
	 * @return 暗号化したパスワード
	 */
	public static String encryptPassword(String password) {
		return getHash(password);
	}

	public static String generateRealFilename() {
		return getHash(RandomStringUtils.randomAlphanumeric(20));
	}

	/**
	 * 文字列から SHA256 のハッシュ値を取得
	 */
	private static String getHash(String value) {
		MessageDigest md = null;
		StringBuilder buf = new StringBuilder();
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(value.getBytes());
			byte[] digest = md.digest();
			for (int i = 0; i < digest.length; i++) {
				buf.append(String.format("%02x", digest[i]));
			}
		}
		catch (NoSuchAlgorithmException e) {
			//Logger.error("アルゴリズムが無効です。", e);
			throw new IllegalArgumentException("アルゴリズムが無効です。", e);
		}
		return buf.toString();
	}
}
