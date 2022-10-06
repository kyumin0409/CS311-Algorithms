import java.io.File;
import java.io.FileNotFoundException;

/**
 * Driver class that has main
 * @author Caroline Kim (ID: 29855696)
 *
 */
public class AnagramDriver {

	public static void main(String[] args) throws FileNotFoundException {
		//dict1 testing and measuring running time
		long startTime1 = System.currentTimeMillis();
		
		Anagram anag1 = new Anagram(new File("/courses/cs300/cs311/kyuminkim/CS311-Anagram/dict1"));
		anag1.fillArr();
		anag1.findAnagram("/courses/cs300/cs311/kyuminkim/CS311-Anagram/anagram1");
		
		long endTime1 = System.currentTimeMillis();
		System.out.println("total time for dict1: " + (endTime1-startTime1));
		
		//dict2 testing and measuring running time
		long startTime2 = System.currentTimeMillis();
		
		Anagram anag2 = new Anagram(new File("/courses/cs300/cs311/kyuminkim/CS311-Anagram/dict2"));
		anag2.fillArr();
		anag2.findAnagram("/courses/cs300/cs311/kyuminkim/CS311-Anagram/anagram2");
		
		long endTime2 = System.currentTimeMillis();
		System.out.println("total time for dict2: " + (endTime2-startTime2));
	}

}
