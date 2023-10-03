package TimSortAlgorithm;

import java.util.Arrays;

public class TimSort {

    private static final int MIN_MERGE = 32;
    //for the most efficient use of timSort this can be in the range of 32 - 64

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Array: " + Arrays.toString(arr));
        timSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void timSort(int[] arr) {
        int n = arr.length;
        for (int start = 0; start < n; start += MIN_MERGE) {
            int end = Math.min((start + MIN_MERGE - 1), (n - 1));
            insertionSort(arr, start, end);
        }

        for (int size = MIN_MERGE; size < n; size = 2 * size) {
            for (int start = 0; start < n; start += 2 * size) {
                int mid = Math.min((start + size - 1), (n - 1));
                int end = Math.min((start + 2 * size - 1), (n - 1));
                if (mid < end) {
                    merge(arr, start, mid, end);
                }
            }
        }
    }

    public static void insertionSort(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= start && arr[j] > value) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int startSize = mid - start + 1;
        int endSize = end - mid;

        int[] startArr = new int[startSize];
        int[] endArr = new int[endSize];

        for (int i = 0; i < startSize; i++) {
            startArr[i] = arr[start + i];
        }
        for (int i = 0; i < endSize; i++) {
            endArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;

        while (i < startSize && j < endSize) {
            if (startArr[i] <= endArr[j]) {
                arr[k] = startArr[i];
                i++;
            } else {
                arr[k] = endArr[j];
                j++;
            }
            k++;
        }

        while (i < startSize) {
            arr[k] = startArr[i];
            i++;
            k++;
        }

        while (j < endSize) {
            arr[k] = endArr[j];
            j++;
            k++;
        }
    }
}
