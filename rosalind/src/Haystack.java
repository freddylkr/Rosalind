import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Haystack {
		public static void main(String[] args) throws FileNotFoundException {
			// TODO Auto-generated method stub
			File file = new File("rosalind_subs.txt");
			Scanner reader = new Scanner(file);
			int i = 0;
			String[] DNAstrings = new String[2];
			while (reader.hasNextLine()) {
				DNAstrings[i] = reader.nextLine();
				i++;
			}
			
			reader.close();
			String T = DNAstrings[0];
			String S = DNAstrings[1];

			int index = T.indexOf(S);
	        while (index != -1) {
	            System.out.print(index + 1 + " ");
	            index = T.indexOf(S, index + 1);
	        }
	}
}