package edu.osu;
import java.io.*;

public class quickSort{

	private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSortFile(0, length - 1);
    }
 
    private void quickSortFile(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSortFile(lowerIndex, j);
        if (i < higherIndex)
            quickSortFile(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     

	public static void main(String[] args){
	
	int len = 0;
	String file =args[0];
	System.out.println(file);
	try{
		BufferedReader br = new BufferedReader(new FileReader(file));
		len = Integer.parseInt(br.readLine());
		System.out.println(len);
		int[] arr = new int[len];
		String line;
		int i =0;
		while ((line = br.readLine()) != null) {
			arr[i]=Integer.parseInt(line);
		   //System.out.println(arr[i]);
		   i++;
			}
		br.close();

        quickSort sorter = new quickSort();
        
        sorter.sort(arr);
        
        StringBuffer sb = new StringBuffer();
        FileWriter fw = new FileWriter("c://temp//sorted.txt");
        for (int x = 0;x<arr.length;x++){
        	fw.write(arr[x] + "\n");
        	sb.append(arr[x]+ "\n");
        	System.out.println(arr[x]);

        }
        fw.close();
      
        
		}
	catch (Exception e){
		System.out.println(e);
	}


        
        


	}
}