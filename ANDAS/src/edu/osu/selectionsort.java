package edu.osu;
import java.io.*;

public class selectionsort{

	public static int[] sort(int[] arr){
         
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index]) 
                    index = j;
      
            int smallerNumber = arr[index];  
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
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


        arr = sort(arr);
        

        FileWriter fw = new FileWriter(args[1]);
        for (int x = 0;x<arr.length;x++){
        	fw.write(arr[x] + "\n");
        	System.out.println(arr[x]);

        }
        fw.close();
      
        
		}
	catch (Exception e){
		System.out.println(e);
	}


        
        


	}
}