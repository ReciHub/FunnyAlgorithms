Resuelve sistemas de ecuaciones lineales por eliminación Gaussiana. matrix contiene los valores de la matriz cuadrada y result los resultados de las ecuaciones. Retorna un vector con el valor de las n incongnitas. Los resultados pueden necesitar redondeo.

import java.util.ArrayList;

static int MAX = 100;
static int n = 3;
static double matrix[][] = new double[MAX][MAX];
static double result[] = new double[MAX];

static ArrayList<Double> gauss() {
	ArrayList<Double> ans = new ArrayList<Double>();
  for(int i = 0; i < n; i++) ans.add(0.0);
  double temp;
	for (int i = 0; i < n; i++) {
    int pivot = i;
	  for (int j = i + 1; j < n; j++) {
	  	temp = Math.abs(matrix[j][i]) - Math.abs(matrix[pivot][i]);
	    if (temp > 0.000001) pivot = j;
	  }
	  double temp2[] = new double[n];
	  System.arraycopy(matrix[i],0,temp2,0,n);
	  System.arraycopy(matrix[pivot],0,matrix[i],0,n);
	  System.arraycopy(temp2,0,matrix[pivot],0,n);
	  temp = result[i];
	  result[i] = result[pivot];
	  result[pivot] = temp;  
	  if (!(Math.abs(matrix[i][i]) < 0.000001)) {	
	    for (int k = i + 1; k < n; k++) {
		   	temp = -matrix[k][i] /  matrix[i][i];
		   	matrix[k][i] = 0;
		   	for (int l = i + 1; l < n; l++) {
		     	matrix[k][l] += matrix[i][l] * temp;
		    }
	  		result[k] += result[i] * temp;
	  	}
	  }
  }
  for (int m = n - 1; m >= 0; m--) {
   	temp = result[m];
   	for (int i = n - 1; i > m; i--) {
   		temp -= ans.get(i) * matrix[m][i];
   	}
   	ans.set(m,temp / matrix[m][m]);
  }
  return ans;
}