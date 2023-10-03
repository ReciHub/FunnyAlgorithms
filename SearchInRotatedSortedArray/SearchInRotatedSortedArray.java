package FunnyAlgorithms.SearchInRotatedSortedArray;

import java.util.*;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(search(arr, target));
    }

    public static int search(int[] arr, int tg) {
        int n = arr.length;

        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == tg) {
                return mid;
            }

            if (arr[l] <= arr[mid]) {
                if (tg > arr[mid] || tg < arr[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (tg < arr[mid] || tg > arr[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}
