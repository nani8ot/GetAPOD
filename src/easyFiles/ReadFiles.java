package easyFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFiles {
	public String loadFile(String path) {
		BufferedReader in = null;
		String file = null;
		try {
			in = new BufferedReader(new FileReader(path));
			String zeile = "MIST";
			System.out.println(in.readLine());
			while ((zeile = in.readLine()) != null) {
//				System.out.println(zeile);
				try {
					file += ";";
					file += zeile;
				} catch (Exception e) {
					System.out.println("Concat Failed");
				}
//				System.out.println("Gelesene Zeile: " + zeile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("Closing Reader failed");
				}
		}

//		System.out.println("File: " + file);
		return file;

	}

}
