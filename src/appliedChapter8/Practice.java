package appliedChapter8;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Practice {
	public static void main(String[] args) {
		URL url = null;
		InputStream is = null;
		InputStreamReader isr = null;
		try {
			url = new URL("https://www.wikipedia.org");
			is = url.openStream();
			isr = new InputStreamReader(is);
			int i = isr.read();
			while(i != -1) {
				System.out.print((char) i);
				i = isr.read();
			}
		} catch (MalformedURLException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			try {
				if(is != null) {
					is.close();
				}
				if(isr != null) {
					isr.close();
				}
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}
}
