import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileRW {
	
	private BufferedReader reader;
	private PrintWriter writer;
	
    public FileRW(String infname, String outfname)
    {
		try {
			File infile = new File(infname);
			reader = new BufferedReader(new FileReader(infile));
			File outfile = new File(outfname);
			writer = new PrintWriter (new BufferedWriter (new FileWriter(outfile)));
		} catch (FileNotFoundException e) {
			System.err.println("File couldn't be found");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Error while opening file");
			System.exit(1);
		}
    }
    
	public String readFile(){
		String content = "";
		String lineTMP = "";
		try {
			// Replacing new lines by spaces simplifies the scanning process
			while ((lineTMP = reader.readLine()) != null) content = content + lineTMP + " ";
		} catch (IOException e) {
			System.err.println("Error while reading file!");
			e.printStackTrace();
		}
		return content;
	}
	
	public void writeToFile(String toWrite){
		writer.println(toWrite);
	}
	
	public void close()
	{
		try {
			reader.close();
			writer.close();
		} catch (IOException e) {
			System.err.println("File couldn't be closed.");
			System.exit(1);
		}
	}
}
