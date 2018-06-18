package main.java.test;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;

import main.java.utility.CompareUsers;
import main.java.utility.GetFileData;
import main.java.webservices.GetMethod;


public class TestRunner {


	@Test
    public void test_Positive() throws JsonProcessingException{

		File file1 = new File("DataFiles/File1.txt");
		Path path1 = file1.toPath();
		File file2 = new File("DataFiles/File2.txt");
		Path path2 = file2.toPath();
		
		List<String> urlList = GetFileData.getData(path1,path2);
	
			
		urlList.forEach(url -> { 
			
				String url1,url2,response1,response2;
				url1 = url.split(",")[0];
				url2 = url.split(",")[1];
				
				if (!url1.equals(url2)) {
			
					response1 = GetMethod.getUsers(url1);
					response2 = GetMethod.getUsers(url2);
					
					if(response1==null || response2==null)
						System.out.println(url1+" Not equals "+url2);
			
					else if(new CompareUsers().compare(response1, response2)) {
						System.out.println(url1+" equals "+url2);
					}
					else {
						System.out.println(url1+" Not equals "+url2);
					}
				}
				else {
					System.out.println(url1+" equals "+url2);
				}
				
		});
					
	}
	
}
