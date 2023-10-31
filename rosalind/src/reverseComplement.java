import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class reverseComplement {
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String data = null;
		File file = new File("rosalind_revc.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			data = reader.nextLine(); 
		}
		reader.close();
	    StringBuilder reverseComplemet = new StringBuilder();
	    for (int i = data.length() - 1; i >= 0; i--) {
			char currentNucleotide = data.charAt(i);
	        char reverse;
	        switch (currentNucleotide) {
            case 'A': reverse = 'T';
                break;
            case 'T': reverse = 'A';
                break;
            case 'C': reverse = 'G';
                break;
            case 'G':  reverse = 'C';
                break;
            default:
                reverse = currentNucleotide;
        }
	        reverseComplemet.append(reverse);
		}
		System.out.println(reverseComplemet);	
	}
}