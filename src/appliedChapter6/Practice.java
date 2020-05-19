package appliedChapter6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;

public class Practice {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IOException, InvalidKeyException {
		// 파일 출력 스트림 생성
		FileOutputStream fos = new FileOutputStream("data.txt");
		/*-------------- RSA 로 암호화 --------------*/
		// 암호화 스트림 연결
		// RSA 비밀키와 공개키를 생성
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		CipherOutputStream cos = new CipherOutputStream(fos, cipher);
		// 암호화하여 파일에 쓰기
		cos.write(65);
		cos.close();
		/*-------------- AES 로 암호화 --------------*/
		// 암호화에 사용할 키, 디폴트로 128Bit (16Byte)
		String encryptionKey = "happyprogrammer!";
		// 암호화할 문자열
				
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