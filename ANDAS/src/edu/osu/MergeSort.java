package edu.osu;

import java.io.*;

public class MergeSort{

private int[] array;
    private int[] tempMergArr;
    private int length;

public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }

public String storeSorted(String text){
int len = 0;
String file =text;
try{
BufferedReader br = new BufferedReader(new StringReader(file));
len = Integer.parseInt(br.readLine());
int[] arr = new int[len];
String line;
int i =0;
while ((line = br.readLine()) != null) {
arr[i]=Integer.parseInt(line);
  //System.out.println(arr[i]);
  i++;
}
br.close();

sort(arr);

        StringBuffer sb = new StringBuffer();

        FileWriter fw = new FileWriter("c://temp//sorted.txt");
        for (int x = 0;x<arr.length;x++){
        sb.append(arr[x]+ "\n");	
        fw.write(arr[x] + "\n");
        }
        fw.close();
      return sb.toString();
        
}
catch (Exception e){
System.out.println(e);
return "couldn't sort"+text;
}


        
        


}
}

