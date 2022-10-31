//Silas Bartha, October 3 2019, Letter Pairing Frequency Analysis
package freqanalysis;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;

public class FreqAnalysisPairs {
	
	public static void main(String[] args) {
		
	//I: Setup
		
		//Reading in file, and creating one giant string
		File file;
		byte[] data;
		String text = "";

		try {
			
			//Get file from res folder
			file = new File(FreqAnalysisPairs.class.getResource("beyondgoodandevil.txt").toURI());
			
			//Place all bytes into array
			data = Files.readAllBytes(file.toPath());
			
			//Create string from byte array, converting all letters into uppercase for ease later
			text = new String(data, "UTF-8").toUpperCase();
					
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}catch(NullPointerException e){
			
			//End program if file is not found
			System.out.println("File not found!");
			e.printStackTrace();
			System.exit(0);
		}
		
		//Initialize Letter Pairing Positions
		String[][] combos = new String[26][26];
		
		//Initialize frequency array
		int[][] freqs = new int[26][26];
		
		//Place letter pairings into combo array
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < 26; j++) {
				
				//e.g. i = 0, j = 1; combos[i][j] = "AB"
				combos[i][j]= new String(new char[]{(char)(i+'A'), (char)(j+'A')});
			}
		}
		
	//II: Readying Frequencies for Sorting
		
		//Get Pairing Frequencies
		for(int i = 0; i<text.length()-1; i++) {
			
			//Cut out 2-character substring
			String sub = text.substring(i, i+2);
			
			//Increase the appropriate combo frequency
			for (int cx = 0; cx < combos[0].length; cx++) {
				for (int cy = 0; cy < combos[1].length; cy++) {
				    if (combos[cx][cy].equals(sub)) {
				        freqs[cx][cy]++;
				    }
				}
			}
		}
		
		//Setup ArrayLists for Pairings and Frequencies, while also printing out frequencies
		ArrayList<String> combosToSort = new ArrayList<String>();
		ArrayList<Integer> freqsToSort = new ArrayList<Integer>();
		
		System.out.println("Frequencies: ");
		for (int cx = 0; cx < combos[0].length; cx++) {
			for (int cy = 0; cy < combos[1].length; cy++) {
			    
				//Print Out Frequencies
				System.out.printf("%-9s",combos[cx][cy] + ": " + freqs[cx][cy]);
			    
				//Remove All Pairings Containing Vowels
			    boolean shouldSort = true;
			    for(int i = 0; i < combos[cx][cy].length(); i++) {
			    	
			    	if("AEIOU".contains(Character.toString(combos[cx][cy].charAt(i)))) shouldSort = false;
			    }
			    if(shouldSort) {
			    	
			    	//Add Acceptable Values to ArrayLists
		    		freqsToSort.add(freqs[cx][cy]);
		    		combosToSort.add(combos[cx][cy]);
		    	}
			    
			    //Newline for Printing
			    if((cy+1)%5==0){
			    	System.out.println();
			    }
			}
			
			//Space Between Sections for Printing
			System.out.println("\n");
		}
		
	//III: Sorting
		
		//Turn Back to Arrays for Sorting
		Integer[] freqSortArray = freqsToSort.toArray(new Integer[freqsToSort.size()]);
		String[] comboSortArray = combosToSort.toArray(new String[combosToSort.size()]);
		
		//Sort
		for (int i = 0; i < freqSortArray.length; i++) {
            for (int j = i + 1; j < freqSortArray.length; j++) {
                if (freqSortArray[i] > freqSortArray[j]) {
                	
                	//What You Do to Frequencies Must Also be Done to The Positioning of Pairings
                	int temp = freqSortArray[i];
                	freqSortArray[i] = freqSortArray[j];
                	freqSortArray[j] = temp;
                    String tempStr = comboSortArray[i];
                    comboSortArray[i] = comboSortArray[j];
                    comboSortArray[j] = tempStr;
                }
            }
        }
		
		//Print Results
		System.out.println("\nTop 10 Consonant Pairs:\n");
		for(int i = freqSortArray.length-1; i>freqSortArray.length-11; i--) {
			System.out.println(comboSortArray[i] + ": " + freqSortArray[i]);
		}
	}
}