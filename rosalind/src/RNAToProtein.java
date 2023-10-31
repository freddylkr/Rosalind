import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RNAToProtein {
	public static Map<String, String> codonTable = new HashMap<>();
    public static void main(String[] args) throws FileNotFoundException {
        // Define the RNA codon table with all codons and their corresponding amino acids
        
        codonTable.put("UUU", "F");
        codonTable.put("CUU", "L");
        codonTable.put("AUU", "I");
        codonTable.put("GUU", "V");
        codonTable.put("UUC", "F");
        codonTable.put("CUC", "L");
        codonTable.put("AUC", "I");
        codonTable.put("GUC", "V");
        codonTable.put("UUA", "L");
        codonTable.put("CUA", "L");
        codonTable.put("AUA", "I");
        codonTable.put("GUA", "V");
        codonTable.put("UUG", "L");
        codonTable.put("CUG", "L");
        codonTable.put("AUG", "M");
        codonTable.put("GUG", "V");
        codonTable.put("UCU", "S");
        codonTable.put("CCU", "P");
        codonTable.put("ACU", "T");
        codonTable.put("GCU", "A");
        codonTable.put("UCC", "S");
        codonTable.put("CCC", "P");
        codonTable.put("ACC", "T");
        codonTable.put("GCC", "A");
        codonTable.put("UCA", "S");
        codonTable.put("CCA", "P");
        codonTable.put("ACA", "T");
        codonTable.put("GCA", "A");
        codonTable.put("UCG", "S");
        codonTable.put("CCG", "P");
        codonTable.put("ACG", "T");
        codonTable.put("GCG", "A");
        codonTable.put("UAU", "Y");
        codonTable.put("CAU", "H");
        codonTable.put("AAU", "N");
        codonTable.put("GAU", "D");
        codonTable.put("UAC", "Y");
        codonTable.put("CAC", "H");
        codonTable.put("AAC", "N");
        codonTable.put("GAC", "D");
        codonTable.put("UAA", "Stop");
        codonTable.put("CAA", "Q");
        codonTable.put("AAA", "K");
        codonTable.put("GAA", "E");
        codonTable.put("UAG", "Stop");
        codonTable.put("CAG", "Q");
        codonTable.put("AAG", "K");
        codonTable.put("GAG", "E");
        codonTable.put("UGU", "C");
        codonTable.put("CGU", "R");
        codonTable.put("AGU", "S");
        codonTable.put("GGU", "G");
        codonTable.put("UGC", "C");
        codonTable.put("CGC", "R");
        codonTable.put("AGC", "S");
        codonTable.put("GGC", "G");
        codonTable.put("UGA", "Stop");
        codonTable.put("CGA", "R");
        codonTable.put("AGA", "R");
        codonTable.put("GGA", "G");
        codonTable.put("UGG", "W");
        codonTable.put("CGG", "R");
        codonTable.put("AGG", "R");
        codonTable.put("GGG", "G");

        String rna = null;
		File file = new File("rosalind_prot.txt");
		try (Scanner reader = new Scanner(file)) {
			while (reader.hasNextLine()) {
			  rna = reader.nextLine();
			}
		}
		
		System.out.println(translation(rna));
    }
    public static String translation(String dna) {
		StringBuilder protein = new StringBuilder();
        for (int i = 0; i < dna.length() - 2; i += 3) {
            String codon = dna.substring(i, i + 3);
            String aminoAcid = codonTable.get(codon);
            if (aminoAcid != null) {
                if (aminoAcid.equals("Stop")) {
                    break;
                }
                protein.append(aminoAcid);
            }
        }
        return protein.toString();    	
    }
}
