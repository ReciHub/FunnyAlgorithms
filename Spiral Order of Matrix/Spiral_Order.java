import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// sample input 
// 4 5
// 1 2 3 4 5
// 6 7 8 9 10
// 11 12 13 14 15
// 16 17 18 19 20


public class Spiral_Order{
    public static void main(String args[]) throws IOException{
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    	int rows , columns;
    	String input[];
    	input = bufferedReader.readLine().split("\\s");
    	rows = Integer.parseInt(input[0]);
    	columns = Integer.parseInt(input[1]);

    	int [][] array = new int[rows][columns];

    	
    	for (int i=0;i < rows ; i++){
    		input = bufferedReader.readLine().split("\\s");
    		for(int j = 0; j< columns ; j++){
    			array[i][j] = Integer.parseInt(input[j]);
    		}
    	}

    	int totalElements = rows * columns ;

    	int columnLeft = 0;
    	int rowUp = 0;
    	int count = 0;
    	while(true){
    		for(int i = columnLeft; i<columns; i++){
    			System.out.print(array[rowUp][i]+" ");
    			count++;
    		}
    		rowUp++;
    		for(int i = rowUp; i<rows; i++){
    			System.out.print(array[i][columns-1]+" ");
    			count++;
    		}
    		columns--;
    		for(int i = columns-1; i >= columnLeft; i--){
    			System.out.print(array[rows-1][i]+" ");
    			count++;
    		}
    		rows--;
    		for(int i = rows-1; i>=rowUp; i--){
    			System.out.print(array[i][columnLeft]+" ");
    			count++;
    		}
    		if(count == totalElements){
    			System.out.print("\n");
    			break;
    		}
    		columnLeft++;
    	}
    }
}