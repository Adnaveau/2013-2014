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
    
	public BufferedReader getReader()
	{
		return reader;
	}
	
	public PrintWriter getWriter()
	{
		return writer;
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
