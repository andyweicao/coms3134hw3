import java.io.*;
import java.util.*;

// Wei Cao(wc2467)

public class SpellCheck {

    private HashTableSetup table;
    private ReadFile file;
	

    public SpellCheck(String dic1, String dic2) {
        table = new HashTableSetup(dic1, dic2); // get the hashtable with dictionary words
    }

    // check words from the file 
    public void checkWords(String path) {

        try {
			ReadFile br = new ReadFile();
			br.openFile(path);// read the file
			int lineNum = 0; // set initial line number
			String line; 
            System.out.println("\nHere are all misspelled words from: \"" + path + "\"\n");
            while  ((line = br.getFile().readLine()) != null) {
				lineNum++;//line number plus one
				if(line.length() != 0){
					String[] arr = line.split("[\\p{Punct}\\s]+");// split words from the single-line sentence
					for (String s:arr){ // for each word on this line
						String word = getWord(s); // standardized the word
						checkSpelling(word.toLowerCase(),lineNum); // get the result of the spell checking
					}
				}
            }
            br.closeFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // This method is used to check each word
    private void checkSpelling(String word, int line) {
        if (!table.contains(word) && !isNumeric(word)) {
            System.out.println("The word \"" + word + "\" at Line " + line + " is misspelled.");// misspelled word
			List<String> corrections = getCorrections(word); // set the list for possible corrections
			System.out.print("Here are recommended corrections for \"" + word + "\" : ");
            for (String correction : corrections) {
				if (table.contains(correction)) { // check each possible correction in the dictionary
					System.out.print(correction + ", "); // If it is in the dictionary, print out the correction. 
                  }
            }
			System.out.println(" ");
			System.out.println(" ");
        }
    }


    // remove any symbols around the single word
    private String getWord(String oldWord) {
        return oldWord.replaceAll("[!\"£$%^&*':;,.]", "");
    }
	
    // check numeric number
    private boolean isNumeric(String key) {
        try {
            Double.parseDouble(key);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
	
	// get the list of all possible corrections for a single misspelled word
    public List<String> getCorrections(String word) {
          List<String> corrections = new ArrayList<String>();
          int wordLength = word.length();         

          
          // adding one char, case 1
          for (int i = 0; i < wordLength + 1; i++) {
                for (char j = 'a'; j <= 'z'; j++)
                      corrections.add(word.substring(0, i) + j + word.substring(i));
          }
		  
          // deleting one char, skipping i, case 2
          for (int i = 0; i < wordLength; i++) {
                corrections.add(word.substring(0, i) + word.substring(i + 1));
          }
		  
          // swapping i with i+1, case 3
          for (int i = 1; i < wordLength - 1; i++) {
                corrections.add(word.substring(0, i) + word.charAt(i + 1)
                            + word.charAt(i) + word.substring(i + 2));
          }

          return corrections;
    }
}