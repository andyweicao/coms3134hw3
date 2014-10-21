import java.util.*;
import java.io.*;

// Wei Cao(wc2467)
public class IndexWords {

    public static void main(String[] args) throws FileNotFoundException,IOException {
		
		File file = new File(args[0]); //input txt file
		FileReader fileReader = new FileReader(file); // read the file
		BufferedReader br = new BufferedReader(fileReader);
		System.out.println("\nHere are the the information of file \"" + args[0] +"\":\n");
		AvlTree<String> avl = new AvlTree<String>(); // set the new AVL tree
		int lineCounter = 0;// set line counter to count line numbers
		String line; // set String for each line
		while ((line = br.readLine()) != null) {
			lineCounter++; // new line get started.
			String[] arr = line.split("[\\p{Punct}\\s]+"); // get each word of the line
			for (String s:arr){ // for each word
			   if(!avl.contains(s)){ // check if it is in the tree
				   avl.insert(s,lineCounter); // if not, add the word with its line number into the tree
			   }
			   else
				   avl.addLine(s,lineCounter); // if it exists in the tree, add the line number to the node
		   }
		   
	   }
	      
		br.close();
		
		avl.printTree(); // print out the tree.
    }
}