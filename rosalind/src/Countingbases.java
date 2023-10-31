
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Countingbases {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int A = 0, C = 0, G = 0, T = 0;
		String data = null;
		File file = new File("rosalind_dna.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
		  data = reader.nextLine();
		  
		}
		reader.close();
		 for (int i = 0; i < data.length(); i++) {
				if(data.charAt(i) == 'A')
					A++;
				if(data.charAt(i) == 'C')
					C++;
				if(data.charAt(i) == 'G')
					G++;
				if(data.charAt(i) == 'T')
					T++;
			}
		 System.out.println(A + " " + C + " " + G + " " + T + " ");
	}

}
