package mergesort;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] unsortedArray;
        int[] sortedArray;
        unsortedArray = new int[] {12, 6, 2};
        sortedArray = mergeSort(unsortedArray);
                
        for (int i=0; i<sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }

    public static int[] mergeSort(int[] unsortedArray) {
        // recursive merge sort algorithm
        int inputLength = unsortedArray.length;

        // split array into 2 arrays that diff by <= 1
        int[] arrayA = Arrays.copyOfRange(unsortedArray, 0, inputLength/2);
        int[] arrayB = Arrays.copyOfRange(unsortedArray, inputLength/2, inputLength);
        int[] sortedArray = new int[inputLength];
        
        // continue to split arrays until they are both diff by <= 1
        if (arrayA.length > 1 || arrayB.length > 1) {
            arrayA = mergeSort(arrayA);
            arrayB = mergeSort(arrayB);
        }

        int i = 0;
        int j = 0;
        for (int k=0; k<inputLength; k++){
            // if 1 array is already used just keep adding other array);
            if (i==arrayA.length){
                sortedArray[k] = arrayB[j];
                j++;
                continue;
            } else if (j==arrayB.length){
                sortedArray[k] = arrayA[i];
                continue;
            }
            
            // add the lower array element to the sorted array
            if (arrayA[i] < arrayB[j]) {
                sortedArray[k] = arrayA[i];
                i++;
            } else {
                sortedArray[k] = arrayB[j];
                j++;
            }
        }

        return sortedArray;
    }
}