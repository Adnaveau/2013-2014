package probleme;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileRW {
	
    private FileRW()
    {
    }
    
	public static String readFile(String pathFile){
		String content = "";
		String lineTMP = "";
		try {
			File file = new File(pathFile);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((lineTMP = reader.readLine()) != null){
				content = content + lineTMP + " "; // Replacing new lines by spaces simplifies the scanning process
			}
			reader.close();
		} catch (IOException e) {
			System.err.println("Error while reading file!");
			e.printStackTrace();
		}
		return content;
	}
	
	public static void writeFile(String pathFile, String toWrite){
		try {
			File file = new File(pathFile);
			PrintWriter writer = new PrintWriter (new BufferedWriter (new FileWriter(file, true)));
			writer.print(toWrite);
			writer.close();
		} catch (IOException e) {
			System.err.println("Error while writing file!");
			e.printStackTrace();
		}
	}
}
