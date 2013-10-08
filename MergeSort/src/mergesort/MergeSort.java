package mergesort;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] unsortedArray;
        int[] sortedArray;
        unsortedArray = new int[] {4, 2, 3};
        sortedArray = mergeSort(unsortedArray);
                
        for (int i=0; i<sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }

    public static int[] mergeSort(int[] unsortedArray) {
        // recursive merge sort algorithm
        int inputLength = unsortedArray.length;
        int loopLimit = inputLength/2;

        int[] arrayA = Arrays.copyOfRange(unsortedArray, 0, inputLength/2);
        int[] arrayB = Arrays.copyOfRange(unsortedArray, inputLength/2, inputLength);
        int[] sortedArray = new int[inputLength];
        
        if (arrayA.length > 1 && arrayB.length > 2) {
            mergeSort(arrayA);
            mergeSort(arrayB);
        }

        if (inputLength % 2 != 0) loopLimit--;

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < loopLimit && j < loopLimit) {
            if (arrayA[i] < arrayB[j]) {
                sortedArray[k] = arrayA[i];
                i++;
            } else {
                sortedArray[k] = arrayB[j];
                j++;
            }
            k++;
        }


        for (; k < sortedArray.length; k++) {
            if (i>j) {
                sortedArray[k] = arrayB[j];
                j++;
            } else {
                sortedArray[k] = arrayA[i];
                j++;
            }
        }
        return sortedArray;
    }
}