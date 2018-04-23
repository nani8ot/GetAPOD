package downloadPictures;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;

import easyFiles.ReadProperties;

public class DownloadPictureMain {

	public static void main(String[] args) throws Exception {
		String propertiesPath = "GetAPOD.conf";
		String logPath = "GetApod.log";
		
		System.out.println("Working Directory = " + System.getProperty("user.dir")); // debug
		
		String urlLine = new URLReader().getUrlFileLine(new ReadProperties().getProperties(propertiesPath, "keyword"), new URL(new ReadProperties().getProperties(propertiesPath, "url")), propertiesPath);
		
		System.out.println(urlLine); // debug
		
		final long timeStart = System.currentTimeMillis();
		new DownloadFile().getFile(urlLine, propertiesPath);
		final long timeEnd = System.currentTimeMillis();
		PrintWriter pWriter = new PrintWriter(new FileWriter(logPath, true), true);
		pWriter.printf("%s: Downloads %s to %s\\%s in %s Seconds\n", new Date().toString(),urlLine, System.getProperty("user.dir").toString(), logPath, (timeEnd - timeStart) / 1000);
		pWriter.close();
		
		System.out.println("Finished and Exit");
	}

}
