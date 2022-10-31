class spiralOrder {
  public static void SpOrder( int mat[][]){
int k=0;
int l=0;
int lstrow=mat[0].length-1;
int lstcol=mat.length-1;
      while (k<=lstrow &&l<=lstcol) {
          for (int i = l; i <=lstcol; i++)
              System.out.print("|"+mat[i][k]);
              k++;

          for (int i = k; i <= lstrow; i++)
              System.out.print("|"+mat[lstcol][i]);
              lstcol--;

          if(k<=lstrow){

              for (int i = lstcol; i >=l; i--)
                  System.out.print("|"+mat[i][lstrow]);
              lstrow--;
          }
          if(l<=lstcol){
              for (int i = lstrow; i >= k; i--)
                  System.out.print("|"+mat[l][i]);
              l++;
          }

          }

      }
  public static void main(String[] args) {
    int [][] matrix = new int [4][5];
    int counter=0;
      for (int i = 0; i <matrix[0].length; i++) {
        for (int[] matrix1 : matrix) {
            matrix1[i] = counter++;
        }
      }
      /*
      _____________
      | 0| 1| 2| 3|
      -------------
      | 4| 5| 6| 7|
      -------------
      | 8| 9|10|11|
      -------------
      |12|13|14|15|
      -------------
      |16|17|18|19|
      -------------
      */
      SpOrder(matrix);//|0|1|2|3|7|11|15|19|18|17|16|12|8|4|5|6|10|14|13|9
}

}
}
