package downloadPictures;

import java.io.*;
import java.net.URL;

import easyFiles.ReadProperties;

public class URLReader {
    
	public String getUrlFileLine(String keyword, URL htmlUrl, String propertiesPath) throws Exception {
        BufferedReader in = new BufferedReader(
        new InputStreamReader(htmlUrl.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
        	if(inputLine.contains(keyword)) {
        		break;
        	}
        }
        in.close();
        System.out.println("InputLine: " + inputLine); // debug
//        int ends1 = inputLine.length() + (Integer.parseInt (new ReadProperties().getProperties(propertiesPath, "ends1")));
//        int starts1 = Integer.parseInt(new ReadProperties().getProperties(propertiesPath, "starts1"));
        
        int ends2 = Integer.parseInt (new ReadProperties().getProperties(propertiesPath, "ends2"));
        int starts2 = Integer.parseInt(new ReadProperties().getProperties(propertiesPath, "starts2"));
        
        int starts1 = inputLine.indexOf('"') +1;
        int ends1 = inputLine.lastIndexOf('"');
        System.out.println("Relative Link of inputLine starts at: " + starts1);
        System.out.println("Relative Link of inputLine ends at: " + ends1);
        
        String relativePictureUrl = inputLine.substring(starts1, ends1);
        String pictureUrl = htmlUrl.toString().substring(starts2, ends2).concat(relativePictureUrl);
        System.out.println("URLReader aufgerufen.");
        return pictureUrl;
    }
    

}