import java.io.BufferedReader;
import java.io.FileReader;

// Wei Cao(wc2467)

public class ReadFile {
    
    private BufferedReader useFile;
    
    
	// Open the file from rhe path
    public void openFile(String path){
        try{
            useFile = new BufferedReader(new FileReader(path));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
	
    // Get the file
    public BufferedReader getFile() {
        return useFile;
    }
    
	// Close the file
    public void closeFile(){       
        try{
            getFile().close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}