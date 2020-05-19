package appliedChapter6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class CipherFilterPractice {
	public static void main(String[] args) {
		/*-------------- RSA 로 암호화 --------------*/
		// 암호화 스트림 연결
		// RSA 비밀키와 공개키를 생성
		KeyPairGenerator keyPairGen;
		KeyPair keyPair;
		RSAPrivateKey privateKey;
		RSAPublicKey publicKey;
		Cipher cipher;
		byte[] encryptBytes;
		try {
			keyPairGen = KeyPairGenerator.getInstance("RSA");
			keyPair = keyPairGen.generateKeyPair();
			privateKey = (RSAPrivateKey) keyPair.getPrivate();
			publicKey = (RSAPublicKey) keyPair.getPublic();
			// 파일 출력 스트림 생성
			FileOutputStream fos = new FileOutputStream("dataRSA.txt");
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			CipherOutputStream cos = new CipherOutputStream(fos, cipher);
			encryptBytes = cipher.doFinal(Integer.toString(65).getBytes());
			System.out.println(new String(encryptBytes));
			// 암호화하여 파일에 쓰기
			cos.write(65);
			cos.close();
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e1) {
			e1.printStackTrace();
		} catch (InvalidKeyException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*-------------- AES 로 암호화 --------------*/
		// 암호화에 사용할 키, 디폴트로 128Bit (16Byte)
		String encryptionKey = "happyprogrammer!";
		// AES Cipher 객체 생성
		SecretKeySpec secretKeySpec;
		try {
			cipher = Cipher.getInstance("AES");
			secretKeySpec = new SecretKeySpec(encryptionKey.getBytes(), "AES");
			// 암호화 Cipher 초기화
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			FileOutputStream fos = new FileOutputStream("dataAES.txt");
			// 암호화 완료
			encryptBytes = cipher.doFinal(Integer.toString(65).getBytes());
			System.out.println(new String(encryptBytes));
			CipherOutputStream cos = new CipherOutputStream(fos, cipher);
			// 암호화하여 파일에 쓰기
			cos.write(65);
			cos.close();
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
// ByteArrayOutputStream baos = new ByteArrayOutputStream();
// baos.write(65);
// baos.write(66);
// byte[] data = baos.toByteArray();
// List<Byte> byteList = new ArrayList<Byte>();
// for(byte val : data) {
// 	byteList.add(val);
// }
// byteList.stream().forEach(System.out::println);