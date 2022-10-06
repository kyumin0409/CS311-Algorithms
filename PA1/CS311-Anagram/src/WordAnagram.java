
/**
 * WordAnagram class is a class for object where there are two Strings, 
 * the original word and the word that has letters sorted alphabetically.
 * @author Caroline Kim (ID: 2895696)
 *
 */
public class WordAnagram {
	private String word;
	private String sortedWord;
	
	/**
	 * Constructor
	 * @param w: original word
	 * @param s: sorted word
	 */
	public WordAnagram(String w, String s){
		word=w;
		sortedWord=s;
	}
	
	/**
	 * get word
	 * @return 
	 */
	public String getWord(){
		return word;
	}
	
	/**
	 *   get sorted words   
	 * @return
	 */
	public String getSorted(){
		return sortedWord;
	}
}
