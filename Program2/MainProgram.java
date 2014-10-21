import java.util.*;

// Wei Cao(wc2467)

public class MainProgram {
    
    private static SpellCheck spellChecker;
    
    public static void main(String[] args){
        System.out.println("\nWelcome to use this spell check.\n");
        spellChecker = new SpellCheck(args[0],args[1]); // set spell checker
        spellChecker.checkWords(args[2]); // check input file
        System.out.println("\nThank you for using this program. Bye.");
        System.exit(0);
        
    }
        
}