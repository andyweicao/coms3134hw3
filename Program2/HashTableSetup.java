import java.util.*;

// Wei Cao(wc2467)

public class HashTableSetup {
	
	//Use an array of linked lists to implement the hashtable   
	private LinkedList<String>[] hashTable;
    private final int TABLE_SIZE = 100003 ;//table size
    private ReadFile file;
	
	@SuppressWarnings("unchecked")
	public HashTableSetup(String dic1, String dic2) {
		
		hashTable = new LinkedList[TABLE_SIZE];
        file = new ReadFile();
        inputDictionary(dic1);
		inputDictionary(dic2);
    }

    // Setup the hash function
    private int hash(String key) {
        int value = 0;

        for (int i = 0; i < key.length(); i++) {
            value = 37 * value + key.charAt(i);
        }
        value %= TABLE_SIZE;
        if (value < 0) {
            value += TABLE_SIZE;
        }
		
		//System.out.println(value);
        return value;
    }
    
    
     
	 //Insert a value to the hash table
    public void insert(String key) {
        if (this.hashTable[hash(key)] == null) {
            this.hashTable[hash(key)] = new LinkedList<String>();// Setup new linkedlist for the new hash value
            hashTable[hash(key)].add(key); // link the string
        } else {
            this.hashTable[hash(key)].add(key); // Here is using separate chain to solve the collision
												// link the new string with the same hash value after the previous one.
        }
    }
    
    // Check whether a string is in the hash table
    public boolean contains(String key) {
        if (hashTable[hash(key)] == null) {
            return false;
        } else {
            return hashTable[hash(key)].contains(key);
        }
    }
        
    // Input the dictionary files
    private void inputDictionary(String dic) {

        try {
            file.openFile(dic);

            while (file.getFile().ready()) {
				//insert dictionary words into hash table
                insert(file.getFile().readLine().replaceAll("[!\"£$%^&*':;,.]", ""));  
            }

            System.out.println("The dictionary file \"" + dic + "\" has been stored into the hashtable. ");
            file.closeFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}