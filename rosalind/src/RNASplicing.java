import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RNASplicing {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        Map<String, String> codonTable = new HashMap<>();
        codonTable.put("UUU", "F");codonTable.put("CUU", "L");
        codonTable.put("AUU", "I");codonTable.put("GUU", "V");
        codonTable.put("UUC", "F");codonTable.put("CUC", "L");
        codonTable.put("AUC", "I");codonTable.put("GUC", "V");
        codonTable.put("UUA", "L");codonTable.put("CUA", "L");
        codonTable.put("AUA", "I");codonTable.put("GUA", "V");
        codonTable.put("UUG", "L");codonTable.put("CUG", "L");
        codonTable.put("AUG", "M");codonTable.put("GUG", "V");
        codonTable.put("UCU", "S");codonTable.put("CCU", "P");
        codonTable.put("ACU", "T");codonTable.put("GCU", "A");
        codonTable.put("UCC", "S");codonTable.put("CCC", "P");
        codonTable.put("ACC", "T");codonTable.put("GCC", "A");
        codonTable.put("UCA", "S");codonTable.put("CCA", "P");
        codonTable.put("ACA", "T");codonTable.put("GCA", "A");
        codonTable.put("UCG", "S");codonTable.put("CCG", "P");
        codonTable.put("ACG", "T");codonTable.put("GCG", "A");
        codonTable.put("UAU", "Y");codonTable.put("CAU", "H");
        codonTable.put("AAU", "N");codonTable.put("GAU", "D");
        codonTable.put("UAC", "Y");codonTable.put("CAC", "H");
        codonTable.put("AAC", "N");codonTable.put("GAC", "D");
        codonTable.put("CAA", "Q");codonTable.put("AAA", "K");
        codonTable.put("GAA", "E");codonTable.put("CAG", "Q");
        codonTable.put("AAG", "K");codonTable.put("GAG", "E");
        codonTable.put("UGU", "C");codonTable.put("CGU", "R");
        codonTable.put("AGU", "S");codonTable.put("GGU", "G");
        codonTable.put("UGC", "C");codonTable.put("CGC", "R");
        codonTable.put("AGC", "S");codonTable.put("GGC", "G");
        codonTable.put("CGA", "R");codonTable.put("AGA", "R");
        codonTable.put("GGA", "G");codonTable.put("UGG", "W");
        codonTable.put("CGG", "R");codonTable.put("AGG", "R");
        codonTable.put("GGG", "G");
        codonTable.put("UAA", "Stop");
        codonTable.put("UGA", "Stop");
        codonTable.put("UAG", "Stop");

        List<String> introns = new LinkedList<String>();
        StringBuilder dna = new StringBuilder();
        boolean readingDNA = true;

		try (BufferedReader reader = new BufferedReader(new FileReader("rosalind_splc.txt"))) {
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
			    if (readingDNA && !line.startsWith(">") ) {
		            dna.append(line);
			    }
			    else if(line.startsWith(">")) 
			    	readingDNA = false;
			    else if (!line.startsWith(">"))
			    	introns.add(line);
			    
			}
		}
		// Removing introns from the DNA sequence
		String newDna = dna.toString();
		System.out.println(dna);
        for (String intron : introns) {
            newDna = (newDna.toString().replace(intron, ""));
        }
        //DNA to RNA
        System.out.println(newDna);
        String rna = newDna.toString().replaceAll("T", "U");
		StringBuilder protein = new StringBuilder();
		
		//RNA to Protein
        for (int i = 0; i < rna.length() - 2; i += 3) {
            String codon = rna.substring(i, i + 3);
            String aminoAcid = codonTable.get(codon);
            if (aminoAcid != null) {
                if (aminoAcid.equals("Stop")) {
                    break;
                }
                protein.append(aminoAcid);
            }
        }
        System.out.println(protein.toString());   
	}
}
