package downloadPictures;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import easyFiles.ReadProperties;

public class DownloadFile {
	public void getFile(URL fileUrl, String propertiesPath) throws IOException {
		InputStream is = fileUrl.openStream();
		int indexOfFileName = Integer.parseInt(new ReadProperties().getProperties(propertiesPath, "imageNameIndex"));
		System.out.println(fileUrl.toString().substring(38));
		OutputStream os = new FileOutputStream( "Images\\" + (fileUrl.toString().substring(indexOfFileName)) ); // Get File Name and name the file
		
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
				System.out.println("Verlaufszeit der Schleife: " + ((timeEnd - timeStart) / 1000) + "s.");
				i = (timeEnd / 1000);
			}
		}
		final long timeEnd = System.currentTimeMillis();
		System.out.println("Verlaufszeit der Schleife: " + ((timeEnd - timeStart) / 1000) + "s.");
		
		is.close();
		os.close();
		
		System.out.println("File Written");
		
	}

}
