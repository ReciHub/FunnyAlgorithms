public class dup {
    public static int supprimer_dup(int arr[], int n) {
        if (n == 0 || n == 1)
            return n;

        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++)
            if (arr[i] != arr[i + 1])
                temp[j++] = arr[i];

        temp[j++] = arr[n - 1];

        // Changing original array
        for (int i = 0; i < j; i++)
            arr[i] = temp[i];

        return j;
    }
}