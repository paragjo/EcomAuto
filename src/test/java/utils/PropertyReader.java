package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File f = new File(System.getProperty("user.dir")+"\\obj_repo.properties");
		
		FileInputStream fis = new FileInputStream(f);
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String url = prop.getProperty("baseUrl");
		
		System.out.println(url);
		
		String uname = prop.getProperty("uname");
		System.out.println(uname);
		
		
		
		

	}

}
