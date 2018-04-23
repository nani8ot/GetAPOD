package downloadPictures;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class DownloadFile {
	
	public void getFile(String url, String propertiesPath) throws IOException {
		InputStream is = new URL(url).openStream();
		OutputStream os = new FileOutputStream( "Images\\" + (url.substring(url.lastIndexOf("/") +1)) ); // Get File Name and name the file
		
		byte[] b = new byte[2048];
		int length;
		long i = -1;
		final long timeStart = System.currentTimeMillis();
		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);

			
			/**
			 * shows the time of the download
			 */
			final long timeEnd = System.currentTimeMillis();
			if (i != (timeEnd / 1000)) {
				System.out.print("-");
				i = (timeEnd / 1000);
			}
		}
		final long timeEnd = System.currentTimeMillis();
		System.out.println();
		System.out.println("Verlaufszeit des Downloads: " + ((timeEnd - timeStart) / 1000) + "s.");
		
		is.close();
		os.close();
		
		System.out.println("File Written");
		
	}

}
