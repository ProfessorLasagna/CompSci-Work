package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class Diction {

	public static boolean diccheck(String input){

		try (Stream<String> dictionary = Files.lines(Paths.get("dictionary.txt"))) {

			Iterator<String> meh;
			meh = dictionary.iterator();

			while(meh.hasNext()){

				String check = meh.next();
				//System.out.println(check);

				if(check.equals(input)){

					return(true);

				}

			}

		}catch(IOException ex){

		}
	
		//System.out.println("ahhhhhhhhhhhhhhhhhhhhhh");
		return(false);

	}

}
