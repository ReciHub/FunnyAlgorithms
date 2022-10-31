package sorting;

import java.util.*;

public class CyclicSort {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array size: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter n Integer values ranging from 1 to n:  ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println();
        System.out.print("Array Elements Before sorting: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        sc.close();
        cyclicSort(nums);
        System.out.println();
        System.out.print("Array Elements After sorting: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
