package downloadPictures;

import java.net.URL;

import easyFiles.ReadProperties;

public class DownloadPictureMain {

	public static void main(String[] args) throws Exception {
		String propertiesPath = "GetAPOD.conf";
		
		System.out.println("Working Directory = " + System.getProperty("user.dir")); // debug
		
		URL urlLine = new URLReader().getUrlFileLine(new ReadProperties().getProperties(propertiesPath, "keyword"), new URL(new ReadProperties().getProperties(propertiesPath, "url")), propertiesPath);
		System.out.println(urlLine); // debug
		new DownloadFile().getFile(urlLine, propertiesPath);
		
		System.out.println("Finished and Exit");
	}

}
