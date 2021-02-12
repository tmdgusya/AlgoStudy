package sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] array = {3,7,1,9,5};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array){
        for(int i = array.length-1; i >= 0; i--){
            findBigNumber(array, i);
        }
    }

    public static void findBigNumber(int[] array, int searchLength){
        int maxIdx = 0;
        int maxValue = array[0];
        for(int i = 0; i <= searchLength; i++){
            if(maxValue < array[i]){
                maxValue = array[i];
                maxIdx = i;
            }
        }
        swap(array, searchLength, maxIdx, maxValue);
    }

    public static void swap(int[] array, int lastIndex, int maxIndex, int maxValue){
        int temp = array[lastIndex];
        array[lastIndex] = maxValue;
        array[maxIndex] = temp;
    }
}
