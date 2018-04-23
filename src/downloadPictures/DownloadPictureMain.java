package downloadPictures;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import easyFiles.ReadProperties;

public class DownloadPictureMain {

	public static void main(String[] args) {
		final String propertiesPath = "GetAPOD.conf";
		final String logPath = "GetApod.log";
		
		System.out.println("Working Directory = " + System.getProperty("user.dir")); // debug
		
		final String urlLine;
		try {
			urlLine = new URLReader().getUrlFileLine(new ReadProperties().getProperties(propertiesPath, "keyword"), new URL(new ReadProperties().getProperties(propertiesPath, "url")), propertiesPath);
			
			System.out.println(urlLine); // debug
			
			final long timeStart = System.currentTimeMillis();
			new DownloadFile().getFile(urlLine, propertiesPath);
			final long timeEnd = System.currentTimeMillis();
			final PrintWriter pWriter = new PrintWriter(new FileWriter(logPath, true), true);
			pWriter.printf("%s: Downloads %s to %s\\%s in %s Seconds\n",
						new Date().toString(),urlLine, System.getProperty("user.dir").toString(),
						logPath, (timeEnd - timeStart) / 1000);
			pWriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(new JFrame(),
										e.toString().substring(e.toString().lastIndexOf(":") + 1,
										e.toString().length()), e.toString().substring(0, e.toString().lastIndexOf(":")),
										JOptionPane.ERROR_MESSAGE);
		}
		
		System.out.println("Finished and Exit");
	}

}
