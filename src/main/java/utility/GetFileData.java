package main.java.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class GetFileData {
	
	public static List<String> getData(Path fileName1,Path fileName2) {
		
		List<String> list = new ArrayList<>();
	    try (Stream<String> s1 = Files.lines(fileName1);
	         Stream<String> s2 = Files.lines(fileName2))
	    {
	        Iterator<String> itr1 = s1.iterator();
	        Iterator<String> itr2 = s2.iterator();
	        //compare only till both the files have some entry
	        while (itr1.hasNext() && itr2.hasNext())
	        {
	            list.add(itr1.next()+","+itr2.next());
	        }
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return list;

	}

}
