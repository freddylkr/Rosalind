import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class convertingRNAtoDNA {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String data = null;
		File file = new File("rosalind_rna.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
		  data = reader.nextLine();
		  
		}
		reader.close();
		System.out.println(data.replaceAll("T", "U"));
	}

}