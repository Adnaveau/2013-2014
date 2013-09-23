import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileRW {
	
	private String content;
	private String pathFile;
	private File file;
	
	
	public FileRW (String path){
		content = "";
		pathFile = path;
		file = new File(pathFile);
	}
	
	public void readFile(){
		String lineTMP = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((lineTMP = reader.readLine()) != null){
				content = content + lineTMP + "\n";
			}
		} catch (IOException e) {
			System.out.println("Error while reading file!");
			e.printStackTrace();
		}
	}
	
	public void writeFile(String toWrite){
		try {
			PrintWriter writer = new PrintWriter (new BufferedWriter (new FileWriter(file)));
			writer.println(toWrite);
			writer.close();
		} catch (IOException e) {
			System.out.println("Error while writing file!");
			e.printStackTrace();
		}
	}
	
	public String toString(){
		return content;
	}
	
}
