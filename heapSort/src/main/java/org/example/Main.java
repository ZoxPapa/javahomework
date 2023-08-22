package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int min = 10;
        int max = 50;
        int qty = 10;

        int[] arr = getRandomArr(min, max, qty);
        printArray(arr);
        for (int i = arr.length/2-1; i >=0 ; i--) {
            heapSort(arr, arr.length, i);
        }
        for (int i = arr.length-1; i >= 0; i--) {
            printArray(arr);
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapSort(arr, i, 0);
        }



    }

    private static void heapSort(int[] arr, int heapSize, int rootIndex) {
        int firstChild = rootIndex*2+1;
        int secondChild = rootIndex*2+2;
        int largestValue = arr[rootIndex];
        int largestIndex = rootIndex;
        if (firstChild < heapSize && arr[firstChild]> arr[largestIndex]){
            largestValue = arr[firstChild];
            largestIndex = firstChild;
        }
        if (secondChild < heapSize && arr[secondChild]> arr[largestIndex]) {
            largestValue = arr[secondChild];
            largestIndex = secondChild;
        }
        if(largestValue != arr[rootIndex]) {
            int temp = arr[rootIndex];
            arr[rootIndex] = largestValue;
            arr[largestIndex] = temp;
            heapSort(arr, heapSize, largestIndex);
        }
    }

    /**
     * @apiNote This method create array of random integers
     * @param min minimum value in array
     * @param max maximum value in array
     * @param qty quantity of item in array
     * @return array of integers
     */
    private static int[] getRandomArr(int min, int max, int qty) {
        Random random = new Random();
        int[]arr = new int[qty];
        for (int i = 0; i < qty; i++) {
            arr[i] = random.nextInt(min, max);
        }
        return arr;
    }

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);
        System.out.println();
    }


}