public class largestOfArrays {
    public static void main(String[] args){
        int[][] arr={{5, 3, 4, 1}, {18, 22, 13, 29}, {35, 31, 41, 52}, {1016, 100, 3540, 36}};
        int[] result = largestOfArr(arr);

        for(int i=0; i<result.length; i++)
        {
            System.out.print(result[i]+" ");
        }
    }

    public static int[] largestOfArr(int[][] arr){
        int[] res = new int[arr.length];

        for(int n=0; n<arr.length; n++){
            int largestNum=arr[n][0];
            for(int sb=1; sb<arr[n].length; sb++){
                if(arr[n][sb]>largestNum){
                    largestNum=arr[n][sb];
                }
            }
            res[n]=largestNum;
        }
        return res;
    }
}